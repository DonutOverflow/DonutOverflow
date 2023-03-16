package PAO.example.project.Event.Festival;


import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.Festival.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/festival")
public class FestivalController {
    private final FestivalService festivalService;

    private final Logger logger = Logger.getLogger(Festival.class.toString());

    @Autowired
    public FestivalController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @GetMapping
    public List<Festival> getFestivals(){
        return festivalService.getFestivals();
    }

    @PostMapping
    public void registerNewFestival(@RequestBody Festival festival){
        festivalService.addNewFestival(festival);
    }

    @DeleteMapping(path = "{festivalId}")
    public void deleteFestival(@PathVariable("festivalId") Long festivalId) {
        festivalService.deleteFestival(festivalId);
    }

    @PutMapping(path = "{festivalid}")
    public void updateFestival(
            @PathVariable("festivalid") Long festivalid,
            @RequestParam(required = false) LocalDate dataSfarsit) {
        festivalService.updateFestival(festivalid, dataSfarsit);
    }
}
