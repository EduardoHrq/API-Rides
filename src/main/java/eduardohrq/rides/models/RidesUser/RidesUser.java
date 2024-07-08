package eduardohrq.rides.models.RidesUser;

import eduardohrq.rides.models.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RidesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID driverID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String CPF;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;
}
