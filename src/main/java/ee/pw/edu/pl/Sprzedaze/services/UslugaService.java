package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;

import java.math.BigDecimal;
import java.util.List;

public interface UslugaService {
    List<Usluga> getAllUsluga();
    void saveUsluga(Usluga usluga);
    Usluga getUslugaById(long id);
    List<Usluga> getAllUslugaByIdSprzedazy(Sprzedaz sprzedaz);
    void deleteUslugaById(long id);
    Usluga findUslugaByNazwa(String nazwa);
    BigDecimal getSumWartoscWhereSprzedaz(Sprzedaz sprzedaz);
}
