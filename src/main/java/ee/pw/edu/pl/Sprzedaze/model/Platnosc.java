package ee.pw.edu.pl.Sprzedaze.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PLATNOSCI")
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "SUMA_PLN")
    private BigDecimal sumaPln;
    @Column(name = "KWOTA_SLOWNIE")
    private String kwotaSlownie;
    @NotNull
    @Column(name = "TERMIN_PLATNOSCI")
    @Temporal(TemporalType.DATE)
    private Date terminPlatnosci;
    @NotNull
    @Column(name = "FORMA_PLATNOSCI")
    private boolean formaPlatnosci;
    @NotNull
    @Column(name = "ILE_ZAPLACONO")
    private BigDecimal ileZaplacono;
    @OneToOne(mappedBy = "platnosc")
    private Sprzedaz sprzedaz;

    public long getIdPlatnosci() {
        return id;
    }

    public void setIdPlatnosci(long idPlatnosci) {
        this.id = idPlatnosci;
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

    public Date getTerminPlatnosci() {
        return terminPlatnosci;
    }

    public void setTerminPlatnosci(Date terminPlatnosci) {
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

}

