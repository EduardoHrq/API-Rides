package eduardohrq.rides.models.ticket.service;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.enums.TicketType;
import eduardohrq.rides.models.ticket.Ticket;
import eduardohrq.rides.models.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket saveTicket(Passenger passenger, TicketType ticketType) {
        return this.ticketRepository.save(Ticket.builder().ticketType(ticketType).passenger(passenger).build());
    }
}
