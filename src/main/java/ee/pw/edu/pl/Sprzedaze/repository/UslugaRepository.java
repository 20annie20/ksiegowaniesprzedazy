package ee.pw.edu.pl.Sprzedaze.repository;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
    List<Usluga> findByNazwa(String nazwa);
    List<Usluga> findAllBySprzedaz(Sprzedaz sprzedaz);
}
