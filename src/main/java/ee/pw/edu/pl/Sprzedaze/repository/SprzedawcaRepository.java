package ee.pw.edu.pl.Sprzedaze.repository;
import java.util.List;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprzedawcaRepository extends JpaRepository<Sprzedawca, Long> {
    // TODO określić potrzebne metody, np. znajdowanie po fragmencie nazwy, adresie, itd.
    List<Sprzedawca> findByNazwaContaining(String nazwa);
    List<Sprzedawca> findByNip(long nip);
}
