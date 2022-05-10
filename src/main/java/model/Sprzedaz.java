package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "SPRZEDAZE")
public class Sprzedaz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSprzedazy;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_sprzedawcy")
    @JsonIgnore
    private Sprzedawca sprzedawca;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_nabywcy")
    @JsonIgnore
    private Nabywca nabywca;
    @Column(name = "DATA_WYSTAWIENIA", columnDefinition = "DATE")
    private LocalTime dataWystawienia;
    @Column(name = "NR_RACHUNKU")
    private long nrRachunku;
    @OneToOne(mappedBy = "sprzedaz", cascade = CascadeType.ALL) //moze SPRZEDAZ
    @PrimaryKeyJoinColumn
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

        public LocalTime getDataWystawienia() {
                return dataWystawienia;
        }

        public void setDataWystawienia(LocalTime dataWystawienia) {
                this.dataWystawienia = dataWystawienia;
        }

        public long getNrRachunku() {
                return nrRachunku;
        }

        public void setNrRachunku(long nrRachunku) {
                this.nrRachunku = nrRachunku;
        }

        public Platnosc getPlatnosc() {
                return platnosc;
        }

        public void setPlatnosc(Platnosc platnosc) {
                this.platnosc = platnosc;
        }
}
