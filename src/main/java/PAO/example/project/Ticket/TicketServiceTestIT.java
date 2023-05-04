package PAO.example.project.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class TicketServiceTestIT {

    @MockBean
    TicketRepository mockTicketRepository;

    @Autowired
    TicketService ticketService;

    @Test
    void test_FindEmail_Update() {
        // Arrange
        String category = "A";
        Optional<Ticket> ticket = mockTicketRepository.findTicketByCategory(category);

        // Act
        if(ticket.isPresent()) {
            ticketService.updateTicket(ticket.get().getId(), 200);
        }


        // Assert
        if(ticket.isPresent()) {
            Assertions.assertEquals(200, ticket.get().getPrice());
        }

    }

}
