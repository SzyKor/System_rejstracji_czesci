package pl.edu.pbs.system_rejstracji_czesci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;
import pl.edu.pbs.system_rejstracji_czesci.repository.AutoRepository;

import java.util.List;

@Service
public class AutoService {
    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> getAllAutos(){
        return autoRepository.findAll();
    }

}
