package ee.pw.edu.pl.Sprzedaze.repository;

import ee.pw.edu.pl.Sprzedaze.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
    // TODO List<Usluga> findAllByIdSprzedazy(Long IdSprzedazy);
}
