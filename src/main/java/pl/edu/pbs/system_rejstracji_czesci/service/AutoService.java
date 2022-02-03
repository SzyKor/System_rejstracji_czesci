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
        return autoRepository.findAll();
    }

    public Optional<Auto> getAutoById(int autoId){
        return autoRepository.findById(autoId);
    }

    public Optional<Driver> getDriverById(int driverId){ return driverRepository.findById(driverId); }

//    public List<String> getAutoBrands(){
//        return getAllAutos().stream()
//                .map(Auto::getAutoBrand)
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    public List<String> getAutoModelsByBrand(String AutoBrand){
//        return autoRepository.findAutosByAutoBrand(AutoBrand).stream()
//                .map(Auto::getAutoModel)
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    public List<String> getAutoBodyByBrandAndModel(String AutoBrand, String AutoModel){
//        return autoRepository.findAutosByAutoBrandAndAutoModel(AutoBrand, AutoModel).stream()
//                .map(Auto::getAutoBodyType)
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    public List<String> getAutoFuelTypesByBrandAndModel(String AutoBrand, String AutoModel){
//        return autoRepository.findAutosByAutoBrandAndAutoModel(AutoBrand, AutoModel).stream()
//                .map(Auto::getAutoFuelType)
//                .distinct()
//                .collect(Collectors.toList());
//    }
}
