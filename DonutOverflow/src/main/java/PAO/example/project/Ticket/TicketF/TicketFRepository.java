package PAO.example.project.Ticket.TicketF;

import PAO.example.project.Ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketFRepository extends JpaRepository<TicketF, Long> {

    @Query("SELECT s FROM TicketF s WHERE s.categorie = ?1")
    Optional<TicketF> findTicketFByCategory(String categorie);
}

