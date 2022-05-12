package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprzedazServiceImpl implements SprzedazService{
    @Autowired
    SprzedazRepository sprzedazRepository;

    @Override
    public List<Sprzedaz> getAllSprzedaz() {
        return sprzedazRepository.findAll();
    }

    @Override
    public void saveSprzedaz(Sprzedaz sprzedaz) {
        this.sprzedazRepository.save(sprzedaz);
    }

    @Override
    public Sprzedaz getSprzedazById(long id) {
        Optional<Sprzedaz> optional = sprzedazRepository.findById(id);
        Sprzedaz sprzedaz = null;
        if(optional.isPresent())
        {
            sprzedaz = optional.get();
        }else{
            throw new RuntimeException("Nie znaleziono sprzedazy o id= " + id);
        }
        return sprzedaz;
    }
}
