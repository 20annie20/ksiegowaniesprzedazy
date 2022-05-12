package ee.pw.edu.pl.Sprzedaze.services;

import ee.pw.edu.pl.Sprzedaze.model.Platnosc;
import ee.pw.edu.pl.Sprzedaze.repository.PlatnoscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatnoscServiceImpl implements PlatnoscService {

    @Autowired
    PlatnoscRepository platnoscRepository;

    @Override
    public List<Platnosc> getAllNabywca() {
        return null;
    }

    @Override
    public void savePlatnosc(Platnosc platnosc) {
        this.platnoscRepository.save(platnosc);
    }

    @Override
    public Platnosc getPlatnoscById(long id) {

        return platnoscRepository.getById(id);
    }
}
