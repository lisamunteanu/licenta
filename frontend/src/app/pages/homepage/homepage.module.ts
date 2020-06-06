import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {HomepageComponent} from './homepage.component';
import {homeRoute} from './homepage.route';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {CategoriesListModule} from "../../components/categories-list/categories-list.module";

@NgModule({
  imports: [
    RouterModule.forChild([homeRoute]),
    CommonModule,
    NgbModule,
    CategoriesListModule
  ],
  declarations: [
    HomepageComponent
  ]
})

export class HomepageModule {
}
