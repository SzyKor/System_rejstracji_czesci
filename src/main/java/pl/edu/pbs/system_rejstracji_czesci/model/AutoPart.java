package pl.edu.pbs.system_rejstracji_czesci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoPartId;
    private String partName;
    private String partBrand;
    private String partModel;
    private String partFromWho;
    private String partFromWhere;
    private float partPrice;
    private boolean partDamaged;
}
