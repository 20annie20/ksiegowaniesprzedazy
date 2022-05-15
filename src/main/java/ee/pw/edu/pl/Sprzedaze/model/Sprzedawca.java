package ee.pw.edu.pl.Sprzedaze.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SPRZEDAWCY")
public class Sprzedawca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSprzedawcy;

    @Size(min = 1, max = 256, message="Niepoprawna wartość w polu: Nazwa.")
    @NotNull(message = "Nazwa nie może być pusta")
    @Column(name = "NAZWA")
    private String nazwa;

    @Size(min = 1, max = 256, message="Niepoprawna wartość w polu: Imię i nazwisko.")
    @NotNull(message = "Podaj imię i nazwisko sprzedawcy")
    @Column(name = "IMIENAZWISKO")
    private String imieNazwisko;

    @Size(min = 5, max = 256, message="Niepoprawna wartość w polu: Adres.")
    @NotNull(message = "Podaj adres sprzedawcy")
    @Column(name = "ADRES")
    private String adres;

    @Size(min=13, max=13, message="Niepoprawna wartość w polu: NIP.")
    @NotNull(message = "Podaj NIP sprzedawcy")
    @Column(name = "NIP")
    private String nip;

    @Size(min=11, max=11, message="Niepoprawna wartość w polu: Nr telefonu.")
    @NotNull(message = "Podaj nr telefonu sprzedawcy")
    @Column(name = "NR_TELEFONU")
    private String nrTelefonu;

    @Size(min=13, max=256, message="Niepoprawna wartość w polu: Email.")
    @Column(name = "EMAIL")
    private String email;

    @Size(min=32, max=32, message="Niepoprawna wartość w polu: Nr konta bankowego.")
    @NotNull(message = "Podaj nr konta bankowego sprzedawcy")
    @Column(name = "NR_KONTA_BANK")
    private String nrKontaBank;

    // konstruktor
    public Sprzedawca() {
    }
    public Sprzedawca(String nazwa, String imieNazwisko, String adres, String nip, String nrTelefonu, String email, String nrKontaBank) {
        this.nazwa = nazwa;
        this.imieNazwisko = imieNazwisko;
        this.adres = adres;
        this.nip = nip;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.nrKontaBank = nrKontaBank;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
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
