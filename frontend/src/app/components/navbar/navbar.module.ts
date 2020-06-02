import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {root} from "rxjs/internal-compatibility";
import {NavbarComponent} from "./navbar.component";

@NgModule({
  imports: [
    RouterModule.forChild([root]),
    CommonModule
  ],
  declarations: [
    NavbarComponent
  ]
})

export class NavbarModule {
}
