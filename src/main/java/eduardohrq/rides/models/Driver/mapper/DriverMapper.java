package eduardohrq.rides.models.Driver.mapper;

import eduardohrq.rides.models.Driver.Driver;
import eduardohrq.rides.models.Driver.dtos.DriverRequest;
import eduardohrq.rides.models.Driver.dtos.DriverResponse;
import eduardohrq.rides.models.Driver.dtos.DriverResponseInfo;

public interface DriverMapper {
    Driver toDriver(DriverRequest driverRequest);

    DriverResponse toResponse(Driver driver);

    DriverResponseInfo toInfo(Driver driver);

}
