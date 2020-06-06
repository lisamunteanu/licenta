import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {NoResultsFoundComponent} from './no-results-found.component';
import {noResultsFoundRoute} from './no-results-found.route';
import {CategoriesListModule} from "../../components/categories-list/categories-list.module";

@NgModule({
  imports: [
    RouterModule.forChild([noResultsFoundRoute]),
    CommonModule,
    CategoriesListModule
  ],
  declarations: [
    NoResultsFoundComponent
  ]
})

export class NoResultsFoundModule {
}
