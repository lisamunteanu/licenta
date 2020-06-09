import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {AdminComponent} from './admin.component';
import {adminRoute} from './admin.route';
import {CommonModule} from '@angular/common';

@NgModule({
  imports: [
    RouterModule.forChild([adminRoute]),
    CommonModule
  ],
  declarations: [
    AdminComponent
  ]
})

export class AdminModule {
}
