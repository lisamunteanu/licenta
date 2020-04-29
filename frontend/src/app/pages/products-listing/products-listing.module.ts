import {NgModule} from '@angular/core';
import {ProductsListingComponent} from './products-listing.component';
import {RouterModule} from '@angular/router';
import {productsListingRoute} from './products-listing.route';
import {ProductCardModule} from '../../components/product-card/product-card.module';
import {CommonModule} from '@angular/common';

@NgModule({
  imports: [
    RouterModule.forChild([productsListingRoute]),
    ProductCardModule,
    CommonModule
  ],
  declarations: [
    ProductsListingComponent
  ]
})

export class ProductsListingModule {
}
