package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.NabywcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SprzedazController {

    @Autowired
    SprzedawcaServiceImpl sprzedawcaService;

    @Autowired
    NabywcaServiceImpl nabywcaService;

    @RequestMapping("/addSprzedaz/{id}")
    public String addSprzedaz(@PathVariable(value = "id") long id, Model model) {

        Nabywca nabywca = new Nabywca();
        Sprzedaz sprzedaz = new Sprzedaz();
        Platnosc platnosc = new Platnosc();
        Sprzedawca sprzedawca = sprzedawcaService.getSprzedawcaById(id);
        model.addAttribute("sprzedawca",sprzedawca);
        model.addAttribute("nabywca", nabywca);
        model.addAttribute("sprzedaz", sprzedaz);
        model.addAttribute("platnosc", platnosc);

        final List<Usluga> listaUslug = null;
        return "formularzAktuSprzedazy";
    }

    @PostMapping("/addSprzedaz/{id}")
    public String save(@ModelAttribute("nabywca") Nabywca nabywca) {
        String nabywcaNazwa = nabywca.getNazwa();
        if(InputValidation.validateName(nabywcaNazwa)){
            nabywcaService.saveNabywca(nabywca);
            return "redirect:/";
        }
        return "redirect:/addSprzedaz/{id}";
    }

}
