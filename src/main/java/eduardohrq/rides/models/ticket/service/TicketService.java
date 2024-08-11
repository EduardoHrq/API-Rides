package eduardohrq.rides.models.ticket.service;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.enums.TicketType;
import eduardohrq.rides.models.ticket.Ticket;

public interface TicketService {

    Ticket saveTicket(Passenger passenger, TicketType ticketType);
}
