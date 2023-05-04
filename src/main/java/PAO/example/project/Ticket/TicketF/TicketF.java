package PAO.example.project.Ticket.TicketF;

import PAO.example.project.Client.Client;
import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Ticket.Ticket;

import javax.persistence.*;


@Entity
public class TicketF {
    @Id
    @SequenceGenerator(
            name = "TicketF_sequence",
            sequenceName = "TicketF_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TicketF_sequence"
    )
    private Long id;
    private Integer price;
    private String categorie;
    private String detalii;
    private Integer ziFestival;
    private Boolean abonament;

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = true)
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public TicketF() {
    }

    public TicketF(Integer price, String categorie, String detalii, Integer ziFestival, Festival festival, Client client) {

        this.price = price;
        this.categorie = categorie;
        this.detalii = detalii;
        this.ziFestival = ziFestival;
        this.festival = festival;
        this.client = client;
    }

    public TicketF(Long id, Integer price, String categorie, String detalii, Boolean abonament, Festival festival, Client client) {
        this.id = id;
        this.price = price;
        this.categorie = categorie;
        this.detalii = detalii;
        this.abonament = abonament;
        this.festival = festival;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
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

    public Integer getZiFestival() {
        return ziFestival;
    }

    public void setZiFestival(Integer ziFestival) {
        this.ziFestival = ziFestival;
    }

    public Boolean getAbonament() {
        return abonament;
    }

    public void setAbonament(Boolean abonament) {
        this.abonament = abonament;
    }

    @Override
    public String toString() {
        return "TicketF{" +
                "ziFestival=" + ziFestival +
                ", abonament=" + abonament +
                '}';
    }

    public void PriceSubscription() {
        if(this.abonament)
        this.price = this.price * this.festival.getDurataZile();
    }
}
