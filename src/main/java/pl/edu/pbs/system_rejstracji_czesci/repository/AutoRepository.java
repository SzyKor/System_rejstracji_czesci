package pl.edu.pbs.system_rejstracji_czesci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
    List<Auto> findAutosByAutoBrand(String autoBrand);
    List<Auto> findAutosByAutoBrandAndAutoModel(String autoBrand, String autoModel);
    List<Auto> findAutosByAutoBrandAndAutoModelAndAutoFuelType(String autoBrand, String autoModel, String autoFuelType);
    List<Auto> findAutosByAutoBrandAndAutoModelAndAutoFuelTypeAndAutoBodyType(String autoBrand, String autoModel, String autoFuelType, String autoBodyType);
    List<Auto> findAutosByAutoBrandAndAutoModelAndAutoFuelTypeAndAutoBodyTypeAndAutoYear(String autoBrand, String autoModel, String autoFuelType, String autoBodyType, int autoYear);
    List<Auto> findAutosByAutoBrandAndAutoModelAndAutoFuelTypeAndAutoBodyTypeAndAutoYearAndAutoHP(String autoBrand, String autoModel, String autoFuelType, String autoBodyType, int autoYear, int autoHP);

}
