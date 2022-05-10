package ee.pw.edu.pl.Sprzedaze.model;

import com.sun.istack.NotNull;

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
    @NotNull
    @Column(name = "NAZWA")
    private String nazwa;
    @NotNull
    @Column(name = "ADRES")
    private String adres;
    @NotNull
    @Column(name = "NIP")
    private String nip;
    @NotNull
    @Column(name = "NR_TELEFONU")
    private String nrTelefonu;
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "NR_KONTA_BANK")
    private String nrKontaBank;

    // konstruktor
    public Sprzedawca() {
    }
    public Sprzedawca(String nazwa, String adres, String nip, String nrTelefonu, String email, String nrKontaBank) {
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
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

    public String getNrKontaBank() {
        return nrKontaBank;
    }

    public void setNrKontaBank(String nrKontaBank) {
        this.nrKontaBank = nrKontaBank;
    }

    @Override
    public String toString() {
        return "Sprzedawca [id=" + idSprzedawcy + ", nazwa=" + nazwa + ", adres=" + adres + ", NIP=" + nip + ", " +
                "nr_tel=" + nrTelefonu + ", email=" + email + "nr_konta=" + nrKontaBank + "]";
    }
}
