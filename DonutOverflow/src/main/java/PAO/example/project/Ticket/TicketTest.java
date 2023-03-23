package PAO.example.project.Ticket;
import PAO.example.project.Event.Concert.Concert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class TicketTest {
    Ticket ticket = new Ticket(100, "A", "e tare");

    @Test
    void testPret() {
        Assertions.assertEquals(100, ticket.getPrice());
    }
    @Test
    void testCategorie() {
        Assertions.assertEquals("A", ticket.getCategorie());
    }
    @Test
    void testDetalii() {
        Assertions.assertEquals("e tare", ticket.getDetalii());
    }
}
