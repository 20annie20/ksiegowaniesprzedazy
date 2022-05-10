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
    private long idSprzedawcy;
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "NIP")
    private long nip;
    @Column(name = "NR_TELEFONU")
    private String nrTelefonu;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NR_KONTA_BANK")
    private long nrKontaBank;

    // konstruktor
    public Sprzedawca() {
    }
    public Sprzedawca(String nazwa, String adres, long nip, String nrTelefonu, String email, long nrKontaBank) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nip = nip;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.nrKontaBank = nrKontaBank;
    }

    public long getIdSprzedawcy() {
        return idSprzedawcy;
    }

    public void setIdSprzedawcy(long idSprzedawcy) {
        this.idSprzedawcy = idSprzedawcy;
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

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNrKontaBank() {
        return nrKontaBank;
    }

    public void setNrKontaBank(long nrKontaBank) {
        this.nrKontaBank = nrKontaBank;
    }

    @Override
    public String toString() {
        return "Sprzedawca [id=" + idSprzedawcy + ", nazwa=" + nazwa + ", adres=" + adres + ", NIP=" + nip + ", " +
                "nr_tel=" + nrTelefonu + ", email=" + email + "nr_konta=" + nrKontaBank + "]";
    }
}
