package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.NabywcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedazServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.UslugaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("/addSprzedaz")
    public String addSprzedaz(@PathVariable(value = "id") long id, Model model) {

        Nabywca nabywca = new Nabywca();
        Sprzedaz sprzedaz = new Sprzedaz();
        Platnosc platnosc = new Platnosc();
        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        model.addAttribute("sprzedawca",sprzedawca);
        model.addAttribute("nabywca", nabywca);
        model.addAttribute("sprzedaz", sprzedaz);
        model.addAttribute("platnosc", platnosc);

        //zapisuję już przy tworzeniu, żeby dynamicznie ładować listę usług
        nabywcaService.saveNabywca(nabywca);
        sprzedaz.setNabywca(nabywca);
        sprzedaz.setSprzedawca(sprzedawca);
        sprzedazService.saveSprzedaz(sprzedaz);
        System.out.println(sprzedaz.getIdSprzedazy());

        final List<Usluga> listaUslug = uslugaService.getAllUsluga();
        System.out.println(listaUslug);
        model.addAttribute("listUsluga", listaUslug);
        return "formularzAktuSprzedazy";
    }

    @GetMapping

    @DeleteMapping("/{idUslugi}")
    public void deleteUsluga(@RequestParam("idUslugi") Long idUslugi) {
        uslugaService.deleteUslugaById(idUslugi);
    }

    @PostMapping("/addSprzedaz")
    public String save(@ModelAttribute("nabywca") Nabywca nabywca, @ModelAttribute("sprzedaz")Sprzedaz sprzedaz,
                             Model model, @PathVariable("id") long idSprzedawcy, RedirectAttributes redirectAttributes) {
        String nabywcaNazwa = nabywca.getNazwa();
        if(InputValidation.validateName(nabywcaNazwa)){
            nabywcaService.saveNabywca(nabywca);
            sprzedaz.setNabywca(nabywca);
            sprzedaz.setSprzedawca(sprzedawcaService.getSprzedawcaById(idSprzedawcy));


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
