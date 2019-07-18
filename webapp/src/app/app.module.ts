import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatToolbarModule, MatCardModule } from '@angular/material';
import { CardsComponent } from './cards/cards.component';


@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    CardsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
