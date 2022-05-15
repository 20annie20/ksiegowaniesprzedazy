package ee.pw.edu.pl.Sprzedaze.repository;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SprzedazRepository extends JpaRepository<Sprzedaz, Long> {
    List<Sprzedaz> findBySprzedawcaIdSprzedawcy(Long id);

    Sprzedaz findFirstByOrderByIdSprzedazyDesc();

    @Query(value = "SELECT u FROM Sprzedaz u WHERE u.dataWystawienia BETWEEN ?1 AND ?2")
    List<Sprzedaz> findByDataWystawieniaBetween(Date odKiedy, Date doKiedy);
}
