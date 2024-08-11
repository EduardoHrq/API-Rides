package eduardohrq.rides.models.rides.mapper;

import eduardohrq.rides.models.Passenger.mapper.PassengerMapper;
import eduardohrq.rides.models.locations.Location;
import eduardohrq.rides.models.locations.services.LocationServices;
import eduardohrq.rides.models.rides.Rides;
import eduardohrq.rides.models.rides.dtos.RidesRequest;
import eduardohrq.rides.models.rides.dtos.RidesResponseInfo;
import eduardohrq.rides.models.rides.repository.RidesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class RideMapperImpl implements RideMapper {

    private final RidesRepository ridesRepository;
    private final LocationServices locationServices;
    private final PassengerMapper passengerMapper;

    @Override
    public Rides toRides(RidesRequest ridesRequest) {

        var count = this.ridesRepository.count();

        var toLocationsList = this.locationServices.findByAttributes(ridesRequest.to().getState(),
                ridesRequest.to().getCity());
        var fromtoLocationsList = this.locationServices.findByAttributes(ridesRequest.from().getState(),
                ridesRequest.from().getCity());

        Location to = null;
        Location from = null;

        if (toLocationsList.isEmpty()) {
            to = ridesRequest.to();
        } else {
            for (Optional<Location> location : toLocationsList) {
                var local = location.get();
                if (local.getSpecification().equals(ridesRequest.to().getSpecification())) {
                    to = local;
                    break;
                } else {
                    to = ridesRequest.to();
                }
            }
        }

        if (fromtoLocationsList.isEmpty()) {
            from = ridesRequest.from();
        } else {
            for (Optional<Location> location : fromtoLocationsList) {
                var local = location.get();
                if (local.getSpecification().equals(ridesRequest.from().getSpecification())) {
                    from = local;
                    break;
                } else {
                    from = ridesRequest.from();
                }
            }
        }

        return Rides.builder()
                .to(to)
                .from(from)
                .viewId(count + 1)
                .title(ridesRequest.title())
                .halfPrice(ridesRequest.halfPrice())
                .fullPrice(ridesRequest.fullPrice())
                .numberOfSeats(ridesRequest.numberOfSeats())
                .build();
    }

    @Override
    public RidesResponseInfo toInfo(Rides rides) {
        return RidesResponseInfo.builder()
                .to(rides.getTo())
                .from(rides.getFrom())
                .title(rides.getTitle())
                .rideId(rides.getRidesID())
                .passengers(this.passengerMapper.listToInfo(rides.getPassengers()))
                .build();
    }
}
