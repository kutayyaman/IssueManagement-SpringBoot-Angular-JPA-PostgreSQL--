import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app.routing.module";
import {FooterComponent} from "../_layout/footer/footer.component";
import {SidebarComponent} from "../_layout/sidebar/sidebar.component";
import {FooterModule} from "../_layout/footer/footer.module";
import {SidebarModule} from "../_layout/sidebar/sidebar.module";
import {HeaderModule} from "../_layout/header/header.module";
import {AppLayoutModule} from "../_layout/app-layout/app-layout.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FooterModule,
    SidebarModule,
    HeaderModule,
    AppLayoutModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
