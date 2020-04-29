import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {loginRoute} from './login.route';
import {LoginComponent} from './login.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    RouterModule.forChild([loginRoute]),
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [
    LoginComponent
  ]
})

export class LoginModule {
}
