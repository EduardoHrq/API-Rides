package eduardohrq.rides.models.Driver;

import eduardohrq.rides.models.enums.Roles;
import eduardohrq.rides.models.rides.Rides;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @Column(name = "driver_ID")
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

    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private final Roles role = Roles.DRIVER;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Rides ride;
}
