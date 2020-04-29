import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from './register.component';
import {registerRoute} from './register.route';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    RouterModule.forChild([registerRoute]),
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [
    RegisterComponent
  ]
})

export class RegisterModule {
}
