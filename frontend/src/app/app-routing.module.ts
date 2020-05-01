import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
  {
    path: 'products',
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
