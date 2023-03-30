package PAO.example.project.Ticket;

import PAO.example.project.Client.Client;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    private final Logger logger = Logger.getLogger(Ticket.class.toString());

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @PostMapping
    public void registerNewTicket(@RequestBody Ticket ticket){
        ticketService.addNewTicket(ticket);
    }

    @DeleteMapping(path = "{ticketId}")
    public void deleteTicket(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }

    @PutMapping(path = "{ticketid}")
    public void updateTicket(
            @PathVariable("ticketid") Long ticketid,
            @RequestParam(required = false) Integer price) {
        ticketService.updateTicket(ticketid, price);
    }
}
