package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "SPRZEDAZE")
public class Sprzedaz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_sprzedazy;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_sprzedawcy")
    @JsonIgnore
    private Sprzedawca sprzedawca;
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_nabywcy")
    @JsonIgnore
    private Nabywca nabywca;
    @Column(name = "DATA_WYSTAWIENIA", columnDefinition = "DATE")
    private LocalTime data_wystawienia;
    @Column(name = "NR_RACHUNKU")
    private long nr_rachunku;
    @OneToOne(mappedBy = "sprzedaz", cascade = CascadeType.ALL) //moze SPRZEDAZ
    @PrimaryKeyJoinColumn
    private Platnosc platnosc;

        public long getId_sprzedazy() {
                return id_sprzedazy;
        }

        public void setId_sprzedazy(long id_sprzedazy) {
                this.id_sprzedazy = id_sprzedazy;
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

        public LocalTime getData_wystawienia() {
                return data_wystawienia;
        }

        public void setData_wystawienia(LocalTime data_wystawienia) {
                this.data_wystawienia = data_wystawienia;
        }

        public long getNr_rachunku() {
                return nr_rachunku;
        }

        public void setNr_rachunku(long nr_rachunku) {
                this.nr_rachunku = nr_rachunku;
        }

        public Platnosc getPlatnosc() {
                return platnosc;
        }

        public void setPlatnosc(Platnosc platnosc) {
                this.platnosc = platnosc;
        }
}
