import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
  {
    path: 'product/:id',
    loadChildren: () => import('./pages/products-listing/products-listing.module').then(m => m.ProductsListingModule)
  },
  {
    path: '',
    loadChildren: () => import('./pages/homepage/homepage.module').then(m => m.HomepageModule)
  },
  {
    path: 'details/:id',
    loadChildren: () => import('./pages/product-details/product-details.module').then(m => m.ProductDetailsModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./pages/register/register.module').then(m => m.RegisterModule)
  },
  {
    path: 'my-account',
    loadChildren: () => import('./pages/my-account/my-account.module').then(m => m.MyAccountModule)
  },
  {
    path: 'my-cart',
    loadChildren: () => import('./pages/my-cart/my-cart.module').then(m => m.MyCartModule)
  },
  {
    path: 'checkout',
    loadChildren: () => import('./pages/checkout/checkout.module').then(m => m.CheckoutModule)
  },
  {
    path: 'order-confirmation',
    loadChildren: () => import('./pages/order-confirmation/order-confirmation.module').then(m => m.OrderConfirmationModule)
  },
  {
    path: 'no-results-found',
    loadChildren: () => import('./pages/no-results-found/no-results-found.module').then(m => m.NoResultsFoundModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
