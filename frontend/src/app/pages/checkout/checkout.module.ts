import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {checkoutRoute} from './checkout.route';
import {CheckoutComponent} from './checkout.component';
import {CartEntryCardModule} from "../../components/cart-entry-card/cart-entry-card.module";

@NgModule({
  imports: [
    RouterModule.forChild([checkoutRoute]),
    CommonModule,
    CartEntryCardModule
  ],
  declarations: [
    CheckoutComponent
  ]
})

export class CheckoutModule {
}
