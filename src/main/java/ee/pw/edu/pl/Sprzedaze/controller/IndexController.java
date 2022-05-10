package ee.pw.edu.pl.Sprzedaze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping("/addSprzedaz")
    public String tworzSprzedaz() {
        return "tworzSprzedaz";
    }


}
