package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToFloatConverter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import pl.edu.pbs.system_rejstracji_czesci.model.AutoPart;

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
    @Id("partFromWho")
    private TextField partFromWho;
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

    Binder<AutoPart> binder = new BeanValidationBinder<>(AutoPart.class);

    /**
     * Creates a new AddPartForm.
     */
    public AddPartForm() {
        savePartButton.addClickListener(event -> validateAndSave());
        deletePartButton.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean())));
        closeFormButton.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.forField(partPrice)
                .withConverter(new StringToFloatConverter(""))
                .bind(AutoPart::getPartPrice, AutoPart::setPartPrice);

        binder.bindInstanceFields(this);
    }

    private void validateAndSave(){
        if(binder.isValid()){
            fireEvent(new SaveEvent(this, binder.getBean()));
        }
    }

    public void setAutoPart(AutoPart autoPart){
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
}

