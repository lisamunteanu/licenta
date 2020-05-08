import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {myCartRoute} from './my-cart.route';
import {MyCartComponent} from './my-cart.component';
import {CartEntryCardModule} from '../../components/cart-entry-card/cart-entry-card.module';

@NgModule({
  imports: [
    RouterModule.forChild([myCartRoute]),
    CommonModule,
    CartEntryCardModule
  ],
  declarations: [
    MyCartComponent
  ]
})

export class MyCartModule {
}
