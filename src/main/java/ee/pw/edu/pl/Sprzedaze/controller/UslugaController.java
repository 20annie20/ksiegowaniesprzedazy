package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import ee.pw.edu.pl.Sprzedaze.services.UslugaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/{id}/uslugi")
public class UslugaController {

    private static final String NEW_USLUGA_FORM = "formularzUslug";

    @Autowired
    UslugaServiceImpl uslugaService;

    @RequestMapping("/new")
    public String initUslugaForm(Sprzedaz sprzedaz, ModelMap model) {
        Usluga usluga = new Usluga();
        sprzedaz.addUsluga(usluga);
        model.put("usluga", usluga);
        return NEW_USLUGA_FORM;
    }
}
