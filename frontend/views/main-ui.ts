import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid-column.js';
import '@vaadin/grid/src/vaadin-grid-column-group.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import './add-part-form';
import '@vaadin/button/src/vaadin-button.js';
import './add-driver-form';

@customElement('main-ui')
export class MainUi extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="align-items: flex-end; margin: var(--lumo-space-xs); width: 90%;">
  <vaadin-combo-box id="nameCB" label="Nazwa części"></vaadin-combo-box>
  <vaadin-combo-box id="brandCB" label="Marka"></vaadin-combo-box>
  <vaadin-combo-box id="modelCB" label="Model"></vaadin-combo-box>
  <vaadin-combo-box id="damagedCB" label="Czy uszkodzona"></vaadin-combo-box>
  <vaadin-combo-box id="priceCB" label="Cena"></vaadin-combo-box>
  <vaadin-button id="testBT">
    Resetuj filtry 
  </vaadin-button>
  <vaadin-button id="addPartButton" style="margin: var(--lumo-space-xs); margin-left: var(--lumo-space-xl);">
    Dodaj część 
  </vaadin-button>
  <vaadin-button id="addDriverButton">
   Kierowcy
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="height: 80%; width: 100%;">
  <vaadin-grid style="flex:2; flex-shrink: 0; flex-grow: 1; height: 100%;" id="grid" is-attached></vaadin-grid>
  <add-part-form id="AutoPartForm" style="flex:1; flex-shrink: 0; flex-grow: 0.5;"></add-part-form>
  <add-driver-form id="DriverForm" style="flex:1; flex-shrink: 0; flex-grow: 0.5;"></add-driver-form>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
