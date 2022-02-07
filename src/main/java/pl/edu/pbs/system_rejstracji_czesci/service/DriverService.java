package pl.edu.pbs.system_rejstracji_czesci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;
import pl.edu.pbs.system_rejstracji_czesci.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService{
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Integer id){
        return driverRepository.findById(id);
    }
}
