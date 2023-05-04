package PAO.example.project.Event.StandUp;

import PAO.example.project.Event.Event;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Venue.Venue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StandUp extends Event {

    @SequenceGenerator(
            name = "StandUp_sequence",
            sequenceName = "StandUp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "StandUp_sequence"
    )
    private String comedianti;
    private Integer durata_in_ore;

    @OneToMany
    private List<Ticket> ticket = new ArrayList<>();

    public StandUp() {
    }

    public StandUp(String nume, String sponsor, LocalDate data, String description, String comedianti, Integer durata_in_ore) {
        super(nume, sponsor, data, description);
        this.comedianti = comedianti;
        this.durata_in_ore = durata_in_ore;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public String getComedianti() {
        return comedianti;
    }

    public void setComedianti(String comedianti) {
        this.comedianti = comedianti;
    }

    public Integer getDurata_in_ore() {
        return durata_in_ore;
    }

    public void setDurata_in_ore(Integer durata_in_ore) {
        this.durata_in_ore = durata_in_ore;
    }

    @Override
    public String toString() {
        return "StandUp{" +
                "comedianti='" + comedianti + '\'' +
                ", durata_in_ore=" + durata_in_ore +
                '}';
    }
}
