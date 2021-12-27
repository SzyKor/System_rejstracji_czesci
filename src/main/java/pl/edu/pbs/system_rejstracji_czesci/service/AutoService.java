package pl.edu.pbs.system_rejstracji_czesci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;
import pl.edu.pbs.system_rejstracji_czesci.repository.AutoRepository;
import pl.edu.pbs.system_rejstracji_czesci.repository.DriverRepository;

import java.util.*;

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

    public Optional<Driver> getDriverById(int driverId){
        return driverRepository.findById(driverId);
    }
}
