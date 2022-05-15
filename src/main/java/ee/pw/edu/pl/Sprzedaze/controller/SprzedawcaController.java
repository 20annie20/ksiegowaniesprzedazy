package ee.pw.edu.pl.Sprzedaze.controller;

import com.sun.istack.NotNull;
import ee.pw.edu.pl.Sprzedaze.InputValidation;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaService;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class SprzedawcaController {

    @Autowired
    SprzedawcaServiceImpl sprzedawcaService;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("Going to the main page");
        final List<Sprzedawca> lista = sprzedawcaService.getAllSprzedawca();
        model.addAttribute("listSprzedawca", lista);
        return "index";
    }

    @RequestMapping("/addSprzedawca")
    public String addSprzedawca(Model model) {
        System.out.println("Idz do dodawania sprzedawcy");
        Sprzedawca sprzedawca = new Sprzedawca();
        model.addAttribute("sprzedawca", sprzedawca);
        return "formularzSprzedawcy";
    }

    @PostMapping("/addSprzedawca")
    public String save(@ModelAttribute("sprzedawca") Sprzedawca sprzedawca)
    {
        if(InputValidation.validateName(sprzedawca.getNazwa())){
            sprzedawcaService.saveSprzedawca(sprzedawca);
            return "redirect:/";
        }
        else {
            System.out.println("Sprzedawca o podanej nazwie istnieje");
            return "redirect:/addSprzedawca";
        }
    }
}
