package eduardohrq.rides.models.Driver.service;

import eduardohrq.rides.models.Driver.Driver;
import eduardohrq.rides.models.Driver.dtos.DriverRequest;
import eduardohrq.rides.models.Driver.dtos.DriverResponse;
import eduardohrq.rides.models.Driver.dtos.DriverResponseInfo;

import java.util.UUID;

public interface DriverService {
    DriverResponse createNewDriver(DriverRequest driverRequest);

    String removeDriver(UUID DriverId);

    Driver thisDriverExists(UUID driverId);

    DriverResponseInfo getInfo(UUID driverId);
}
