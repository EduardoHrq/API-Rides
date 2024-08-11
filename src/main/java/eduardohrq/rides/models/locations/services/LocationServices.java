package eduardohrq.rides.models.locations.services;

import java.util.List;
import java.util.Optional;

import eduardohrq.rides.models.enums.States;
import eduardohrq.rides.models.locations.Location;

public interface LocationServices {

  List<Optional<Location>> findByAttributes(States states, String city);

}
