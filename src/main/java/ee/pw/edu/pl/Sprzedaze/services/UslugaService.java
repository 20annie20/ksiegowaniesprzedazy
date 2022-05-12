package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UslugaService {
    List<Usluga> getAllUsluga();
    void saveUsluga(Usluga usluga);
    Usluga getUslugaById(long id);
    List<Usluga> getAllUslugaByIdSprzedazy(long idSprzedazy);
    void deleteUslugaById(long id);
}
