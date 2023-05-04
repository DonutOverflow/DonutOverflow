package PAO.example.project.Client;

import PAO.example.project.Client.Client;
import PAO.example.project.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;



    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {

        Optional<Client> clientoptional =
                clientRepository.findClientByEmail(client.getEmail());
        if (clientoptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        System.out.println((client));
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if (!exists) {
            throw  new IllegalStateException("client with Id " + clientId + " does not exist");
        }
        else {
            clientRepository.deleteById(clientId);
        }

    }

    @Transactional
    public void updateClient(Long clientId,
                             String nume,
                             String prenume) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "client with id " + clientId + " doesn' t exist "
        ));

        if(nume != null && nume.length()>0 && !Objects.equals(client.getNume(), nume)){
            client.setNume(nume);
        }

        if(prenume != null && prenume.length()>0 && !Objects.equals(client.getPrenume(), prenume)){
            client.setNume(prenume);
        }
    }

    public List<Client> getClientsAdults(){

        List<Client> client = clientRepository.findAll();

        List<Client> clientf = null;

        for (Client value : client){
            if(value.getAge() > 17){
                clientf.add(value);
            }
        }

        return clientf;

    }





}
