package eduardohrq.rides.models.rides.service;

import eduardohrq.rides.models.rides.Rides;

import java.util.UUID;

public interface RidesService {

    Rides getRides(UUID rideId);

}
