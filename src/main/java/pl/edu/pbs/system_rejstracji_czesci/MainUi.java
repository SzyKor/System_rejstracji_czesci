package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.edu.pbs.system_rejstracji_czesci.model.Auto;
import pl.edu.pbs.system_rejstracji_czesci.service.AutoService;

import javax.annotation.PostConstruct;

/**
 * A Designer generated component for the main-ui template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-ui")
@JsModule("./main-ui.ts")
@Route("")
public class MainUi extends LitTemplate {

    @Id("testBT")
    private Button testBT;
    @Id("grid")
    private Grid<Auto> grid;
    @Id("brandCB")
    private ComboBox<String> brandCB;

    private final AutoService autoService;
    @Id("modelCB")
    private ComboBox<String> modelCB;
    @Id("fuelTypeCB")
    private ComboBox<String> fuelTypeCB;
    @Id("bodyTypeCB")
    private ComboBox<String> bodyTypeCB;
    @Id("yearCB")
    private ComboBox<String> yearCB;
    @Id("horsePowerCB")
    private ComboBox<String> horsePowerCB;

    public MainUi(AutoService autoService) {
        this.autoService = autoService;
        //TODO 2.Przerobić grid na wyświetlanie AutoPart po wyszukaniu parametrów w CB na górze
        grid.addColumn(Auto::getAutoBrand).setHeader("Brand");
        grid.addColumn(Auto::getAutoBodyType).setHeader("BodyType");
        grid.addColumn(Auto::getAutoHP).setHeader("getAutoHP");
        grid.addColumn(Auto::getAutoFuelType).setHeader("getAutoFuelType");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        updateGrid();

        brandCB.setItems(autoService.getAutoBrands());
    }

    private void updateGrid(){
        grid.setItems(autoService.getAllAutos());
    }

    @PostConstruct
    private void init() {
        //TODO 1. ogarnięcie tego do współpracy z autoService
        testBT.addClickListener(event -> {
            Notification.show("Działa!");
            autoService.getAllAutos();
        });
        brandCB.addValueChangeListener(event -> {
            Notification.show("Działa!");
            modelCB.setItems(autoService.getAutoModelsByBrand(brandCB.getValue()));
        });
    }
}
