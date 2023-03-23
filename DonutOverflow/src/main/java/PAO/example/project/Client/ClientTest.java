package PAO.example.project.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class ClientTest {
    LocalDate dob = LocalDate.of(2001, 7, 16);
    Client client = new Client("vlad", "neacsu", "vlad@gmail.com", dob);
    @Test
    void testNume(){
        Assertions.assertEquals("vlad", client.getNume());
    }
    @Test
    void testPrenume(){
        Assertions.assertEquals("neacsu", client.getPrenume());
    }
    @Test
    void testEmail(){
        Assertions.assertEquals("vlad@gmail.com", client.getEmail());
    }
    @Test
    void testData(){
        Assertions.assertEquals(dob, client.getDob());
    }
}
