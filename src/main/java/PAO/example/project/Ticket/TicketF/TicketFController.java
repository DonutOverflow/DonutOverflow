package PAO.example.project.Ticket.TicketF;

import PAO.example.project.Client.Client;
import PAO.example.project.Ticket.TicketF.TicketF;
import PAO.example.project.Ticket.TicketF.TicketFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/ticketF")
public class TicketFController {

    private final TicketFService ticketFService;

    private final Logger logger = Logger.getLogger(TicketF.class.toString());

    @Autowired
    public TicketFController(TicketFService ticketFService) {
        this.ticketFService = ticketFService;
    }

    @GetMapping
    public List<TicketF> getTicketFs(){
        return ticketFService.getTicketFs();
    }

    @PostMapping
    public void registerNewTicketF(@RequestBody TicketF ticketF){
        ticketFService.addNewTicketF(ticketF);
    }

    @DeleteMapping(path = "{ticketFId}")
    public void deleteTicketF(@PathVariable("ticketFId") Long ticketFId) {
        ticketFService.deleteTicketF(ticketFId);
    }

    @PutMapping(path = "{ticketFid}")
    public void updateTicketF(
            @PathVariable("ticketFid") Long ticketFid,
            @RequestParam(required = false) Integer price) {
        ticketFService.updateTicketF(ticketFid, price);
    }
}
