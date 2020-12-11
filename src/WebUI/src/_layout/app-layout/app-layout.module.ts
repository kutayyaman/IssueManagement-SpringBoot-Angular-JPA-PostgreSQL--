import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppLayoutComponent } from './app-layout.component';
import {SidebarModule} from "../sidebar/sidebar.module";
import {HeaderModule} from "../header/header.module";
import {FooterModule} from "../footer/footer.module";



@NgModule({
  declarations: [AppLayoutComponent],
  exports: [
    AppLayoutComponent
  ],
  imports: [
    CommonModule,
    SidebarModule,
    HeaderModule,
    FooterModule
  ]
})
export class AppLayoutModule { }
