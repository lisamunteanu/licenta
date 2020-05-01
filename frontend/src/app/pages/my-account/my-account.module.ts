import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {myAccountRoute} from './my-account.route';
import {MyAccountComponent} from './my-account.component';

@NgModule({
  imports: [
    RouterModule.forChild([myAccountRoute]),
    CommonModule
  ],
  declarations: [
    MyAccountComponent
  ]
})

export class MyAccountModule {
}
