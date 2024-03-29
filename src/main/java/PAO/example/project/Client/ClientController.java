package PAO.example.project.Client;

import PAO.example.project.Client.Client;
import PAO.example.project.Client.ClientService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    private final Logger logger = Logger.getLogger(Client.class.toString());

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping(value = "/add")
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(value = "/delete/{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @PutMapping(value = "/update/{clientid}")
    public void updateClient(
            @PathVariable("clientid") Long clientid,
            @RequestParam(required = false) String nume,
            @RequestParam(required = false) String prenume) {
        clientService.updateClient(clientid, nume, prenume);
    }
}
