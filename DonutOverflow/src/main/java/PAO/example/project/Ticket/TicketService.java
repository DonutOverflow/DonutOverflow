package PAO.example.project.Ticket;

import PAO.example.project.Client.Client;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public void addNewTicket(Ticket ticket) {

        Optional<Ticket> ticketoptional =
                ticketRepository.findTicketByCategory(ticket.getCategorie());
        if (ticketoptional.isPresent()) {
            throw new IllegalStateException("categorie used");
        }
        System.out.println((ticket));
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long ticketId) {
        boolean exists = ticketRepository.existsById(ticketId);
        if (!exists) {
            throw  new IllegalStateException("ticket with Id " + ticketId + " does not exist");
        }
        else {
            ticketRepository.deleteById(ticketId);
        }

    }
    @Transactional
    public void updateTicket(Long ticketId,
                             Integer price) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalStateException(
                        "ticket with id " + ticketId + " doesn' t exist "
                ));

        if(price != null && price>0 && !Objects.equals(ticket.getPrice(), price)){
            ticket.setPrice(price);
        }

    }

}
