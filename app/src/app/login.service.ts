import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { LoginResponse } from './usuario';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({providedIn: 'root'})
export class LoginService {

  constructor(private httpClient: HttpClient) { }
 
  logIn(username: string, password: string) {
    return this.httpClient
    .post<LoginResponse>('http://localhost:8080/login',{username: username, password: password}, httpOptions)
    .pipe(retry(1),catchError(this.handleError)).subscribe(userData => {
      sessionStorage.setItem('username',username);
      let tokenStr= 'Bearer '+userData.token;
      sessionStorage.setItem('token', tokenStr);
      return userData;
     });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
  
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('Ocurrio un error:', error.error.message);
    } else {
      console.error(
        `Ocurrio un error en el backend. Codigo: ${error.status}, ` +
        `Error: ${error.error}`);
    }
    return throwError(
      'Error desconocido.');
  };
  
}
