package ee.pw.edu.pl.Sprzedaze.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "NABYWCY")
public class Nabywca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNabywcy;
    @NotNull
    @Column(name="NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "NIP")
    private String nip;

    public long getIdNabywcy() {
        return idNabywcy;
    }

    public void setIdNabywcy(long idNabywcy) {
        this.idNabywcy = idNabywcy;
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
}
