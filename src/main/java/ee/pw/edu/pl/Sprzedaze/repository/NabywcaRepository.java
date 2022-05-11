package ee.pw.edu.pl.Sprzedaze.repository;

import ee.pw.edu.pl.Sprzedaze.model.Nabywca;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NabywcaRepository extends JpaRepository<Nabywca, Long> {
    List<Nabywca> findByNazwaContaining(String nazwa);
    List<Nabywca> findByNip(long nip);
    List<Nabywca> findByNazwa(String nazwa);
}
