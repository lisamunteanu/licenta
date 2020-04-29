import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {HomepageComponent} from './homepage.component';
import {homeRoute} from './homepage.route';

@NgModule({
  imports: [
    RouterModule.forChild([homeRoute]),
    CommonModule
  ],
  declarations: [
    HomepageComponent
  ]
})

export class HomepageModule {
}
