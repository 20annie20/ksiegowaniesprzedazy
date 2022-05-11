package ee.pw.edu.pl.Sprzedaze.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USLUGI")
public class Usluga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_uslugi;
    @NotNull
    @Column(name = "NAZWA")
    private String nazwa;
    @NotNull
    @Column(name = "JEDNOSTKA_MIARY")
    private String jednostkaMiary;
    @NotNull
    @Column(name = "ILOSC_JEDNOSTEK")
    private int iloscJednostek;
    @NotNull
    @Column(name = "CENA_JEDNOSTKI")
    private BigDecimal cenaJednostki;
    @NotNull
    @Column(name = "WARTOSC")
    private BigDecimal wartosc;

    public long getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(long id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getJednostkaMiary() {
        return jednostkaMiary;
    }

    public void setJednostkaMiary(String jednostkaMiary) {
        this.jednostkaMiary = jednostkaMiary;
    }

    public int getIloscJednostek() {
        return iloscJednostek;
    }

    public void setIloscJednostek(int iloscJednostek) {
        this.iloscJednostek = iloscJednostek;
    }

    public BigDecimal getCenaJednostki() {
        return cenaJednostki;
    }

    public void setCenaJednostki(BigDecimal cenaJednostki) {
        this.cenaJednostki = cenaJednostki;
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    public Sprzedaz getSprzedaz() {
        return sprzedaz;
    }

    public void setSprzedaz(Sprzedaz sprzedaz) {
        this.sprzedaz = sprzedaz;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_sprzedazy")
    @JsonIgnore
    private Sprzedaz sprzedaz;
}
