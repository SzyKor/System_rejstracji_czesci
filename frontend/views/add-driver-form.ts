import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';

@customElement('add-driver-form')
export class AddPartForm extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-form-layout style="height: 100%; width: 100%;">
 <vaadin-combo-box id="driversCB"></vaadin-combo-box>
 <vaadin-text-field label="Imię i nazwisko" placeholder="Podaj imię i nazwisko" id="driverName"></vaadin-text-field>
 <vaadin-text-field label="Adres mail" placeholder="Podaj email" id="driverEmail"></vaadin-text-field>
 <vaadin-text-field label="Numer telefonu" placeholder="Podaj numer telefonu" id="driverPhoneNumber"></vaadin-text-field>
 <vaadin-button id="saveDriverButton" theme="primary">
   Zapisz 
 </vaadin-button>
 <vaadin-button theme="error" id="deleteDriverButton">
   Usuń 
 </vaadin-button>
 <vaadin-button id="closeFormButton">
   Anuluj 
 </vaadin-button>
</vaadin-form-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
