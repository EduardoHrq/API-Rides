package eduardohrq.rides.models.Passenger.service;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.Passenger.dtos.PassengerRequest;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponse;
import eduardohrq.rides.models.rides.Rides;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PassengerService {

    Map<String, List<PassengerResponse>> invitePassenger(PassengerRequest[] passengerRequest, Rides rides);

    Map<String, String> addHalfTicket(UUID passengerId);

    Map<String, String> addFullTicket(UUID passengerId);

    Passenger thisPassengerExists(UUID passengerId);
}
