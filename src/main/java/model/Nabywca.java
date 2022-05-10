package model;

import javax.persistence.*;

@Entity
@Table(name = "NABYWCY")
public class Nabywca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_nabywcy;
    @Column(name="NAZWA")
    private String nazwa;
    @Column(name = "ADRES")
    private String adres;

    public long getId_nabywcy() {
        return id_nabywcy;
    }

    public void setId_nabywcy(long id_nabywcy) {
        this.id_nabywcy = id_nabywcy;
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
