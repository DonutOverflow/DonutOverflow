package PAO.example.project.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class ClientServiceTestIT {

    @MockBean
    ClientRepository mockClientRepository;

    @Autowired
    ClientService clientService;

    @Test
    void test_FindEmail_Update() {
        // Arrange
        String email = "vladyc";
        Optional<Client> client = mockClientRepository.findClientByEmail(email);

        // Act
        if(client.isPresent()) {
            clientService.updateClient(client.get().getId(), "vladyc", "neacsuc");
        }


        // Assert
        if(client.isPresent()) {
            Assertions.assertEquals("neacsuc", client.get().getPrenume());
            Assertions.assertEquals("vladyc", client.get().getNume());
        }

    }

}
