package PAO.example.project.Event.Theater;

import PAO.example.project.Event.Festival.Festival;
import PAO.example.project.Event.Theater.Theater;
import PAO.example.project.Event.Theater.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(path = "api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;

    private final Logger logger = Logger.getLogger(Theater.class.toString());

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<Theater> getTheaters(){
        return theaterService.getTheaters();
    }

    @PostMapping
    public void registerNewTheater(@RequestBody Theater theater){
        theaterService.addNewTheater(theater);
    }

    @DeleteMapping(path = "{theaterId}")
    public void deleteTheater(@PathVariable("theaterId") Long theaterId) {
        theaterService.deleteTheater(theaterId);
    }

    @PutMapping(path = "{theaterid}")
    public void updateTheater(
            @PathVariable("theaterid") Long theaterid,
            @RequestParam(required = false) Integer durata_ore) {
        theaterService.updateTheater(theaterid, durata_ore);
    }
}
