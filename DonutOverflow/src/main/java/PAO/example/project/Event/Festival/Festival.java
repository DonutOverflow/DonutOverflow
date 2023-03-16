package PAO.example.project.Event.Festival;

import PAO.example.project.Event.Event;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketF.TicketF;
import PAO.example.project.Venue.Venue;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Festival extends Event {


    private String trupe_cantareti;
    private String tip_festival;
    private LocalDate dataSfarsit;
    @Transient
    private Integer durataZile;

    @OneToMany
    private List<TicketF> ticketF = new ArrayList<>();
    public Festival() {
    }

    public Festival(String nume, String sponsor, LocalDate data, Venue venue, String description, String trupe_cantareti, String tip_festival, LocalDate dataSfarsit) {
        super(nume, sponsor, data, description, venue);
        this.trupe_cantareti = trupe_cantareti;
        this.tip_festival = tip_festival;
        this.dataSfarsit = dataSfarsit;


    }

    public List<TicketF> getTicketF() {
        return ticketF;
    }

    public void setTicketF(List<TicketF> ticketF) {
        this.ticketF = ticketF;
    }

    public String getTrupe_cantareti() {
        return trupe_cantareti;
    }

    public void setTrupe_cantareti(String trupe_cantareti) {
        this.trupe_cantareti = trupe_cantareti;
    }

    public String getTip_festival() {
        return tip_festival;
    }

    public void setTip_festival(String tip_festival) {
        this.tip_festival = tip_festival;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(LocalDate dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public Integer getDurataZile() {
        return Period.between(this.getData(), this.dataSfarsit).getDays();
    }

    public void setDurataZile(Integer durataZile) {
        this.durataZile = durataZile;
    }
}
