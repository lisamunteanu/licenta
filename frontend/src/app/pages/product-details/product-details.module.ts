import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {productDetailsRoute} from './product-details.route';
import {ProductDetailsComponent} from './product-details.component';

@NgModule({
  imports: [
    RouterModule.forChild([productDetailsRoute]),
    CommonModule
  ],
  declarations: [
    ProductDetailsComponent
  ]
})

export class ProductDetailsModule {
}
