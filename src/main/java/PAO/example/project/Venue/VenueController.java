package PAO.example.project.Venue;

import PAO.example.project.Client.Client;
import PAO.example.project.Venue.Venue;
import PAO.example.project.Venue.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/venue")
public class VenueController {

    private final VenueService venueService;

    private final Logger logger = Logger.getLogger(Venue.class.toString());

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping(value = "/venues")
    public List<Venue> getVenues(){
        return venueService.getVenues();
    }

    @PostMapping
    public void registerNewVenue(@RequestBody Venue venue){
        venueService.addNewVenue(venue);
    }

    @DeleteMapping(path = "/delete/{venueId}")
    public void deleteVenue(@PathVariable("venueId") Long venueId) {
        venueService.deleteVenue(venueId);
    }

    @PutMapping(path = "/update/{venueid}")
    public void updateVenue(
            @PathVariable("venueid") Long venueid,
            @RequestParam(required = false) Integer nrLocuri) {
        venueService.updateVenue(venueid, nrLocuri);
    }
}
