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
    Concert concertDummy = new Concert();
    Concert concert = new Concert("Metallica", "Redubull", dob, "very cool man", "Metallica", "Metallica lead singer", "rock", 3);
    @Test
    void testId() {
        concertDummy.setId(1L);
        Assertions.assertEquals(1L, concertDummy.getId());
    }
    @Test
    void testNume() {
        Assertions.assertEquals("Metallica", concert.getNume());
        concertDummy.setNume("Metallica");
        Assertions.assertEquals("Metallica", concertDummy.getNume());
    }
    @Test
    void testSponsor() {
        Assertions.assertEquals("Redubull", concert.getSponsor());
        concertDummy.setSponsor("Redubull");
        Assertions.assertEquals("Redubull", concertDummy.getSponsor());
    }
    @Test
    void testData() {
        Assertions.assertEquals(dob, concert.getData());
        concertDummy.setData(dob);
        Assertions.assertEquals(dob, concertDummy.getData());
    }
    @Test
    void testDescription() {
        Assertions.assertEquals("very cool man", concert.getDescription());
        concertDummy.setDescription("very cool man");
        Assertions.assertEquals("very cool man", concertDummy.getDescription());
    }
    @Test
    void testTrupe() {
        Assertions.assertEquals("Metallica", concert.getTrupe());
        concertDummy.setTrupe("Metallica");
        Assertions.assertEquals("Metallica", concertDummy.getTrupe());
    }
    @Test
    void testMembrii() {
        Assertions.assertEquals("Metallica lead singer", concert.getMembriiTrupaPrincipala());
        concertDummy.setMembriiTrupaPrincipala("Metallica lead singer");
        Assertions.assertEquals("Metallica lead singer", concertDummy.getMembriiTrupaPrincipala());
    }
    @Test
    void testTip() {
        Assertions.assertEquals("rock", concert.getTip_concert());
        concertDummy.setTip_concert("rock");
        Assertions.assertEquals("rock", concertDummy.getTip_concert());
    }
    @Test
    void testDurata() {
        Assertions.assertEquals(3, concert.getDurata_in_ore());
        concertDummy.setDurata_in_ore(3);
        Assertions.assertEquals(3, concertDummy.getDurata_in_ore());
    }
    @Test
    void testToString() {
        concertDummy.toString();
    }
}
