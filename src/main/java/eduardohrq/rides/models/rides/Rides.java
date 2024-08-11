package eduardohrq.rides.models.rides;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.locations.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Rides {

    @Id
    @Column(name = "rides_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ridesID;

    @Column(nullable = false)
    private Long viewId;

    @Column(nullable = false)
    private String title;

    @JoinColumn(name = "to_location")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Location to;

    @JoinColumn(name = "from_location")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Location from;

    @Column(nullable = false)
    private int numberOfSeats;

    @Column(nullable = false)
    private double fullPrice;

    @Column(nullable = false)
    private double halfPrice;

    @OneToMany(orphanRemoval = true, mappedBy = "ride", fetch = FetchType.EAGER)
    private List<Passenger> passengers;

}