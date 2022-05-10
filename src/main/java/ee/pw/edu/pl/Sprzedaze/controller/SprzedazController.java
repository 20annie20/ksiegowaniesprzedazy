package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SprzedazController {

    @PostMapping("/addSprzedaz")
    public String processForm(Model model) {
        return "index";
    }


}
