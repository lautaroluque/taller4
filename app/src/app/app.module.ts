import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule,
         MatDialogModule, MatTableModule, MatMenuModule, MatIconModule, MatProgressSpinnerModule,
         MatNativeDateModule, MatDatepickerModule } from '@angular/material';
import { CardsComponent } from './cards/cards.component';
import { LoginComponent } from './login/login.component';
import { LoginInterceptorService } from './logininterceptor.service';
import { LoginService } from './login.service';
import { AppRoutingModule } from './app-routing.module';
import { LogoutComponent } from './logout/logout.component';
import { RegistroComponent } from './registro/registro.component';
import { NuevaNotaComponent } from './nueva-nota/nueva-nota.component';
import { EditorNotaComponent } from './editor-nota/editor-nota.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    CardsComponent,
    LoginComponent,
    LogoutComponent,
    RegistroComponent,
    NuevaNotaComponent,
    EditorNotaComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule, 
    MatInputModule,
    MatButtonModule, 
    MatDialogModule, 
    MatTableModule, 
    MatMenuModule, 
    MatIconModule, 
    MatProgressSpinnerModule,
    MatDatepickerModule,
    MatNativeDateModule,
    CKEditorModule,
    AppRoutingModule
  ],
  providers: [
    LoginService,
    {
    provide:HTTP_INTERCEPTORS, useClass:LoginInterceptorService, multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
