package eduardohrq.rides.models.Driver.dtos;

import eduardohrq.rides.models.rides.dtos.RidesRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record DriverRequest(
        @NotBlank
        String name,
        String email,
        String phone,
        String CPF,
        RidesRequest ridesRequest
) {
}
