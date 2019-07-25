import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { CardsComponent } from './cards/cards.component';
import { AuthGaurdService } from './auth-gaurd.service';
import { RegistroComponent } from './registro/registro.component';
import { EditorNotaComponent } from './editor-nota/editor-nota.component';

const routes: Routes = [
  { path: 'registro', component: RegistroComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate:[AuthGaurdService] },
  { path: 'nota/:id', component: EditorNotaComponent, canActivate:[AuthGaurdService] },
  { path: 'notas', component: CardsComponent, canActivate:[AuthGaurdService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
