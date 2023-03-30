package PAO.example.project.Venue;

import PAO.example.project.Ticket.TicketF.TicketF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository  extends JpaRepository<Venue, Long> {
}
