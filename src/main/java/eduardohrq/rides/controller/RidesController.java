package eduardohrq.rides.controller;

import eduardohrq.rides.models.Passenger.dtos.PassengerRequest;
import eduardohrq.rides.models.Passenger.dtos.PassengerRequestId;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponse;
import eduardohrq.rides.models.Passenger.service.PassengerService;
import eduardohrq.rides.models.rides.service.RidesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/rides")
public class RidesController {

    private final RidesService ridesService;
    private final PassengerService passengerService;

    @PostMapping("{id}/invite")
    public ResponseEntity<Map<String, List<PassengerResponse>>> invitePassenger(@PathVariable UUID id, @RequestBody PassengerRequest... passengerRequest) {
        // VERIFICAR SE A CARONA É DO DRIVER

        var ride = this.ridesService.getRides(id);

        var inviteTo = this.passengerService.invitePassenger(passengerRequest, ride);

        return ResponseEntity.status(HttpStatus.CREATED).body(inviteTo);
    }

    @PostMapping("tickets/half")
    public ResponseEntity<Map<String, String>> addHalfTicketToPassenger(@RequestBody PassengerRequestId passengerId) {
        var res = this.passengerService.addHalfTicket(passengerId.passengerId());

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("tickets/full")
    public ResponseEntity<Map<String, String>> addFullTicketToPassenger(@RequestBody PassengerRequestId passengerId) {
        var res = this.passengerService.addFullTicket(passengerId.passengerId());

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
