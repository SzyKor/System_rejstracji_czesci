package pl.edu.pbs.system_rejstracji_czesci.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoPartBto {
    private String partName;
    private String partBrand;
    private String partModel;
    private String partFromWho;
    private String partFromWhere;
    private float partPrice;
    private boolean partDamaged;
}
