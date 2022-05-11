package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedawcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Sprzedawca getSprzedawcaById(long id) {
        Optional<Sprzedawca> optional = sprzedawcaRepository.findById(id);
        Sprzedawca sprzedawca = null;
        if(optional.isPresent())
        {
            sprzedawca = optional.get();
        }else{
            throw new RuntimeException("Nie znaleziono sprzedawcy o id= " + id);
        }
        return sprzedawca;
    }
}
