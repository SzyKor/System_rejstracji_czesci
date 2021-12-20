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
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoId;
    private String autoBrand;
    private String autoModel;
    private String autoFuelType;
    private String autoBodyType;
    private String autoFromWho;
    private String autoFromWhere;
    private int autoYear;
    private int autoMileage;
    private int autoHP;
    private float autoPrice;
    private boolean autoDamaged;
}
