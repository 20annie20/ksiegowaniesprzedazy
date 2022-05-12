package ee.pw.edu.pl.Sprzedaze.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SPRZEDAZE")
public class Sprzedaz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSprzedazy;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "idSprzedawcy")
    @JsonIgnore
    private Sprzedawca sprzedawca;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "idNabywcy")
    @JsonIgnore
    private Nabywca nabywca;
    @Column(name = "DATA_WYSTAWIENIA", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataWystawienia;
    @NotNull
    @Column(name = "NR_RACHUNKU")
    private String nrRachunku;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_platnosci", referencedColumnName = "id")
    private Platnosc platnosc;

    public long getIdSprzedazy() {
                return idSprzedazy;
        }

    public void setIdSprzedazy(long idSprzedazy) {
                this.idSprzedazy = idSprzedazy;
        }

    public Sprzedawca getSprzedawca() {
                return sprzedawca;
        }

    public void setSprzedawca(Sprzedawca sprzedawca) {
                this.sprzedawca = sprzedawca;
        }

    public Nabywca getNabywca() {
                return nabywca;
        }

    public void setNabywca(Nabywca nabywca) {
                this.nabywca = nabywca;
        }

    public Date getDataWystawienia() {
                return dataWystawienia;
        }

    public void setDataWystawienia(Date dataWystawienia) {
                this.dataWystawienia = dataWystawienia;
        }

    public String getNrRachunku() {
                return nrRachunku;
        }

    public void setNrRachunku(String nrRachunku) {
                this.nrRachunku = nrRachunku;
        }

    public Platnosc getPlatnosc() {
                return platnosc;
        }

    public void setPlatnosc(Platnosc platnosc) {
                this.platnosc = platnosc;
        }
}
