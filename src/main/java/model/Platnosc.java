package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "PLATNOSCI")
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_platnosci;
    @Column(name = "SUMA_PLN")
    private BigDecimal suma_pln;
    @Column(name = "KWOTA_SLOWNIE")
    private String kwota_slownie;
    @Column(name = "TERMIN_PLATNOSCI")
    private LocalTime termin_platnosci;
    @Column(name = "FORMA_PLATNOSCI")
    private boolean forma_platnosci;
    @Column(name = "ILE_ZAPLACONO")
    private BigDecimal ile_zaplacono;

    public long getId_platnosci() {
        return id_platnosci;
    }

    public void setId_platnosci(long id_platnosci) {
        this.id_platnosci = id_platnosci;
    }

    public BigDecimal getSuma_pln() {
        return suma_pln;
    }

    public void setSuma_pln(BigDecimal suma_pln) {
        this.suma_pln = suma_pln;
    }

    public String getKwota_slownie() {
        return kwota_slownie;
    }

    public void setKwota_slownie(String kwota_slownie) {
        this.kwota_slownie = kwota_slownie;
    }

    public LocalTime getTermin_platnosci() {
        return termin_platnosci;
    }

    public void setTermin_platnosci(LocalTime termin_platnosci) {
        this.termin_platnosci = termin_platnosci;
    }

    public boolean isForma_platnosci() {
        return forma_platnosci;
    }

    public void setForma_platnosci(boolean forma_platnosci) {
        this.forma_platnosci = forma_platnosci;
    }

    public BigDecimal getIle_zaplacono() {
        return ile_zaplacono;
    }

    public void setIle_zaplacono(BigDecimal ile_zaplacono) {
        this.ile_zaplacono = ile_zaplacono;
    }

    public Platnosc getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(Platnosc platnosc) {
        this.platnosc = platnosc;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_platnosci")
    private Platnosc platnosc;
}

