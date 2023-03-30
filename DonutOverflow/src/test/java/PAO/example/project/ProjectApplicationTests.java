package PAO.example.project;

import PAO.example.project.Client.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
    }
	LocalDate dob = LocalDate.of(2001, 7, 16);
	Client client = new Client("vlad", "vlad", "vlad@gmail.com", dob);
	@Test
	void test_id(){
		Assertions.assertEquals(1, client.getId());
		}
}
