package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;

import java.util.List;

public interface NabywcaService {
    List<Nabywca> getAllNabywca();
    void saveNabywca(Nabywca nabywca);
    Nabywca getNabywcaById(long id);
}
