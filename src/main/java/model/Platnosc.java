package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "PLATNOSCI")
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlatnosci;
    @Column(name = "SUMA_PLN")
    private BigDecimal sumaPln;
    @Column(name = "KWOTA_SLOWNIE")
    private String kwotaSlownie;
    @Column(name = "TERMIN_PLATNOSCI")
    private LocalTime terminPlatnosci;
    @Column(name = "FORMA_PLATNOSCI")
    private boolean formaPlatnosci;
    @Column(name = "ILE_ZAPLACONO")
    private BigDecimal ileZaplacono;

    public long getIdPlatnosci() {
        return idPlatnosci;
    }

    public void setIdPlatnosci(long idPlatnosci) {
        this.idPlatnosci = idPlatnosci;
    }

    public BigDecimal getSumPln() {
        return sumaPln;
    }

    public void setSumaPln(BigDecimal suma_pln) {
        this.sumaPln = suma_pln;
    }

    public String getKwotaSlownie() {
        return kwotaSlownie;
    }

    public void setKwotaSlownie(String kwotaSlownie) {
        this.kwotaSlownie = kwotaSlownie;
    }

    public LocalTime getTerminPlatnosci() {
        return terminPlatnosci;
    }

    public void setTerminPlatnosci(LocalTime terminPlatnosci) {
        this.terminPlatnosci = terminPlatnosci;
    }

    public boolean isFormaPlatnosci() {
        return formaPlatnosci;
    }

    public void setFormaPlatnosci(boolean formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
    }

    public BigDecimal getIleZaplacono() {
        return ileZaplacono;
    }

    public void setIleZaplacono(BigDecimal ileZaplacono) {
        this.ileZaplacono = ileZaplacono;
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

