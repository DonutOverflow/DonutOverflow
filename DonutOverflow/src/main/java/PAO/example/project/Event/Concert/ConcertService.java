package PAO.example.project.Event.Concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ConcertService {



    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }


    public List<Concert> getConcerts(){
        return concertRepository.findAll();
    }

    public void addNewConcert(Concert concert) {

        System.out.println(concert);
        concertRepository.save(concert);
    }

    public void deleteConcert(Long concertId) {
        boolean exists = concertRepository.existsById(concertId);
        if (!exists) {
            throw  new IllegalStateException("concert with Id " + concertId + " does not exist");
        }
        else {
            concertRepository.deleteById(concertId);
        }

    }

    @Transactional
    public void updateConcert(Long concertId,
                             Integer durata_in_ore) {
        Concert concert = concertRepository.findById(concertId)
                .orElseThrow(() -> new IllegalStateException(
                        "concert with id " + concertId + " doesn' t exist "
                ));

        if(durata_in_ore != null && durata_in_ore>0 && !Objects.equals(concert.getDurata_in_ore(), durata_in_ore)){
            concert.setDurata_in_ore(durata_in_ore);
        }

    }

    public List<Concert> GetAllConcertsByType(String tip_concert){
        List<Concert> concert = concertRepository.findAll();

        List<Concert> concertf = null;

        for(Concert value : concert){
            if(Objects.equals(value.getTip_concert(), tip_concert)){
                concertf.add(value);
            }
        }
        return concertf;
    }

    public List<Concert> GetAllConcertsByBand(String trupa){
        List<Concert> concert = concertRepository.findAll();

        List<Concert> concertf = null;

        for(Concert value : concert){
            if(value.getTrupe().contains(trupa)){
                concertf.add(value);
            }
        }
        return concertf;
    }

    public List<Concert> GetAllConcertsByMembru(String membru){
        List<Concert> concert = concertRepository.findAll();

        List<Concert> concertf = null;

        for(Concert value : concert){
            if(value.getmembriiTrupaPrincipala().contains(membru)){
                concertf.add(value);
            }
        }
        return concertf;
    }
}
