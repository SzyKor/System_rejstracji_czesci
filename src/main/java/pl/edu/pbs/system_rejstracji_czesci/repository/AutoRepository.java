package pl.edu.pbs.system_rejstracji_czesci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
