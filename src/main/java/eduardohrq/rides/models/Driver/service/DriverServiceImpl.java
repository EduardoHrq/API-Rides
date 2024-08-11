package eduardohrq.rides.models.Driver.service;

import eduardohrq.rides.models.Driver.Driver;
import eduardohrq.rides.models.Driver.dtos.DriverRequest;
import eduardohrq.rides.models.Driver.dtos.DriverResponse;
import eduardohrq.rides.models.Driver.dtos.DriverResponseInfo;
import eduardohrq.rides.models.Driver.mapper.DriverMapper;
import eduardohrq.rides.models.Driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Override
    public DriverResponse createNewDriver(DriverRequest driverRequest) {
        var driver = driverRepository.save(driverMapper.toDriver(driverRequest));
        return driverMapper.toResponse(driver);
    }

    @Override
    public String removeDriver(UUID DriverId) {
        var toRemove = this.driverRepository.findById(DriverId);
        this.driverRepository.delete(toRemove.get());
        return "DRIVER: " + toRemove.get().getName() + " -> Removed";
    }

    @Override
    public Driver thisDriverExists(UUID driverId) {
        return this.driverRepository.findById(driverId).orElseThrow(() -> new NullPointerException("Not Found"));
    }

    @Override
    public DriverResponseInfo getInfo(UUID driverId) {

        var driver = this.thisDriverExists(driverId);

        return this.driverMapper.toInfo(driver);
    }
}
