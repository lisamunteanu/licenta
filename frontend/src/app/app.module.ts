import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import {ProductsListingModule} from './pages/products-listing/products-listing.module';
import {HomepageModule} from './pages/homepage/homepage.module';
import {ProductDetailsModule} from './pages/product-details/product-details.module';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatButtonModule} from '@angular/material/button';
import {LoginModule} from './pages/login/login.module';
import {RegisterModule} from './pages/register/register.module';
import {MyAccountModule} from './pages/my-account/my-account.module';
import {MyCartModule} from './pages/my-cart/my-cart.module';
import {OrderConfirmationModule} from './pages/order-confirmation/order-confirmation.module';
import {CheckoutModule} from './pages/checkout/checkout.module';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import {NoResultsFoundModule} from './pages/no-results-found/no-results-found.module';
import {CategoriesListModule} from "./components/categories-list/categories-list.module";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    NgbModule,
    HttpClientModule,
    ProductsListingModule,
    HomepageModule,
    ProductDetailsModule,
    MatTooltipModule,
    MatButtonModule,
    LoginModule,
    RegisterModule,
    MyAccountModule,
    MyCartModule,
    OrderConfirmationModule,
    CheckoutModule,
    NoResultsFoundModule,
    CategoriesListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
