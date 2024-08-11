package eduardohrq.rides.models.rides.dtos;

import eduardohrq.rides.models.Passenger.dtos.PassengerResponseInfo;
import eduardohrq.rides.models.locations.Location;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record RidesResponseInfo(
        UUID rideId,
        String title,
        Location to,
        Location from,
        List<PassengerResponseInfo> passengers

) {
}
