import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {checkoutRoute} from './checkout.route';
import {CheckoutComponent} from './checkout.component';

@NgModule({
  imports: [
    RouterModule.forChild([checkoutRoute]),
    CommonModule
  ],
  declarations: [
    CheckoutComponent
  ]
})

export class CheckoutModule {
}
