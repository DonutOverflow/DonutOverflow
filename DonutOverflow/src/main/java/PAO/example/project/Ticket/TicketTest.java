package PAO.example.project.Ticket;
import PAO.example.project.Event.Concert.Concert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class TicketTest {
    Ticket ticketDummy = new Ticket();
    Ticket ticket = new Ticket(100, "A", "e tare");
    @Test
    void testId() {
        ticketDummy.setId(1L);
        Assertions.assertEquals(1L, ticketDummy.getId());
    }
    @Test
    void testPret() {
        Assertions.assertEquals(100, ticket.getPrice());
        ticketDummy.setPrice(100);
        Assertions.assertEquals(100, ticketDummy.getPrice());
    }
    @Test
    void testCategorie() {
        Assertions.assertEquals("A", ticket.getCategorie());
        ticketDummy.setCategorie("A");
        Assertions.assertEquals("A", ticketDummy.getCategorie());
    }
    @Test
    void testDetalii() {
        Assertions.assertEquals("e tare", ticket.getDetalii());
        ticketDummy.setDetalii("e tare");
        Assertions.assertEquals("e tare", ticketDummy.getDetalii());
    }
    @Test
    void testTosTRING() {
        ticketDummy.toString();
    }
}
