package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;

import java.util.List;

public interface SprzedazService {
    List<Sprzedaz> getAllSprzedaz();
    void saveSprzedaz(Sprzedaz sprzedaz);
    Sprzedaz getSprzedazById(long id);
}
