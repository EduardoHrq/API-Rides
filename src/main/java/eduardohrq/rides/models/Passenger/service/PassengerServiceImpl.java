package eduardohrq.rides.models.Passenger.service;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.Passenger.dtos.PassengerRequest;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponse;
import eduardohrq.rides.models.Passenger.mapper.PassengerMapper;
import eduardohrq.rides.models.Passenger.repository.PassengerRepository;
import eduardohrq.rides.models.enums.TicketType;
import eduardohrq.rides.models.rides.Rides;
import eduardohrq.rides.models.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final TicketService ticketService;

    @Override
    public Map<String, List<PassengerResponse>> invitePassenger(PassengerRequest[] passengerRequest, Rides rides) {

        if (passengerRequest.length == 0) {
            return Map.of("Nenhum convite foi enviado", List.of());
        }

        var passengerListToSave = Stream.of(passengerRequest).map(invite -> {
            var mapped = this.passengerMapper.toPassenger(invite);
            mapped.setRide(rides);
            return mapped;
        }).toList();

        this.passengerRepository.saveAll(passengerListToSave);

        return Map.of("InvitedTo", this.passengerMapper.toResponseList(passengerListToSave));
    }

    @Override
    public Map<String, String> addHalfTicket(UUID passengerId) {

        var passenger = this.thisPassengerExists(passengerId);

        this.ticketService.saveTicket(passenger, TicketType.HALF);

        return Map.of("halfTicketTo", passenger.getName());
    }

    @Override
    public Map<String, String> addFullTicket(UUID passengerId) {
        var passenger = this.thisPassengerExists(passengerId);

        this.ticketService.saveTicket(passenger, TicketType.FULL);

        return Map.of("fullTicketTo", passenger.getName());
    }

    @Override
    public Passenger thisPassengerExists(UUID passengerId) {
        return this.passengerRepository.findById(passengerId).orElseThrow(() -> new NullPointerException("Not found"));
    }


}
