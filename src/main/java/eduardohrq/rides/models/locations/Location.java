package eduardohrq.rides.models.locations;

import eduardohrq.rides.models.enums.States;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private States state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String specification;
}
