package PAO.example.project.Ticket;

import PAO.example.project.Client.Client;
import PAO.example.project.Event.Concert.Concert;
import PAO.example.project.Event.StandUp.StandUp;
import PAO.example.project.Event.Theater.Theater;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    private Long id;
    private Integer price;
    private String categorie;
    private String detalii;

    @ManyToOne
    @JoinColumn(name = "concert_id", nullable = true)
    private Concert concert;

    @ManyToOne
    @JoinColumn(name = "standUp_id", nullable = true)
    private StandUp standUp;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = true)
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Ticket() {
    }

    public Ticket(Long id, Integer price, String categorie, String detalii, Concert concert, StandUp standUp, Theater theater, Client client) {
        this.id = id;
        this.price = price;
        this.categorie = categorie;
        this.detalii = detalii;
        this.concert = concert;
        this.standUp = standUp;
        this.theater = theater;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public StandUp getStandUp() {
        return standUp;
    }

    public void setStandUp(StandUp standUp) {
        this.standUp = standUp;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", categorie='" + categorie + '\'' +
                ", detalii='" + detalii + '\'' +
                '}';
    }
}
