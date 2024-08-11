package eduardohrq.rides.models.locations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eduardohrq.rides.models.enums.States;

public interface LocationRepository extends JpaRepository<Location, Long>{
  
  List<Optional<Location>> findByStateAndCity(States state, String city);

}
