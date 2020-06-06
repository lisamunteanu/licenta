import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {CategoriesListComponent} from "./categories-list.component";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    CategoriesListComponent
  ],
  exports: [
    CategoriesListComponent
  ]
})

export class CategoriesListModule {
}
