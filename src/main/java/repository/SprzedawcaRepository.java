package repository;
import java.util.List;

import model.Sprzedawca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SprzedawcaRepository extends JpaRepository<Sprzedawca, Long> {
    // TODO określić potrzebne metody, np. znajdowanie po fragmencie nazwy, adresie, itd.
    List<Sprzedawca> findByNazwaContaining(String nazwa);
    List<Sprzedawca> findByNIP(long nip);
}
