package eduardohrq.rides.models.ticket;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.enums.TicketType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private final LocalDate timestamp = LocalDate.now();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "passenger_ID")
    private Passenger passenger;

}
