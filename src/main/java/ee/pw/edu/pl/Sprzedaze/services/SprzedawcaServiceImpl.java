package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedawcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprzedawcaServiceImpl implements SprzedawcaService{

    @Autowired
    private SprzedawcaRepository sprzedawcaRepository;

    @Override
    public List<Sprzedawca> getAllSprzedawca() {
        return sprzedawcaRepository.findAll();
    }

    @Override
    public void saveSprzedawca(Sprzedawca sprzedawca) {
        this.sprzedawcaRepository.save(sprzedawca);
    }
}
