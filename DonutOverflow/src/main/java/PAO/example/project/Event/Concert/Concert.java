package PAO.example.project.Event.Concert;

import PAO.example.project.Event.Event;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketF.TicketF;
import PAO.example.project.Venue.Venue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Concert extends Event {

    @SequenceGenerator(
            name = "Concert_sequence",
            sequenceName = "Concert_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Concert_sequence"
    )
    private String trupe;
    private String membriiTrupaPrincipala;
    private String tip_concert;
    private Integer durata_in_ore;

    @OneToMany
    private List<Ticket> ticket = new ArrayList<>();


    public Concert() {
    }

    public Concert(String nume, String sponsor, LocalDate data, String description, String trupe, String membriiTrupaPrincipala, String tip_concert, Integer durata_in_ore) {
        super(nume, sponsor, data, description);
        this.trupe = trupe;
        this.membriiTrupaPrincipala = membriiTrupaPrincipala;
        this.tip_concert = tip_concert;
        this.durata_in_ore = durata_in_ore;
    }

    public String getMembriiTrupaPrincipala() {
        return membriiTrupaPrincipala;
    }

    public void setMembriiTrupaPrincipala(String membriiTrupaPrincipala) {
        this.membriiTrupaPrincipala = membriiTrupaPrincipala;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }


    public String getTrupe() {
        return trupe;
    }

    public void setTrupe(String trupe) {
        this.trupe = trupe;
    }

    public String getTip_concert() {
        return tip_concert;
    }

    public void setTip_concert(String tip_concert) {
        this.tip_concert = tip_concert;
    }

    public Integer getDurata_in_ore() {
        return durata_in_ore;
    }

    public void setDurata_in_ore(Integer durata_in_ore) {
        this.durata_in_ore = durata_in_ore;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "trupe='" + trupe + '\'' +
                ", membriiTrupaPrincipala='" + membriiTrupaPrincipala + '\'' +
                ", tip_concert='" + tip_concert + '\'' +
                ", durata_in_ore=" + durata_in_ore +
                '}';
    }
}
