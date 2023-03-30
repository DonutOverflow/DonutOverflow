package PAO.example.project.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
public class ClientTest {
    LocalDate dob = LocalDate.of(2001, 7, 16);
    Client clientDummy = new Client();
    Client client = new Client("vlad", "neacsu", "vlad@gmail.com", dob);

    @Test
    void testId(){
        clientDummy.setId(1L);
        Assertions.assertEquals(1L, clientDummy.getId());
    }
    @Test
    void testNume(){
        Assertions.assertEquals("vlad", client.getNume());
        clientDummy.setNume("vlad1");
        Assertions.assertEquals("vlad1", clientDummy.getNume());
    }
    @Test
    void testPrenume(){
        Assertions.assertEquals("neacsu", client.getPrenume());
        clientDummy.setPrenume("neacsu1");
        Assertions.assertEquals("neacsu1", clientDummy.getPrenume());
    }
    @Test
    void testEmail(){
        Assertions.assertEquals("vlad@gmail.com", client.getEmail());
        clientDummy.setEmail("vlad1@gmail.com");
        Assertions.assertEquals("vlad1@gmail.com", clientDummy.getEmail());
    }
    @Test
    void testData(){
        Assertions.assertEquals(dob, client.getDob());
        clientDummy.setDob(dob);
        Assertions.assertEquals(dob, clientDummy.getDob());
        Assertions.assertEquals(21, clientDummy.getAge());
    }

    @Test
    void testToString(){
        clientDummy.toString();
    }
}
