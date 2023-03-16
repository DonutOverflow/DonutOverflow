package PAO.example.project.Event.Theater;

import PAO.example.project.Client.Client;
import PAO.example.project.Event.Theater.Theater;
import PAO.example.project.Event.Theater.Theater;
import PAO.example.project.Event.Theater.Theater;
import PAO.example.project.Event.Theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }


    public List<Theater> getTheaters(){
        return theaterRepository.findAll();
    }

    public void addNewTheater(Theater theater) {

        System.out.println(theater);
        theaterRepository.save(theater);
    }

    public void deleteTheater(Long theaterId) {
        boolean exists = theaterRepository.existsById(theaterId);
        if (!exists) {
            throw  new IllegalStateException("theater with Id " + theaterId + " does not exist");
        }
        else {
            theaterRepository.deleteById(theaterId);
        }

    }

    @Transactional
    public void updateTheater(Long theaterId,
                              Integer durata_ore) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new IllegalStateException(
                        "theater with id " + theaterId + " doesn' t exist "
                ));

        if(durata_ore != null && durata_ore>0 && !Objects.equals(theater.getDurata_ore(), durata_ore)){
            theater.setDurata_ore(durata_ore);
        }

    }

    public List<Theater> GetAllTheatersByType(String tip_piesa){
        List<Theater> theater = theaterRepository.findAll();

        List<Theater> theaterf = null;

        for(Theater value : theater){
            if(Objects.equals(value.getTip_piesa(), tip_piesa)){
                theaterf.add(value);
            }
        }
        return theaterf;
    }

    public List<Theater> GetAllTheatersByActors(String actor){
        List<Theater> theater = theaterRepository.findAll();

        List<Theater> theaterf = null;

        for(Theater value : theater){
            if(value.getActori().contains(actor)){
                theaterf.add(value);
            }
        }
        return theaterf;
    }
}
