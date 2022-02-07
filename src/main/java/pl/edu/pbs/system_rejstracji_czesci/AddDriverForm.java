package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.shared.Registration;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;
import pl.edu.pbs.system_rejstracji_czesci.model.Driver;
import pl.edu.pbs.system_rejstracji_czesci.service.DriverService;

/**
 * A Designer generated component for the add-driver-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-driver-form")
@JsModule("./views/add-driver-form.ts")
public class AddDriverForm extends LitTemplate {

    @Id("driverName")
    private TextField driverName;
    @Id("driverEmail")
    private TextField driverEmail;
    @Id("driverPhoneNumber")
    private TextField driverPhoneNumber;
    @Id("saveDriverButton")
    private Button saveDriverButton;
    @Id("deleteDriverButton")
    private Button deleteDriverButton;
    @Id("closeFormButton")
    private Button closeFormButton;
    @Id("driversCB")
    private ComboBox<Driver> driversCB;

    Binder<Driver> binder = new BeanValidationBinder<>(Driver.class);
    DriverService driverService;
    /**
     * Creates a new AddDriverForm.
     */
    public AddDriverForm(DriverService driverService) {
        this.driverService = driverService;
        saveDriverButton.addClickListener(event -> validateAndSave());
        deleteDriverButton.addClickListener(event -> fireEvent(new AddDriverForm.DeleteEvent(this, binder.getBean())));
        closeFormButton.addClickListener(event -> fireEvent(new AddDriverForm.CloseEvent(this)));

        binder.forField(driverPhoneNumber)
                .withConverter(new StringToIntegerConverter("Failed conversion to Integer"))
                .bind(Driver::getDriverPhoneNumber, Driver::setDriverPhoneNumber);

        binder.bindInstanceFields(this);

        driversCB.setItems(driverService.getAllDrivers());
        driversCB.setItemLabelGenerator(Driver::getDriverName);
        driversCB.addValueChangeListener(event -> {
            if(event.getValue() != null){
                setDriver(event.getValue());
            }
        });
    }

    private void validateAndSave(){
        if(binder.isValid()){
            fireEvent(new AddDriverForm.SaveEvent(this, binder.getBean()));
        }
    }

    public void setDriver(Driver driver){
        driversCB.setItems(driverService.getAllDrivers());
        binder.setBean(driver);
    }


    //Events handling
    public static abstract class AddDriverFormEvent extends ComponentEvent<AddDriverForm> {
        private final Driver driver;

        protected AddDriverFormEvent(AddDriverForm source, Driver driver){
            super(source, false);
            this.driver=driver;
        }

        public Driver getDriver(){
            return driver;
        }
    }

    public static class SaveEvent extends AddDriverForm.AddDriverFormEvent {
        SaveEvent(AddDriverForm source, Driver driver){
            super(source, driver);
        }
    }

    public static class DeleteEvent extends AddDriverForm.AddDriverFormEvent {
        DeleteEvent(AddDriverForm source, Driver driver){
            super(source, driver);
        }
    }

    public static class CloseEvent extends AddDriverForm.AddDriverFormEvent {
        CloseEvent(AddDriverForm source){
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener){
        return getEventBus().addListener(eventType, listener);
    }
}
