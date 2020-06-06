import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {orderConfirmationRoute} from "./order-confirmation.route";
import {OrderConfirmationComponent} from "./order-confirmation.component";
import {CategoriesListModule} from "../../components/categories-list/categories-list.module";

@NgModule({
  imports: [
    RouterModule.forChild([orderConfirmationRoute]),
    CommonModule,
    CategoriesListModule
  ],
  declarations: [
    OrderConfirmationComponent
  ]
})

export class OrderConfirmationModule {
}
