package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.ReportGenerator;
import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.*;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public boolean newSale = true;
    public DateRange tempDateRange = new DateRange();

    @RequestMapping(value="/addSprzedaz", method=RequestMethod.GET)
    public String addSprzedaz(@PathVariable(value = "id") long id, Model model) {

        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        Date dataWystawienia = new Date();
        model.addAttribute("sprzedawca", sprzedawca);
        model.addAttribute("dataWystawienia", dataWystawienia);

        Nabywca nabywca;
        Sprzedaz sprzedaz;
        Platnosc platnosc;

        if(newSale) {
            nabywca = new Nabywca();
            sprzedaz = new Sprzedaz();
            platnosc = new Platnosc();
            idSprzedazy += 1;
        } else {
            System.out.println("ID SPRZEDAZY: " + idSprzedazy);
            sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
            nabywca = nabywcaService.getNabywcaById(idSprzedazy);
            platnosc = platnoscService.getPlatnoscById(idSprzedazy);
        }

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

        final List<Usluga> listaUslug = uslugaService.getAllUslugaByIdSprzedazy(sprzedaz);
        model.addAttribute("listUsluga", listaUslug);

        final BigDecimal sumaWartosc = uslugaService.getSumWartoscWhereSprzedaz(sprzedaz);
        double suma = sumaWartosc.doubleValue();

        DecimalFormat f = new DecimalFormat("#0.00");
        model.addAttribute("sumaWartosc", f.format(suma) + " PLN");
        newSale = true;
        return "formularzDowoduSprzedazy";
    }

    @RequestMapping(value="/addSprzedaz", method=RequestMethod.POST)
    public String save(@ModelAttribute("nabywca") Nabywca nabywcaData,
                       @ModelAttribute("sprzedaz") Sprzedaz sprzedazData,
                       @ModelAttribute("platnosc") Platnosc platnoscData,
                       Model model,
                       @PathVariable("id") long idSprzedawcy,
                       RedirectAttributes redirectAttributes) {
        newSale = false;

        platnoscService.updatePlatnosc(idSprzedazy, platnoscData);
        nabywcaService.updateNabywca(idSprzedazy, nabywcaData);

        Sprzedaz sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
        Platnosc platnosc = platnoscService.getPlatnoscById(idSprzedazy);
        final BigDecimal sumaWartosc = uslugaService.getSumWartoscWhereSprzedaz(sprzedaz);
        platnosc.setSumaPln(sumaWartosc);
        Nabywca nabywca = nabywcaService.getNabywcaById(idSprzedazy);

        if(sprzedazData.getDataWystawienia() == null)
        {
            sprzedaz.setDataWystawienia(new Date());
        }else
            sprzedaz.setDataWystawienia(sprzedazData.getDataWystawienia());

        String data = sprzedaz.getDataWystawienia().toString();
        sprzedaz.setNrRachunku(idSprzedawcy + "/" +idSprzedazy + "/" + data.substring(data.lastIndexOf(" ") + 1));

        sprzedaz.setPlatnosc(platnosc);

        sprzedaz.setSprzedawca(sprzedawcaService.getSprzedawcaById(idSprzedawcy));

        String nabywcaNazwa = nabywca.getNazwa();
        if(InputValidation.validateName(nabywcaNazwa)){
            sprzedaz.setNabywca(nabywca);
        } else {
            System.out.println("Popup invalid nabywca");
            redirectAttributes.addFlashAttribute("message", "Nie podano nazwy nabywcy...");
        }
        sprzedazService.saveSprzedaz(sprzedaz);
        System.out.println("PO ZAPISANIU ID SPRZEDAZY: " + sprzedaz.getIdSprzedazy());
        return "redirect:/sprzedawca/{id}/addSprzedaz";
    }

    @RequestMapping(value="/zestawienie", method=RequestMethod.GET)
    public String generateSummary(@PathVariable(value = "id") long id,
                                 Model model) throws Docx4JException {
        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        DateRange dateRange = new DateRange();
        dateRange.setDateFrom(new Date());
        dateRange.setDateTo(new Date());
        model.addAttribute("dateRange", dateRange);
        model.addAttribute("sprzedawca", sprzedawca);
        model.addAttribute("tempDateRange", tempDateRange);

        List<Sprzedaz> listaSprzedazy;
        if (tempDateRange.getDateFrom() == null || tempDateRange.getDateTo() == null){
            listaSprzedazy = sprzedazService.getSprzedazByIdSprzedawcy(id);
        } else {
            listaSprzedazy = sprzedazService.getSprzedazByIdSprzedawcyBetweenDataWystawienia(tempDateRange.getDateFrom(),
                    tempDateRange.getDateTo(), id);
        }

        model.addAttribute("listaSprzedazyZaOkres", listaSprzedazy);
        System.out.println("Redirecting to generate formularz");
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.GenerateRaport(listaSprzedazy);
        return "summary";
    }

    @RequestMapping(value="/zestawienie", method=RequestMethod.POST)
    public String changeDateRange(@PathVariable(value = "id") long id,
                                  @ModelAttribute("dateRange") DateRange dateRange,
                                  Model model) {
        tempDateRange.setDateTo(dateRange.getDateTo());
        tempDateRange.setDateFrom(dateRange.getDateFrom());
        return "redirect:/sprzedawca/{id}/zestawienie";
    }


    @PostMapping("sprzedaz/{idSprzedazy}/addUsluga")
    public String addUsluga(@ModelAttribute("usluga") Usluga usluga,
                                 @ModelAttribute("nabywca") Nabywca nabywca,
                                 @ModelAttribute("sprzedaz")Sprzedaz sprzedaz,
                                 @ModelAttribute("platnosc") Platnosc platnosc,
                                 @PathVariable("idSprzedazy") Long id,
                                 HttpServletRequest request, Model model) {
        newSale = false;

        // TODO refactor validation because this one is very messy
        if(usluga.getCenaJednostki() == null) {
            String referer = request.getHeader("Referer");
            SprzedazController.idSprzedazy = Math.toIntExact(id);
            return "redirect:" + referer;
        }

        model.addAttribute("usluga", usluga);

        sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
        usluga.setSprzedaz(sprzedaz);
        usluga.setWartosc(usluga.getCenaJednostki().multiply(BigDecimal.valueOf(usluga.getIloscJednostek())));

        uslugaService.saveUsluga(usluga);

        String referer = request.getHeader("Referer");
        SprzedazController.idSprzedazy = Math.toIntExact(id);
        return "redirect:" + referer;
    }

    @DeleteMapping("sprzedaz/{idSprzedazy}/usunUsluga/{idUslugi}")
    public void deleteUsluga(@RequestParam("idUslugi") Long idUslugi) {
        uslugaService.deleteUslugaById(idUslugi);
    }

    @RequestMapping(value="/generate/{idSprzedazy}", method = RequestMethod.POST)
    public String generateDokument(@PathVariable(value = "idSprzedazy") long idSprzedazy,
                                   @PathVariable(value = "id") long id) throws Docx4JException {
        Sprzedaz sprzedaz = sprzedazService.getSprzedazById(idSprzedazy);
        Platnosc platnosc = platnoscService.getPlatnoscById(idSprzedazy);
        Nabywca nabywca = nabywcaService.getNabywcaById(idSprzedazy);
        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        List<Usluga> uslugaList = uslugaService.getAllUslugaByIdSprzedazy(sprzedaz);

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.GenerateDokumentSprzedazy(sprzedaz, platnosc, nabywca, sprzedawca, uslugaList);
        return "redirect:/";
    }
}
