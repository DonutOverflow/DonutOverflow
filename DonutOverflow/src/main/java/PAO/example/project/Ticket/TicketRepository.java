package PAO.example.project.Ticket;

import PAO.example.project.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT s FROM Ticket s WHERE s.categorie = ?1")
    Optional<Ticket> findTicketByCategory(String categorie);
}
