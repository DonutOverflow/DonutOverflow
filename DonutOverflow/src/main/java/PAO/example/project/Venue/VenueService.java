package PAO.example.project.Venue;

import PAO.example.project.Client.Client;
import PAO.example.project.Venue.Venue;
import PAO.example.project.Venue.Venue;
import PAO.example.project.Venue.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    public List<Venue> getVenues(){
        return venueRepository.findAll();
    }

    public void addNewVenue(Venue venue) {

        System.out.println((venue));
        venueRepository.save(venue);
    }

    public void deleteVenue(Long venueId) {
        boolean exists = venueRepository.existsById(venueId);
        if (!exists) {
            throw  new IllegalStateException("venue with Id " + venueId + " does not exist");
        }
        else {
            venueRepository.deleteById(venueId);
        }

    }

    @Transactional
    public void updateVenue(Long venueId,
                             Integer nrLocuri) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new IllegalStateException(
                        "venue with id " + venueId + " doesn' t exist "
                ));

        if(nrLocuri != null && nrLocuri>0 && !Objects.equals(venue.getNrLocuri(), nrLocuri)){
            venue.setNrLocuri(nrLocuri);
        }

    }
}
