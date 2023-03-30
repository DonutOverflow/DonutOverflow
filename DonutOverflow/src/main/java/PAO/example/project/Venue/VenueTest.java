package PAO.example.project.Venue;
import PAO.example.project.Ticket.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class VenueTest {
    Venue venueDummy = new Venue();
    Venue venue = new Venue("Romania", "Bucuresti", "Strada nr 6", 5000, "0700000000");
    @Test
    void testId() {
        venueDummy.setId(1L);
        Assertions.assertEquals(1L, venueDummy.getId());
    }
    @Test
    void testTara() {
        Assertions.assertEquals("Romania", venue.getTara());
        venueDummy.setTara("Romania");
        Assertions.assertEquals("Romania", venueDummy.getTara());
    }
    @Test
    void testOras() {
        Assertions.assertEquals("Bucuresti", venue.getOras());
        venueDummy.setOras("Bucuresti");
        Assertions.assertEquals("Bucuresti", venueDummy.getOras());
    }
    @Test
    void testAdresa() {
        Assertions.assertEquals("Strada nr 6", venue.getAdresa());
        venueDummy.setAdresa("Strada nr 6");
        Assertions.assertEquals("Strada nr 6", venueDummy.getAdresa());
    }
    @Test
    void testNrLocuri() {
        Assertions.assertEquals(5000, venue.getNrLocuri());
        venueDummy.setNrLocuri(5000);
        Assertions.assertEquals(5000, venueDummy.getNrLocuri());
    }
    @Test
    void testTelefon() {
        Assertions.assertEquals("0700000000", venue.getNrTelefon());
        venueDummy.setNrTelefon("0700000000");
        Assertions.assertEquals("0700000000", venueDummy.getNrTelefon());
    }
    @Test
    void testToString() {
        venueDummy.toString();
    }
}
