package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import com.vaadin.flow.data.converter.StringToFloatConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.function.SerializableFunction;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;
import pl.edu.pbs.system_rejstracji_czesci.service.DriverService;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A Designer generated component for the add-part-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-part-form")
@JsModule("./views/add-part-form.ts")
@Route("/addPart")
public class AddPartForm extends LitTemplate {

    @Id("partName")
    private TextField partName;
    @Id("partBrand")
    private TextField partBrand;
    @Id("partModel")
    private TextField partModel;
    @Id("partFromWhere")
    private TextField partFromWhere;
    @Id("partDamaged")
    private Checkbox partDamaged;
    @Id("savePartButton")
    private Button savePartButton;
    @Id("partPrice")
    private TextField partPrice;
    @Id("closeFormButton")
    private Button closeFormButton;
    @Id("deletePartButton")
    private Button deletePartButton;
    @Id("partFromWho")
    private ComboBox<Driver> partFromWho;

    Binder<AutoPart> binder = new BeanValidationBinder<>(AutoPart.class);
    DriverService driverService;
    /**
     * Creates a new AddPartForm.
     */
    public AddPartForm(DriverService driverService) {
        this.driverService = driverService;
        savePartButton.addClickListener(event -> validateAndSave());
        deletePartButton.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean())));
        closeFormButton.addClickListener(event -> fireEvent(new CloseEvent(this)));

        partFromWho.setItems(driverService.getAllDrivers());
        partFromWho.setItemLabelGenerator(Driver::getDriverName);

        binder.forField(partPrice)
                .withConverter(new StringToFloatConverter("Failed to convert to float"))
                .bind(AutoPart::getPartPrice, AutoPart::setPartPrice);
        binder.forField(partFromWho)
                .withConverter(new DriverToIntConverter())
                .bind(AutoPart::getPartFromWho, AutoPart::setPartFromWho);

        binder.bindInstanceFields(this);
    }

    private void validateAndSave(){
        if(binder.isValid()){
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }

    public void setAutoPart(AutoPart autoPart){
        partFromWho.setItems(driverService.getAllDrivers());
        binder.setBean(autoPart);
    }

    //Events handling
    public static abstract class AddPartFormEvent extends ComponentEvent<AddPartForm>{
        private final AutoPart autoPart;

        protected AddPartFormEvent(AddPartForm source, AutoPart autoPart){
            super(source, false);
            this.autoPart=autoPart;
        }

        public AutoPart getAutoPart(){
            return autoPart;
        }
    }

    public static class SaveEvent extends AddPartFormEvent{
        SaveEvent(AddPartForm source, AutoPart autoPart){
            super(source, autoPart);
        }
    }

    public static class DeleteEvent extends AddPartFormEvent{
        DeleteEvent(AddPartForm source, AutoPart autoPart){
            super(source, autoPart);
        }
    }

    public static class CloseEvent extends AddPartFormEvent{
        CloseEvent(AddPartForm source){
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener){
        return getEventBus().addListener(eventType, listener);
    }

    public class DriverToIntConverter implements Converter<Driver, Integer>{

        @Override
        public Result<Integer> convertToModel(Driver driver, ValueContext valueContext) {
            if(driver == null){
                return Result.error("Driver can not be null");
            }
            return Result.ok(driver.getDriverId());
        }

        @Override
        public Driver convertToPresentation(Integer integer, ValueContext valueContext) {
            if(integer == null){
                return driverService.getAnyDriver();
            }
            Optional<Driver> driver = driverService.getDriverById(integer);
            return driver.orElse(null);
        }
    }
}

