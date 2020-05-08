import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {SideMenuComponent} from "./side-menu.component";
import {MatSidenavModule} from "@angular/material/sidenav";

@NgModule({
  imports: [
    CommonModule,
    MatSidenavModule
  ],
  declarations: [
    SideMenuComponent
  ],
  exports: [
    SideMenuComponent
  ]
})

export class SideMenuModule {
}
