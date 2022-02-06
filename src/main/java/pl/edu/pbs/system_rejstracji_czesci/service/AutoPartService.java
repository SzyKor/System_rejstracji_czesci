package pl.edu.pbs.system_rejstracji_czesci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;
import pl.edu.pbs.system_rejstracji_czesci.repository.AutoPartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutoPartService {
    @Autowired
    private AutoPartRepository autoPartRepository;

    public List<AutoPart> getAllAutoParts(){
        return autoPartRepository.findAll();
    }

    public Optional<AutoPart> getAutoPartByName(String partName){
        return autoPartRepository.findFirstByPartName(partName);
    }

    public List<AutoPart> getAutoPartsByName(String partName){
        return autoPartRepository.findAutoPartsByPartName(partName);
    }

    public List<AutoPart> getAutoPartsByPartBrand(String partBrand){
        return autoPartRepository.findAutoPartsByPartBrand(partBrand);
    }

    public List<AutoPart> getAutoPartsByPartModel(String partModel){
        return autoPartRepository.findAutoPartsByPartModel(partModel);
    }

//    public boolean updateAutoPartPriceByPartName(String partName, String partBrand, String partModel, Float newPrice){
//        List<AutoPart> autoParts = autoPartRepository.findAutoPartsByPartNameAndPartBrandAndPartModel(partName, partBrand, partModel);
//        if(!autoParts.isEmpty()){
//            for (AutoPart ap: autoParts) {
//                ap.setPartPrice(newPrice);
//                autoPartRepository.save(ap);
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public boolean updateAutoPartPriceByPartName(AutoPartBto autoPartBto, Float newPrice){
//        if(autoPartBto.getPartName().isEmpty() || autoPartBto.getPartBrand().isEmpty() || autoPartBto.getPartModel().isEmpty()){
//            return false;
//        }
//        List<AutoPart> autoParts = autoPartRepository.findAutoPartsByPartNameAndPartBrandAndPartModel(autoPartBto.getPartName(), autoPartBto.getPartBrand(), autoPartBto.getPartModel());
//        if(!autoParts.isEmpty()){
//            for (AutoPart ap: autoParts) {
//                ap.setPartPrice(newPrice);
//                autoPartRepository.save(ap);
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public AutoPart addNewAutoPart(AutoPartBto autoPartBto){
//        AutoPart autoPart = new AutoPart();
//        autoPart.setPartName(autoPartBto.getPartName());
//        autoPart.setPartBrand(autoPartBto.getPartBrand());
//        autoPart.setPartModel(autoPartBto.getPartModel());
//        autoPart.setPartFromWho(autoPartBto.getPartFromWho());
//        autoPart.setPartFromWhere(autoPartBto.getPartFromWhere());
//        autoPart.setPartPrice(autoPartBto.getPartPrice());
//        autoPart.setPartDamaged(autoPartBto.isPartDamaged());
//        return autoPartRepository.save(autoPart);
//    }

    public void saveAutoPart(AutoPart autoPart){
        autoPartRepository.save(autoPart);
    }

    public void deleteAutoPart(AutoPart autoPart){
        autoPartRepository.delete(autoPart);
    }
}
