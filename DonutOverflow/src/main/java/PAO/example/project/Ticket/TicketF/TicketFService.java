package PAO.example.project.Ticket.TicketF;

import PAO.example.project.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TicketFService {

    private final TicketFRepository ticketFRepository;

    @Autowired
    public TicketFService(TicketFRepository ticketFRepository) {
        this.ticketFRepository = ticketFRepository;
    }


    public List<TicketF> getTicketFs(){
        return ticketFRepository.findAll();
    }

    public void addNewTicketF(TicketF ticketF) {

        Optional<TicketF> ticketFoptional =
                ticketFRepository.findTicketFByCategory(ticketF.getCategorie());
        if (ticketFoptional.isPresent()) {
            throw new IllegalStateException("categorie used");
        }
        System.out.println((ticketF));
        ticketFRepository.save(ticketF);
    }

    public void deleteTicketF(Long ticketFId) {
        boolean exists = ticketFRepository.existsById(ticketFId);
        if (!exists) {
            throw  new IllegalStateException("ticketF with Id " + ticketFId + " does not exist");
        }
        else {
            ticketFRepository.deleteById(ticketFId);
        }

    }

    @Transactional
    public void updateTicketF(Long ticketFId,
                              Integer price) {
        TicketF ticketF = ticketFRepository.findById(ticketFId)
                .orElseThrow(() -> new IllegalStateException(
                        "ticketF with id " + ticketFId + " doesn' t exist "
                ));

        if(price != null && price>0 && !Objects.equals(ticketF.getPrice(), price)){
            ticketF.setPrice(price);
        }

    }


}
