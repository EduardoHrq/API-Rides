package eduardohrq.rides.models.Driver.mapper;

import eduardohrq.rides.models.Driver.Driver;
import eduardohrq.rides.models.Driver.dtos.DriverRequest;
import eduardohrq.rides.models.Driver.dtos.DriverResponse;
import eduardohrq.rides.models.Driver.dtos.DriverResponseInfo;
import eduardohrq.rides.models.rides.mapper.RideMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DriverMapperImpl implements DriverMapper {

    private final RideMapper rideMapper;

    @Override
    public Driver toDriver(DriverRequest driverRequest) {
        return Driver.builder().name(driverRequest.name())
                .phone(driverRequest.phone())
                .email(driverRequest.email())
                .CPF(driverRequest.CPF())
                .ride(rideMapper.toRides(driverRequest.ridesRequest()))
                .build();
    }

    @Override
    public DriverResponse toResponse(Driver driver) {
        return DriverResponse.builder()
                .id(driver.getDriverID())
                .name(driver.getName())
                .phone(driver.getPhone())
                .email(driver.getEmail())
                .rideId(driver.getRide().getRidesID())
                .build();
    }

    @Override
    public DriverResponseInfo toInfo(Driver driver) {
        return DriverResponseInfo.builder()
                .id(driver.getDriverID())
                .name(driver.getName())
                .email(driver.getEmail())
                .ride(this.rideMapper.toInfo(driver.getRide()))
                .build();
    }
}
