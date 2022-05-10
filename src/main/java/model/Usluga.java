package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "USLUGI")
public class Usluga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_uslugi;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "JEDNOSTKA_MIARY")
    private String jednostka_miary;
    @Column(name = "ILOSC_JEDNOSTEK")
    private int ilosc_jednostek;
    @Column(name = "CENA_JEDNOSTKI")
    private BigDecimal cena_jednostki;
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

    public String getJednostka_miary() {
        return jednostka_miary;
    }

    public void setJednostka_miary(String jednostka_miary) {
        this.jednostka_miary = jednostka_miary;
    }

    public int getIlosc_jednostek() {
        return ilosc_jednostek;
    }

    public void setIlosc_jednostek(int ilosc_jednostek) {
        this.ilosc_jednostek = ilosc_jednostek;
    }

    public BigDecimal getCena_jednostki() {
        return cena_jednostki;
    }

    public void setCena_jednostki(BigDecimal cena_jednostki) {
        this.cena_jednostki = cena_jednostki;
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
