package eduardohrq.rides.models.RidesUser.repository;

import eduardohrq.rides.models.RidesUser.RidesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RidesUserRepository extends JpaRepository<RidesUser, UUID> { }
