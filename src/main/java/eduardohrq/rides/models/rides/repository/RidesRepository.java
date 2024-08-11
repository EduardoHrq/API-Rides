package eduardohrq.rides.models.rides.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import eduardohrq.rides.models.rides.Rides;

public interface RidesRepository extends JpaRepository<Rides, UUID>{
  
}
