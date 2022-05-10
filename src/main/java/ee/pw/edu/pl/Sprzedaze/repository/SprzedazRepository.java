package ee.pw.edu.pl.Sprzedaze.repository;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SprzedazRepository extends JpaRepository<Sprzedaz, Long> {
    List<Sprzedaz> findBySprzedawcaIdSprzedawcy(Long id);

    List<Sprzedaz> findAllBydataWystawienia(Date data);

    List<Sprzedaz> findAllByDataWystawieniaBetween(
            Date dataWystawieniaStart,
            Date dataWystawieniaEnd);

    @Query("select a from Sprzedaz a where a.dataWystawienia <= :dataWystawienia")
    List<Sprzedaz> findAllWithDataWystawieniaBefore(
            @Param("dataWystawienia") Date dataWystawienia);
}
