package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.NabywcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedazServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.UslugaServiceImpl;
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
    UslugaServiceImpl uslugaService;

    public static int idSprzedazy = 0;

    @RequestMapping("/addSprzedaz")
    public String addSprzedaz(@PathVariable(value = "id") long id, Model model) {

        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        model.addAttribute("sprzedawca",sprzedawca);

        Nabywca nabywca = new Nabywca();
        Sprzedaz sprzedaz = new Sprzedaz();
        Platnosc platnosc = new Platnosc();

        if(idSprzedazy > 0)
        {
            sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
        }

        nabywcaService.saveNabywca(nabywca);
        sprzedaz.setNabywca(nabywca);
        sprzedaz.setSprzedawca(sprzedawca);

        model.addAttribute("idSprzedazy", sprzedaz.getIdSprzedazy());
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

    @PostMapping("/addSprzedaz")
    public String save(@ModelAttribute("nabywca") Nabywca nabywca, @ModelAttribute("sprzedaz")Sprzedaz sprzedaz,
                             Model model, @PathVariable("id") long idSprzedawcy, RedirectAttributes redirectAttributes) {
        String nabywcaNazwa = nabywca.getNazwa();
        idSprzedazy++;
        if(InputValidation.validateName(nabywcaNazwa)){
            nabywcaService.saveNabywca(nabywca);
            sprzedaz.setNabywca(nabywca);
            sprzedaz.setSprzedawca(sprzedawcaService.getSprzedawcaById(idSprzedawcy));

            if(sprzedaz.getDataWystawienia() == null)
            {
                sprzedaz.setDataWystawienia(new Date());
            }
            String data = sprzedaz.getDataWystawienia().toString();

            sprzedaz.setNrRachunku(sprzedaz.getIdSprzedazy() + "/" + data.substring(data.lastIndexOf(" ") + 1));
            System.out.println("Redirecting to generate formularz");
            System.out.println(idSprzedawcy + " " + sprzedaz.getIdSprzedazy());

            sprzedazService.saveSprzedaz(sprzedaz);

            return "redirect:/";
        }
        // TODO POPUP INVALID NABYWCA
        System.out.println("Popup invalid nabywca");
        redirectAttributes.addFlashAttribute("message", "Nie podano nazwy nabywcy...");
        return "redirect:/sprzedawca/{id}/addSprzedaz";
    }
}
