package eduardohrq.rides.models.Driver.repository;

import eduardohrq.rides.models.Driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> { }
