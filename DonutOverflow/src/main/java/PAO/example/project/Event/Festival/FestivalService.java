package PAO.example.project.Event.Festival;

import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.Festival.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
public class FestivalService {
    
    private final FestivalRepository festivalRepository;

    @Autowired
    public FestivalService(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }


    public List<Festival> getFestivals(){
        return festivalRepository.findAll();
    }

    public void addNewFestival(Festival festival) {

        System.out.println(festival);
        festivalRepository.save(festival);
    }

    public void deleteFestival(Long festivalId) {
        boolean exists = festivalRepository.existsById(festivalId);
        if (!exists) {
            throw  new IllegalStateException("festival with Id " + festivalId + " does not exist");
        }
        else {
            festivalRepository.deleteById(festivalId);
        }

    }

    @Transactional
    public void updateFestival(Long festivalId,
                             LocalDate dataSfarsit) {
        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new IllegalStateException(
                        "festival with id " + festivalId + " doesn' t exist "
                ));

        if(dataSfarsit != null && Period.between(festival.getData(), dataSfarsit).getDays() > 0 && !Objects.equals(festival.getDataSfarsit(), dataSfarsit)){
            festival.setDataSfarsit(dataSfarsit);
        }
    }

    public List<Festival> GetAllFestivalsByType(String tip_festival){
        List<Festival> festival = festivalRepository.findAll();

        List<Festival> festivalf = null;

        for(Festival value : festival){
            if(Objects.equals(value.getTip_festival(), tip_festival)){
                festivalf.add(value);
            }
        }
        return festivalf;
    }

    public List<Festival> GetAllFestivalsByBand_Singer(String trupa_cantaret){
        List<Festival> festival = festivalRepository.findAll();

        List<Festival> festivalf = null;

        for(Festival value : festival){
            if(value.getTrupe_cantareti().contains(trupa_cantaret)){
                festivalf.add(value);
            }
        }
        return festivalf;
    }
}
