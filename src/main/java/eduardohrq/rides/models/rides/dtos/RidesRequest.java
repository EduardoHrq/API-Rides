package eduardohrq.rides.models.rides.dtos;

import eduardohrq.rides.models.locations.Location;
import lombok.Builder;

@Builder
public record RidesRequest(
        String title,
        int numberOfSeats,
        Location to,
        Location from,
        double fullPrice,
        double halfPrice) {
}
