package eduardohrq.rides.models.Passenger.mapper;

import eduardohrq.rides.models.Passenger.Passenger;
import eduardohrq.rides.models.Passenger.dtos.PassengerRequest;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponse;
import eduardohrq.rides.models.Passenger.dtos.PassengerResponseInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class PassengerMapperImpl implements PassengerMapper {

    @Override
    public Passenger toPassenger(PassengerRequest passengerRequest) {
        return Passenger.builder()
                .name(passengerRequest.getName())
                .email(passengerRequest.getEmail())
                .build();
    }

    @Override
    public PassengerResponse toResponse(Passenger passenger) {
        return PassengerResponse.builder()
                .name(passenger.getName())
                .email(passenger.getEmail())
                .id(passenger.getPassengerID())
                .build();
    }

    @Override
    public List<PassengerResponse> toResponseList(List<Passenger> passenger) {

        return passenger.stream().map(this::toResponse).toList();
    }

    @Override
    public PassengerResponseInfo toInfo(Passenger passenger) {
        return PassengerResponseInfo.builder()
                .id(passenger.getPassengerID())
                .name(passenger.getName())
                .email(passenger.getEmail())
                .build();
    }

    @Override
    public List<PassengerResponseInfo> listToInfo(List<Passenger> passenger) {
        return passenger.stream().map(this::toInfo).toList();
    }

}
