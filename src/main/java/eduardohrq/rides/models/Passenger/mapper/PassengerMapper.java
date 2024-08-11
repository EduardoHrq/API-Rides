package eduardohrq.rides.models.Passenger.mapper;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.Passenger.dtos.PassengerRequest;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponse;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponseInfo;

import java.util.List;

public interface PassengerMapper {

    Passenger toPassenger(PassengerRequest passengerRequest);

    PassengerResponse toResponse(Passenger passenger);

    List<PassengerResponse> toResponseList(List<Passenger> passenger);

    PassengerResponseInfo toInfo(Passenger passenger);

    List<PassengerResponseInfo> listToInfo(List<Passenger> passenger);

}
