package PAO.example.project.Event.StandUp;

import PAO.example.project.Event.StandUp.StandUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/standUp")
public class StandUpController {

    private final StandUpService standUpService;

    private final Logger logger = Logger.getLogger(StandUp.class.toString());

    @Autowired
    public StandUpController(StandUpService standUpService) {
        this.standUpService = standUpService;
    }

    @GetMapping
    public List<StandUp> getStandUps(){
        return standUpService.getStandUps();
    }

    @PostMapping
    public void registerNewStandUp(@RequestBody StandUp standUp){
        standUpService.addNewStandUp(standUp);
    }

    @DeleteMapping(path = "{standUpId}")
    public void deleteStandUp(@PathVariable("standUpId") Long standUpId) {
        standUpService.deleteStandUp(standUpId);
    }

    @PutMapping(path = "{standUpid}")
    public void updateStandUp(
            @PathVariable("standUpid") Long standUpid,
            @RequestParam(required = false) Integer durata_in_ore) {
        standUpService.updateStandUp(standUpid, durata_in_ore);
    }
}
