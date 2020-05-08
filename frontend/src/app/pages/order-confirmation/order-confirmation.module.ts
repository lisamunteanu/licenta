import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {orderConfirmationRoute} from "./order-confirmation.route";
import {OrderConfirmationComponent} from "./order-confirmation.component";

@NgModule({
  imports: [
    RouterModule.forChild([orderConfirmationRoute]),
    CommonModule
  ],
  declarations: [
    OrderConfirmationComponent
  ]
})

export class OrderConfirmationModule {
}
