package PAO.example.project.Event.Concert;

import PAO.example.project.Event.Concert.Concert;
import PAO.example.project.Event.Concert.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/concert")
public class ConcertController {

    private final ConcertService concertService;

    private final Logger logger = Logger.getLogger(Concert.class.toString());

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping(value = "/concerts")
    public List<Concert> getConcerts(){
        return concertService.getConcerts();
    }

    @PostMapping
    public void registerNewConcert(@RequestBody Concert concert){
        concertService.addNewConcert(concert);
    }

    @DeleteMapping(path = "/delete/{concertId}")
    public void deleteConcert(@PathVariable("concertId") Long concertId) {
        concertService.deleteConcert(concertId);
    }

    @PutMapping(path = "/update/{concertid}")
    public void updateConcert(
            @PathVariable("concertid") Long concertid,
            @RequestParam(required = false) Integer durata_in_ore) {
        concertService.updateConcert(concertid, durata_in_ore);
    }
}
