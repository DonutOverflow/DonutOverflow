package PAO.example.project.Event.Concert;
import PAO.example.project.Client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class ConcertTest {
    LocalDate dob = LocalDate.of(2001, 7, 16);
    Concert concert = new Concert("Metallica", "Redubull", dob, "very cool man", "Metallica", "Metallica lead singer", "rock", 3);

    @Test
    void testNume() {
        Assertions.assertEquals("Metallica", concert.getNume());
    }
    @Test
    void testSponsor() {
        Assertions.assertEquals("Redubull", concert.getSponsor());
    }
    @Test
    void testData() {
        Assertions.assertEquals(dob, concert.getData());
    }
    @Test
    void testDescription() {
        Assertions.assertEquals("very cool man", concert.getDescription());
    }
    @Test
    void testTrupe() {
        Assertions.assertEquals("Metallica", concert.getTrupe());
    }
    @Test
    void testMembrii() {
        Assertions.assertEquals("Metallica lead singer", concert.getMembriiTrupaPrincipala());
    }
    @Test
    void testTip() {
        Assertions.assertEquals("rock", concert.getTip_concert());
    }
    @Test
    void testDurata() {
        Assertions.assertEquals(3, concert.getDurata_in_ore());
    }
}
