package PAO.example.project.Venue;

import PAO.example.project.Event.Concert.Concert;
import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.StandUp.StandUp;
import PAO.example.project.Event.Theater.Theater;
import PAO.example.project.Ticket.Ticket;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue {

    @Id
    @SequenceGenerator(
            name = "Venue_sequence",
            sequenceName = "Venue_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Venue_sequence"
    )
    private String tara;
    private String oras;
    private String adresa;
    private Integer nrLocuri;
    private String nrTelefon;

    @OneToMany
    private List<Concert> concert = new ArrayList<>();
    @OneToMany
    private List<Festival> festival = new ArrayList<>();
    @OneToMany
    private List<StandUp> standUp = new ArrayList<>();
    @OneToMany
    private List<Theater> theater = new ArrayList<>();

    public Venue() {
    }

    public Venue(String tara, String oras, String adresa, Integer nrLocuri, String nrTelefon) {
        this.tara = tara;
        this.oras = oras;
        this.adresa = adresa;
        this.nrLocuri = nrLocuri;
        this.nrTelefon = nrTelefon;
    }

    public List<Concert> getConcert() {
        return concert;
    }

    public void setConcert(List<Concert> concert) {
        this.concert = concert;
    }

    public List<Festival> getFestival() {
        return festival;
    }

    public void setFestival(List<Festival> festival) {
        this.festival = festival;
    }

    public List<StandUp> getStandUp() {
        return standUp;
    }

    public void setStandUp(List<StandUp> standUp) {
        this.standUp = standUp;
    }

    public List<Theater> getTheater() {
        return theater;
    }

    public void setTheater(List<Theater> theater) {
        this.theater = theater;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(Integer nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    @Override
    public String toString() {
        return "Venue{" +
                ", tara='" + tara + '\'' +
                ", oras='" + oras + '\'' +
                ", adresa='" + adresa + '\'' +
                ", nrLocuri=" + nrLocuri +
                ", nrTelefon='" + nrTelefon + '\'' +
                '}';
    }
}
