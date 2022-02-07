package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;
import pl.edu.pbs.system_rejstracji_czesci.service.AutoPartService;
import pl.edu.pbs.system_rejstracji_czesci.service.AutoService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A Designer generated component for the main-ui template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-ui")
@JsModule("./views/main-ui.ts")
@Route("")
public class MainUi extends LitTemplate {

    @Id("testBT")
    private Button testBT;
    @Id("grid")
    private Grid<AutoPart> grid;
    @Id("nameCB")
    private ComboBox<String> nameCB;
    @Id("brandCB")
    private ComboBox<String> brandCB;
    @Id("modelCB")
    private ComboBox<String> modelCB;
    @Id("priceCB")
    private ComboBox<Float> priceCB;
    @Id("damagedCB")
    private ComboBox<String> damagedCB;
    @Id("form")
    private AddPartForm form;
    @Id("addPartButton")
    private Button addPartButton;

    private final AutoPartService autoPartService;
    private List<AutoPart> autoPartsList;


    public MainUi(AutoPartService autoPartService) {
        this.autoPartService = autoPartService;

        autoPartsList = autoPartService.getAllAutoParts();

        grid.addColumn(AutoPart::getPartName).setHeader("Nazwa części");
        grid.addColumn(AutoPart::getPartBrand).setHeader("Marka części");
        grid.addColumn(AutoPart::getPartModel).setHeader("Model części");
        grid.addColumn(AutoPart::isPartDamaged).setHeader("Uszkodzona");
        grid.addColumn(AutoPart::getPartPrice).setHeader("Wartość");
        grid.addColumn(AutoPart::getPartFromWhere).setHeader("Skąd");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        updateGrid();

        nameCB.setItems(autoPartsList.stream().map(AutoPart::getPartName).distinct().collect(Collectors.toList()));
        brandCB.setItems(autoPartsList.stream().map(AutoPart::getPartBrand).distinct().collect(Collectors.toList()));
        modelCB.setItems(autoPartsList.stream().map(AutoPart::getPartModel).distinct().collect(Collectors.toList()));
        priceCB.setItems(autoPartsList.stream().map(AutoPart::getPartPrice).distinct().collect(Collectors.toList()));
        damagedCB.setItems("Tak", "Nie");
    }

    private void updateGrid(){
        grid.setItems(autoPartsList);
    }

    @PostConstruct
    private void init() {
        testBT.addClickListener(event -> {
            nameCB.setValue(null);
            brandCB.setValue(null);
            modelCB.setValue(null);
            priceCB.setValue(null);
            damagedCB.setValue(null);
        });
        nameCB.addValueChangeListener(event -> refreshAutoPartsList());
        brandCB.addValueChangeListener(event -> refreshAutoPartsList());
        modelCB.addValueChangeListener(event -> refreshAutoPartsList());
        priceCB.addValueChangeListener(event -> refreshAutoPartsList());
        damagedCB.addValueChangeListener(event -> refreshAutoPartsList());

        grid.asSingleSelect().addValueChangeListener(event -> openContactEditor(event.getValue()));

        closeContactEditor();
        form.addListener(AddPartForm.SaveEvent.class, this::saveAutoPart);
        form.addListener(AddPartForm.DeleteEvent.class, this::deleteAutoPart);
        form.addListener(AddPartForm.CloseEvent.class, e -> closeContactEditor());

        addPartButton.addClickListener(event -> openContactEditor(new AutoPart()));
    }

    private void openContactEditor(AutoPart autoPart) {
        if(autoPart == null){
            closeContactEditor();
        } else{
            form.setAutoPart(autoPart);
            form.setVisible(true);
        }
    }

    private void saveAutoPart(AddPartForm.SaveEvent event){
        autoPartService.saveAutoPart(event.getAutoPart());
        refreshAutoPartsList();
        closeContactEditor();
    }

    private void deleteAutoPart(AddPartForm.DeleteEvent event){
        autoPartService.deleteAutoPart(event.getAutoPart());
        refreshAutoPartsList();
        closeContactEditor();
    }

    private void closeContactEditor(){
        form.setVisible(false);
        grid.asSingleSelect().clear();
    }

    private void refreshAutoPartsList(){
        boolean isName = nameCB.getValue() != null;
        boolean isBrand = brandCB.getValue() != null;
        boolean isModel = modelCB.getValue() != null;
        boolean isPrice = priceCB.getValue() != null;
        boolean isDamageSelected = damagedCB.getValue() != null;
        boolean isDamaged = Objects.equals(damagedCB.getValue(), "Tak");
        autoPartsList = autoPartService.getAllAutoParts();
        //if (!isName && !isBrand && !isModel && !isPrice) return;
        if(isName){
            autoPartsList = autoPartsList.stream().filter(auto -> Objects.equals(auto.getPartName(), nameCB.getValue())).collect(Collectors.toList());
        }
        if(isBrand){
            autoPartsList = autoPartsList.stream().filter(auto -> Objects.equals(auto.getPartBrand(), brandCB.getValue())).collect(Collectors.toList());
        }
        if(isModel){
            autoPartsList = autoPartsList.stream().filter(auto -> Objects.equals(auto.getPartModel(), modelCB.getValue())).collect(Collectors.toList());
        }
        if(isPrice){
            autoPartsList = autoPartsList.stream().filter(auto -> auto.getPartPrice() == priceCB.getValue()).collect(Collectors.toList());
        }
        if(isDamageSelected){
            autoPartsList = autoPartsList.stream().filter(auto -> auto.isPartDamaged() == isDamaged).collect(Collectors.toList());
        }
        updateGrid();
    }
}
