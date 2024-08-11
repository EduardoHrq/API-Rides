package eduardohrq.rides.models.Passenger;

import eduardohrq.rides.models.enums.Roles;
import eduardohrq.rides.models.rides.Rides;
import eduardohrq.rides.models.ticket.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Enumerated(EnumType.STRING)
    private final Roles role = Roles.PASSENGER;
    @Id
    @Column(name = "passenger_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID passengerID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @JoinColumn(name = "rides_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Rides ride;

    @OneToMany(orphanRemoval = true, mappedBy = "passenger")
    private List<Ticket> tickets;
}
