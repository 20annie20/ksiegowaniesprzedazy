package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.SprzedazServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.UslugaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class UslugaController {

    private static final String NEW_USLUGA_FORM = "formularzUslug";

    @Autowired
    UslugaServiceImpl uslugaService;
    @Autowired
    SprzedazServiceImpl sprzedazService;

    @PostMapping("sprzedaz/{idSprzedazy}/addUsluga")
    public String initUslugaForm(@ModelAttribute("usluga") Usluga usluga, @PathVariable("idSprzedazy") Long id,
                                 HttpServletRequest request, Model model) {

        // TODO refactor validation because this one is very messy
        if(usluga.getCenaJednostki() == null) {
            String referer = request.getHeader("Referer");
            SprzedazController.idSprzedazy = Math.toIntExact(id);
            return "redirect:" + referer;
        }

        model.addAttribute("usluga", usluga);
        Sprzedaz sprzedaz = sprzedazService.getSprzedazById(id);
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
