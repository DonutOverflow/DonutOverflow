package PAO.example.project.Event.Theater;

import PAO.example.project.Event.Event;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Venue.Venue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater extends Event {

    @SequenceGenerator(
            name = "Theater_sequence",
            sequenceName = "Theater_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Theater_sequence"
    )
    private String actori;
    private String tip_piesa;
    private Integer durata_ore;
    private String detalii_productie;
    @OneToMany
    private List<Ticket> ticket = new ArrayList<>();
    public Theater() {
    }

    public Theater(String nume, String sponsor, LocalDate data, String description, String actori, String tip_piesa, Integer durata_ore, String detalii_productie) {
        super(nume, sponsor, data, description);
        this.actori = actori;
        this.tip_piesa = tip_piesa;
        this.durata_ore = durata_ore;
        this.detalii_productie = detalii_productie;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public String getActori() {
        return actori;
    }

    public void setActori(String actori) {
        this.actori = actori;
    }

    public String getTip_piesa() {
        return tip_piesa;
    }

    public void setTip_piesa(String tip_piesa) {
        this.tip_piesa = tip_piesa;
    }

    public Integer getDurata_ore() {
        return durata_ore;
    }

    public void setDurata_ore(Integer durata_ore) {
        this.durata_ore = durata_ore;
    }

    public String getDetalii_productie() {
        return detalii_productie;
    }

    public void setDetalii_productie(String detalii_productie) {
        this.detalii_productie = detalii_productie;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "actori='" + actori + '\'' +
                ", tip_piesa='" + tip_piesa + '\'' +
                ", durata_ore=" + durata_ore +
                ", detalii_productie='" + detalii_productie + '\'' +
                '}';
    }
}
