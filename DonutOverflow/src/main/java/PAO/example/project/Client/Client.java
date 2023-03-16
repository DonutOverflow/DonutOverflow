package PAO.example.project.Client;

import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketF.TicketF;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "Client_sequence",
            sequenceName = "Client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Client_sequence"
    )
    private Long id;
    private String nume;
    private String prenume;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    @OneToMany
    private List<TicketF> ticketf = new ArrayList<>();
    @OneToMany
    private List<Ticket> ticket = new ArrayList<>();

    public List<TicketF> getTicketf() {
        return ticketf;
    }

    public void setTicketf(List<TicketF> ticketf) {
        this.ticketf = ticketf;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public Client() {
    }

    public Client(String nume, String prenume, String email, LocalDate dob) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + nume + ' ' + prenume + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

}
