package pl.edu.pbs.system_rejstracji_czesci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;
import pl.edu.pbs.system_rejstracji_czesci.repository.AutoPartRepository;
import pl.edu.pbs.system_rejstracji_czesci.repository.AutoRepository;
import pl.edu.pbs.system_rejstracji_czesci.repository.DriverRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AutoService {
    @Autowired
    private AutoRepository autoRepository;
    private DriverRepository driverRepository;

    public List<Auto> getAllAutos(){
        return Arrays.asList(new Auto(1, "Skoda", "Octavia", "Diesel", "Hatchback", "Driver1", "Czechy", 2003, 200000, 99, 4000, false));
        //return autoRepository.findAll();
    }

    public Optional<Auto> getAutoById(int autoId){
        return autoRepository.findById(autoId);
    }

    public Optional<Driver> getDriverById(int driverId){ return driverRepository.findById(driverId); }

    //TODO 1.Funkcje zwracająca listę list wszystkich AutoBrand, AutoModel, autoFuelType, autoBodyType, autoYear, autoHP
    public List<String> getAutoBrands(){
        return Arrays.asList("Skoda", "Volvo");
//        return getAllAutos().stream()
//                .map(Auto::getAutoBrand)
//                .distinct()
//                .collect(Collectors.toList());
    }

    public List<String> getAutoModelsByBrand(String AutoBrand){
        return autoRepository.findAutosByAutoBrand(AutoBrand).stream()
                .map(Auto::getAutoModel)
                .collect(Collectors.toList());
    }

//    public List<String> getAutoFuelTypesByModel(String AutoModel){
//        return getAllAutos().stream()
//                .filter(auto -> !Objects.equals(auto.getAutoModel(), AutoBrand))
//                .map(Auto::getAutoBrand)
//                .collect(Collectors.toList());
//    }
}
