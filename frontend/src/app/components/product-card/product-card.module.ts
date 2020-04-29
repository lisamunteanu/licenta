import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {productsListingRoute} from "../../pages/products-listing/products-listing.route";
import {ProductCardComponent} from "./product-card.component";
import {CommonModule} from "@angular/common";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    ProductCardComponent
  ],
  exports: [
    ProductCardComponent
  ]
})

export class ProductCardModule {
}
