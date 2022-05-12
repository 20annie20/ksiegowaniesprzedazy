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
    private long idUslugi;
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
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "idSprzedazy")
    @JsonIgnore
    private Sprzedaz sprzedaz;

    public long getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(long idUslugi) {
        this.idUslugi = idUslugi;
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

    public boolean isNew() {
        return Long.valueOf(this.getIdUslugi()) == null;
    }
}
