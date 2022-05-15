package ee.pw.edu.pl.Sprzedaze.model;

import com.sun.istack.NotNull;
import ee.pw.edu.pl.Sprzedaze.converter.BooleanToIntConverter;
import ee.pw.edu.pl.Sprzedaze.converter.BooleanToStringConverter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(min = 5, max = 1024, message="Niepoprawna wartość w polu: Kwota słownie.")
    @Column(name = "KWOTA_SLOWNIE")
    private String kwotaSlownie;

    @NotNull
    @Column(name = "TERMIN_PLATNOSCI")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date terminPlatnosci;

    @NotNull
    @Convert(converter = BooleanToIntConverter.class)
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

    public BigDecimal getSumaPln() {
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

    @Type(type="yes_no")
    public boolean isFormaPlatnosci() {
        return formaPlatnosci;
    }

    @Type(type="yes_no")
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

