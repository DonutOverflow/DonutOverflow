package PAO.example.project.Event.Theater;

import PAO.example.project.Event.Festival.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {


}
