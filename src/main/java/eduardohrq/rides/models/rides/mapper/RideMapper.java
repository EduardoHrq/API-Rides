package eduardohrq.rides.models.rides.mapper;

import eduardohrq.rides.models.rides.Rides;
import eduardohrq.rides.models.rides.dtos.RidesRequest;
import eduardohrq.rides.models.rides.dtos.RidesResponseInfo;

public interface RideMapper {
    Rides toRides(RidesRequest ridesRequest);

    RidesResponseInfo toInfo(Rides rides);
}
