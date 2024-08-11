package eduardohrq.rides.models.rides.service;

import eduardohrq.rides.models.rides.Rides;
import eduardohrq.rides.models.rides.repository.RidesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class RidesServiceImpl implements RidesService {

    private final RidesRepository ridesRepository;

    @Override
    public Rides getRides(UUID rideId) {
        return this.ridesRepository.findById(rideId).orElseThrow(() -> new NullPointerException("Not found"));
    }

}
