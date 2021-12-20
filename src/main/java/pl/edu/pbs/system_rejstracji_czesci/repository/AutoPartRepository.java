package pl.edu.pbs.system_rejstracji_czesci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;

public interface AutoPartRepository extends JpaRepository<AutoPart, Integer> {
}
