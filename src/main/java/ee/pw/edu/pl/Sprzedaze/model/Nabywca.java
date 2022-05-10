package ee.pw.edu.pl.Sprzedaze.model;

import javax.persistence.*;

@Entity
@Table(name = "NABYWCY")
public class Nabywca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNabywcy;
    @Column(name="NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;

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

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    @Column(name = "NIP")
    private long nip;
}
