import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/grid/src/vaadin-grid-column.js';
import '@vaadin/grid/src/vaadin-grid-column-group.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/combo-box/src/vaadin-combo-box.js';

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
 <vaadin-horizontal-layout theme="spacing" style="align-items: flex-end;">
   <vaadin-combo-box id="nameCB" label="Nazwa części"></vaadin-combo-box>
  <vaadin-combo-box id="brandCB" label="Marka"></vaadin-combo-box>
  <vaadin-combo-box id="modelCB" label="Model"></vaadin-combo-box>
  <vaadin-combo-box id="damagedCB" label="Czy uszkodzona"></vaadin-combo-box>
  <vaadin-combo-box id="priceCB" label="Cena"></vaadin-combo-box>
  <vaadin-button id="testBT">
    Button 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-grid style="align-self: stretch;" id="grid" is-attached></vaadin-grid>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
