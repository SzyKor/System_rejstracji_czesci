package pl.edu.pbs.system_rejstracji_czesci;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

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
    @Id("testTF")
    private TextField testTF;

    public MainUi() {
        testBT.addClickListener(event -> {
            Notification.show("Działa");
        });
    }

//    @PostConstruct
//    private void init() {
//        testTF = new TextField("Test test");
//        testBT = new Button("Klikaj");
//
//        add(testBT, testTF);
//    }
}
