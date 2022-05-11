package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SprzedawcaService {
    List<Sprzedawca> getAllSprzedawca();
    void saveSprzedawca(Sprzedawca sprzedawca);
    Sprzedawca getSprzedawcaById(long id);
}
