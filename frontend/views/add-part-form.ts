import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/button/src/vaadin-button.js';

@customElement('add-part-form')
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
 <vaadin-text-field label="Nazwa części" placeholder="Podaj nazwę części" id="partName"></vaadin-text-field>
 <vaadin-text-field label="Marka części" placeholder="Podaj markę części" id="partBrand"></vaadin-text-field>
 <vaadin-text-field label="Model części" placeholder="Podaj model części" id="partModel"></vaadin-text-field>
 <vaadin-combo-box id="partFromWho" label="Od kogo"></vaadin-combo-box>
 <vaadin-text-field label="Skąd" placeholder="Podaj pochodzenie części" id="partFromWhere"></vaadin-text-field>
 <vaadin-text-field label="Cena" placeholder="Podaj cenę do sprzedaży" id="partPrice"></vaadin-text-field>
 <label draggable="true" vaadin-dnd-layout-item="true">
  <designer-text>
   <designer-text> 
   </designer-text>
  </designer-text></label>
 <label draggable="true" vaadin-dnd-layout-item="true" style="margin: var(--lumo-space-s); margin-right: 0; margin-bottom: 0; margin-left: 0;">
  <designer-text>
    Uszkodzona 
  </designer-text></label>
 <label draggable="true" vaadin-dnd-layout-item="true"></label>
 <vaadin-checkbox id="partDamaged" label="Uszkodzona">
  Text
 </vaadin-checkbox>
 <vaadin-button id="savePartButton" theme="primary">
   Zapisz 
 </vaadin-button>
 <vaadin-button theme="error" id="deletePartButton">
   Usuń 
 </vaadin-button>
 <vaadin-button id="closeFormButton">
   Anuluj 
 </vaadin-button>
</vaadin-form-layout>
<label>Label</label>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
