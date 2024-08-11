package eduardohrq.rides.models.Driver.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DriverResponse(UUID id, String name, String email, String phone, UUID rideId) {
}
