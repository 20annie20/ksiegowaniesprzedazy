package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Platnosc;

import java.util.List;

public interface PlatnoscService {
    List<Platnosc> getAllNabywca();
    void savePlatnosc(Platnosc platnosc);
    Platnosc getPlatnoscById(long id);

    // TODO CHANGE TO MAPPER
    void updatePlatnosc(long id, Platnosc platnosc);
}
