package pl.edu.pbs.system_rejstracji_czesci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
