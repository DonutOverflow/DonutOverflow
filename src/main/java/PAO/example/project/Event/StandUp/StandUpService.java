package PAO.example.project.Event.StandUp;

import PAO.example.project.Client.Client;
import PAO.example.project.Event.StandUp.StandUp;
import PAO.example.project.Event.StandUp.StandUp;
import PAO.example.project.Event.StandUp.StandUp;
import PAO.example.project.Event.StandUp.StandUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StandUpService {

    private final StandUpRepository standUpRepository;

    @Autowired
    public StandUpService(StandUpRepository standUpRepository) {
        this.standUpRepository = standUpRepository;
    }


    public List<StandUp> getStandUps(){
        return standUpRepository.findAll();
    }

    public void addNewStandUp(StandUp standUp) {

        System.out.println(standUp);
        standUpRepository.save(standUp);
    }

    public void deleteStandUp(Long standUpId) {
        boolean exists = standUpRepository.existsById(standUpId);
        if (!exists) {
            throw  new IllegalStateException("standUp with Id " + standUpId + " does not exist");
        }
        else {
            standUpRepository.deleteById(standUpId);
        }

    }

    @Transactional
    public void updateStandUp(Long standUpId,
                              Integer durata_in_ore) {
        StandUp standUp = standUpRepository.findById(standUpId)
                .orElseThrow(() -> new IllegalStateException(
                        "standUp with id " + standUpId + " doesn' t exist "
                ));

        if(durata_in_ore != null && durata_in_ore>0 && !Objects.equals(standUp.getDurata_in_ore(), durata_in_ore)){
            standUp.setDurata_in_ore(durata_in_ore);
        }

    }

    public List<StandUp> GetAllStandUpsByComedian(String comediant){
        List<StandUp> standUp = standUpRepository.findAll();

        List<StandUp> standUpf = null;

        for(StandUp value : standUp){
            if(value.getComedianti().contains(comediant)){
                standUpf.add(value);
            }
        }
        return standUpf;
    }
}
