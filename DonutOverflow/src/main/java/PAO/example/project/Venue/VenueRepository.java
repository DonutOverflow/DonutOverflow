package PAO.example.project.Venue;

import PAO.example.project.Client.Client;
import PAO.example.project.Ticket.TicketF.TicketF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VenueRepository  extends JpaRepository<Venue, Long> {

    @Query("SELECT s FROM Venue s WHERE s.oras = ?1")
    Optional<Venue> findVenueByCity(String city);
}
