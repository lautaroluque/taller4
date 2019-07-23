import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.loginservice.isUserLoggedIn()){
      return true;
    }
    this.router.navigate(['login']);
    return false;    
  }

  constructor(private router: Router, private loginservice: LoginService) { }
}
