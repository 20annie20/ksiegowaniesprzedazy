package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Platnosc;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.services.*;
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
    @Autowired
    NabywcaServiceImpl nabywcaService;
    @Autowired
    PlatnoscServiceImpl platnoscService;


}
