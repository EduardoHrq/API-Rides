package eduardohrq.rides.models.Driver.dtos;

import eduardohrq.rides.models.rides.dtos.RidesResponseInfo;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DriverResponseInfo(
        UUID id,
        String name,
        String email,
        RidesResponseInfo ride
) {
}
