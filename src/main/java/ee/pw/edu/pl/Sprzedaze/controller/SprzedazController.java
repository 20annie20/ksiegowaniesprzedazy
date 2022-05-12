package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("sprzedawca/{id}")
@Controller
public class SprzedazController {

    @Autowired
    SprzedawcaServiceImpl sprzedawcaService;

    @Autowired
    NabywcaServiceImpl nabywcaService;

    @Autowired
    SprzedazServiceImpl sprzedazService;

    @Autowired
    PlatnoscServiceImpl platnoscService;

    @Autowired
    UslugaServiceImpl uslugaService;

    public static int idSprzedazy = 0;

    @RequestMapping(value="/addSprzedaz", method=RequestMethod.GET)
    public String addSprzedaz(@PathVariable(value = "id") long id, Model model) {

        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        model.addAttribute("sprzedawca",sprzedawca);

        Nabywca nabywca = new Nabywca();
        Sprzedaz sprzedaz = new Sprzedaz();
        Platnosc platnosc = new Platnosc();

        // TODO get rid of this id counter, it's not safe
        if(idSprzedazy > 0)
        {
            sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
            nabywca = nabywcaService.getNabywcaById(idSprzedazy);
            platnosc = platnoscService.getPlatnoscById(idSprzedazy);
        }
        else
            idSprzedazy++;

        nabywcaService.saveNabywca(nabywca);
        platnoscService.savePlatnosc(platnosc);
        sprzedaz.setNabywca(nabywca);
        sprzedaz.setSprzedawca(sprzedawca);
        sprzedaz.setPlatnosc(platnosc);

        model.addAttribute("sprzedaz", sprzedaz);
        model.addAttribute("platnosc", platnosc);
        model.addAttribute("nabywca", nabywca);

        sprzedazService.saveSprzedaz(sprzedaz);

        Usluga usluga = new Usluga();

        model.addAttribute("usluga", usluga);

        final List<Usluga> listaUslug = uslugaService.getAllUsluga();
        model.addAttribute("listUsluga", listaUslug);

        final BigDecimal sumaWartosc = uslugaService.getSumWartoscWhereSprzedaz(sprzedaz);
        double suma = sumaWartosc.doubleValue();
        DecimalFormat f = new DecimalFormat("#0.00");
        model.addAttribute("sumaWartosc", f.format(suma) + " PLN");
        return "formularzDowoduSprzedazy";
    }

    @RequestMapping(value="/addSprzedaz", method=RequestMethod.POST)
    public String save(@ModelAttribute("nabywca") Nabywca nabywca,
                       @ModelAttribute("sprzedaz")Sprzedaz sprzedaz,
                       @ModelAttribute("platnosc") Platnosc platnosc,
                       Model model,
                       @PathVariable("id") long idSprzedawcy,
                       RedirectAttributes redirectAttributes) {

        String nabywcaNazwa = nabywca.getNazwa();
        platnoscService.savePlatnosc(platnosc);
        nabywcaService.saveNabywca(nabywca);
        if(InputValidation.validateName(nabywcaNazwa)){
            nabywcaService.saveNabywca(nabywca);
            sprzedaz.setNabywca(nabywca);
            sprzedaz.setSprzedawca(sprzedawcaService.getSprzedawcaById(idSprzedawcy));

            if(sprzedaz.getDataWystawienia() == null)
            {
                sprzedaz.setDataWystawienia(new Date());
            }
            String data = sprzedaz.getDataWystawienia().toString();

            sprzedaz.setNrRachunku(idSprzedawcy + "/" +idSprzedazy + "/" + data.substring(data.lastIndexOf(" ") + 1));
            System.out.println(idSprzedawcy + " " + sprzedaz.getIdSprzedazy());
            sprzedazService.saveSprzedaz(sprzedaz);
            idSprzedazy = (int) sprzedaz.getIdSprzedazy();
            return "redirect:/sprzedawca/{id}/addSprzedaz";
        }
        // TODO POPUP INVALID NABYWCA
        System.out.println("Popup invalid nabywca");
        redirectAttributes.addFlashAttribute("message", "Nie podano nazwy nabywcy...");
        return "redirect:/sprzedawca/{id}/addSprzedaz";
    }

    @RequestMapping(value="/generate", method=RequestMethod.GET)
    public String generateReport(){
        System.out.println("Redirecting to generate formularz");
        return "redirect:/";
    }


    @PostMapping("sprzedaz/{idSprzedazy}/addUsluga")
    public String addUsluga(@ModelAttribute("usluga") Usluga usluga,
                                 @ModelAttribute("nabywca") Nabywca nabywca,
                                 @ModelAttribute("sprzedaz")Sprzedaz sprzedaz,
                                 @ModelAttribute("platnosc") Platnosc platnosc,
                                 @PathVariable("idSprzedazy") Long id,
                                 HttpServletRequest request, Model model) {

        System.out.println(platnosc.isFormaPlatnosci());

        Platnosc platnosc1 = platnoscService.getPlatnoscById(id);
        platnosc1.setFormaPlatnosci(platnosc.isFormaPlatnosci());
        platnoscService.savePlatnosc(platnosc1);

        //nabywcaService.saveNabywca(nabywca);
        //sprzedazService.saveSprzedaz(sprzedaz);
        // TODO refactor validation because this one is very messy
        if(usluga.getCenaJednostki() == null) {
            String referer = request.getHeader("Referer");
            SprzedazController.idSprzedazy = Math.toIntExact(id);
            return "redirect:" + referer;
        }

        model.addAttribute("usluga", usluga);
        sprzedaz = sprzedazService.getSprzedazById(id);
        usluga.setSprzedaz(sprzedaz);
        usluga.setWartosc(usluga.getCenaJednostki().multiply(BigDecimal.valueOf(usluga.getIloscJednostek())));

        sprzedazService.saveSprzedaz(sprzedaz);
        uslugaService.saveUsluga(usluga);

        String referer = request.getHeader("Referer");
        SprzedazController.idSprzedazy = Math.toIntExact(id);
        return "redirect:" + referer;
    }

    @DeleteMapping("/{idUslugi}")
    public void deleteUsluga(@RequestParam("idUslugi") Long idUslugi) {
        uslugaService.deleteUslugaById(idUslugi);
    }
}
