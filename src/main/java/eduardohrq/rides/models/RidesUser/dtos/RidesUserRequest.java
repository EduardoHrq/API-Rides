package eduardohrq.rides.models.RidesUser.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RidesUserRequest {
    private String name;
    private String email;
    private String phone;
    private String CPF;
}
