package eduardohrq.rides.models.Passenger.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PassengerResponseInfo(
        UUID id,
        String name,
        String email
) {
}
