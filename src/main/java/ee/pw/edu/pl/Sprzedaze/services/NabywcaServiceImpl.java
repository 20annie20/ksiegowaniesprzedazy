package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Platnosc;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.repository.NabywcaRepository;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedawcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NabywcaServiceImpl implements NabywcaService{

    @Autowired
    private NabywcaRepository nabywcaRepository;

    @Override
    public List<Nabywca> getAllNabywca() {
        return nabywcaRepository.findAll();
    }

    @Override
    public void saveNabywca(Nabywca nabywca) {
        this.nabywcaRepository.save(nabywca);
    }

    @Override
    public Nabywca getNabywcaById(long id) {
        Optional<Nabywca> optional = nabywcaRepository.findById(id);
        Nabywca nabywca = null;
        if(optional.isPresent())
        {
            nabywca = optional.get();
        }else{
            throw new RuntimeException("Nie znaleziono nabywcy o id= " + id);
        }
        return nabywca;
    }

    @Override
    public void updateNabywca(int idSprzedazy, Nabywca nabywca) {
        Nabywca nabywcaToUpdate = nabywcaRepository.getById((long) idSprzedazy);
        nabywcaToUpdate.setNazwa(nabywca.getNazwa());
        nabywcaToUpdate.setAdres(nabywca.getAdres());
        nabywcaRepository.save(nabywcaToUpdate);

    }
}
