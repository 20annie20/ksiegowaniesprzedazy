package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import ee.pw.edu.pl.Sprzedaze.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
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
    public List<Usluga> getAllUslugaByIdSprzedazy(Sprzedaz sprzedaz) {
        return uslugaRepository.findAllBySprzedaz(sprzedaz);
    }

    @Override
    public void deleteUslugaById(long id) {
        uslugaRepository.deleteById(id);
    }

    @Override
    public Usluga findUslugaByNazwa(String nazwa) {
        return uslugaRepository.findByNazwa(nazwa).get(0);
    }

    @Override
    public BigDecimal getSumWartoscWhereSprzedaz(Sprzedaz sprzedaz) {
        List<Usluga> lista = uslugaRepository.findAllBySprzedaz(sprzedaz);
        double suma = 0.0;

        for (Usluga usluga : lista) {
            suma += usluga.getWartosc().doubleValue();
        }
        return new BigDecimal(suma);
    }

}
