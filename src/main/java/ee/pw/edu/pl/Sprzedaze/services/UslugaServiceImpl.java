package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UslugaServiceImpl implements UslugaService{

    @Autowired
    private UslugaRepository uslugaRepository;

    @Override
    public List<Usluga> getAllUsluga() {
        return uslugaRepository.findAll();
    }

    @Override
    public void saveUsluga(Usluga usluga) {
        this.uslugaRepository.save(usluga);
    }

    @Override
    public Usluga getUslugaById(long id) {
        Optional<Usluga> optional = uslugaRepository.findById(id);
        Usluga usluga = null;
        if(optional.isPresent())
        {
            usluga = optional.get();
        }else{
            throw new RuntimeException("Nie znaleziono uslugi o id= " + id);
        }
        return usluga;
    }

    @Override
    public List<Usluga> getAllUslugaByIdSprzedazy(long idSprzedazy) {
        //TODO implement
        return null;
    }

    @Override
    public void deleteUslugaById(long id) {
        uslugaRepository.deleteById(id);
    }
}
