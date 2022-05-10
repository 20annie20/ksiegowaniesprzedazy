package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRZEDAWCY")
public class Sprzedawca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sprzedawcy;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "NIP")
    private long nip;
    @Column(name = "NR_TELEFONU")
    private String nr_telefonu;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NR_KONTA_BANK")
    private long nr_konta_bank;

    // konstruktor
    public Sprzedawca() {
    }
    public Sprzedawca(String nazwa, String adres, long nip, String nr_telefonu, String email, long nr_konta_bank) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nip = nip;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.nr_konta_bank = nr_konta_bank;
    }

    public long getId_sprzedawcy() {
        return id_sprzedawcy;
    }

    public void setId_sprzedawcy(long id_sprzedawcy) {
        this.id_sprzedawcy = id_sprzedawcy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNr_konta_bank() {
        return nr_konta_bank;
    }

    public void setNr_konta_bank(long nr_konta_bank) {
        this.nr_konta_bank = nr_konta_bank;
    }

    @Override
    public String toString() {
        return "Sprzedawca [id=" + id_sprzedawcy + ", nazwa=" + nazwa + ", adres=" + adres + ", NIP=" + nip + ", " +
                "nr_tel=" + nr_telefonu + ", email=" + email + "nr_konta=" + nr_konta_bank + "]";
    }
}
