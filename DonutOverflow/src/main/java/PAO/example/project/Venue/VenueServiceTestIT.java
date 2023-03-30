package PAO.example.project.Venue;

import PAO.example.project.Venue.Venue;
import PAO.example.project.Venue.VenueRepository;
import PAO.example.project.Venue.VenueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class VenueServiceTestIT {

    @MockBean
    VenueRepository mockVenueRepository;

    @Autowired
    VenueService venueService;

    @Test
    void test_FindEmail_Update() {
        // Arrange
        String city = "Bucuresti";
        Optional<Venue> venue = mockVenueRepository.findVenueByCity(city);

        // Act
        if(venue.isPresent()) {
            venueService.updateVenue(venue.get().getId(), 6000);
        }


        // Assert
        if(venue.isPresent()) {
            Assertions.assertEquals(6000, venue.get().getNrLocuri());
        }

    }

}
