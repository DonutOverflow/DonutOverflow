package PAO.example.project.Event;

import PAO.example.project.Venue.Venue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Event {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;
    private String nume;
    private String sponsor;
    private LocalDate data;
    private String description;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event() {
    }

    public Event(String nume, String sponsor, LocalDate data, String description, Venue venue) {
        this.nume = nume;
        this.sponsor = sponsor;
        this.data = data;
        this.description = description;
        this.venue= venue;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", data=" + data +
                ", description='" + description + '\'' +
                '}';
    }
}
