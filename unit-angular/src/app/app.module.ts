import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserItemsComponent } from './user/user-items/user-items.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { UserNewComponent } from './user/user-new/user-new.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    UserItemsComponent,
    UserDetailsComponent,
    UserNewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
