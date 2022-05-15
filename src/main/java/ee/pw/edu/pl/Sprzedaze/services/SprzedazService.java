package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;

import java.util.Date;
import java.util.List;

public interface SprzedazService {
    List<Sprzedaz> getSprzedazByIdSprzedawcy(Long id);
    void saveSprzedaz(Sprzedaz sprzedaz);
    Sprzedaz getSprzedazById(long id);
    Sprzedaz getLastSprzedaz();
    List<Sprzedaz> getSprzedazByIdSprzedawcyBetweenDataWystawienia(Date dateTo, Date dateFromDate, Long id);
}
