import {NgModule} from "@angular/core";
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
