package PAO.example.project.Venue;
import PAO.example.project.Ticket.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class VenueTest {
    Venue venue = new Venue("Romania", "Bucuresti", "Strada nr 6", 5000, "0700000000");

    @Test
    void testTara() {
        Assertions.assertEquals("Romania", venue.getTara());
    }
    @Test
    void testOras() {
        Assertions.assertEquals("Bucuresti", venue.getOras());
    }
    @Test
    void testAdresa() {
        Assertions.assertEquals("Strada nr 6", venue.getAdresa());
    }
    @Test
    void testNrLocuri() {
        Assertions.assertEquals(5000, venue.getNrLocuri());
    }
    @Test
    void testTelefon() {
        Assertions.assertEquals("0700000000", venue.getNrTelefon());
    }
}
