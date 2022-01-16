package pl.edu.pbs.system_rejstracji_czesci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;

import java.util.List;
import java.util.Optional;

public interface AutoPartRepository extends JpaRepository<AutoPart, Integer> {
    Optional<AutoPart> findFirstByPartName(String partName);
    List<AutoPart> findAutoPartsByPartName(String partName);
    List<AutoPart> findAutoPartsByPartBrand(String partBrand);
    List<AutoPart> findAutoPartsByPartModel(String partModel);
    List<AutoPart> findAutoPartsByPartNameAndPartBrandAndPartModel(String partName, String partBrand, String partModel);
}
