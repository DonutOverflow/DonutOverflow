package PAO.example.project.Event.StandUp;

import PAO.example.project.Event.Festival.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandUpRepository extends JpaRepository<StandUp, Long> {
}
