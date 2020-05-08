import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CartEntryCardComponent} from './cart-entry-card.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    CartEntryCardComponent
  ],
  exports: [
    CartEntryCardComponent
  ]
})

export class CartEntryCardModule {
}
