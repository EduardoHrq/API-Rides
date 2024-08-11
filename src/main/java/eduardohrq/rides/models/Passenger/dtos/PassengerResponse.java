package eduardohrq.rides.models.Passenger.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PassengerResponse(
        UUID id,
        String name,
        String email
) {
}
