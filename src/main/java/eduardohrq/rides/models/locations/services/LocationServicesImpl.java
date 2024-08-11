package eduardohrq.rides.models.locations.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import eduardohrq.rides.models.enums.States;
import eduardohrq.rides.models.locations.Location;
import eduardohrq.rides.models.locations.LocationRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class LocationServicesImpl implements LocationServices{

  private final LocationRepository locationRepository;

  @Override
  public List<Optional<Location>> findByAttributes(States states, String city) {
    
    return this.locationRepository.findByStateAndCity(states, city);

  }
  
}
