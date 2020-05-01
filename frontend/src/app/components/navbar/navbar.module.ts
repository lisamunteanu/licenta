import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {MyAccountComponent} from "../../pages/my-account/my-account.component";
import {root} from "rxjs/internal-compatibility";

@NgModule({
  imports: [
    RouterModule.forChild([root]),
    CommonModule
  ],
  declarations: [
    MyAccountComponent
  ]
})

export class NavbarModule {
}
