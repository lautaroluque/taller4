import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { LoginResponse } from './usuario';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({providedIn: 'root'})
export class LoginService {

  constructor(private httpClient: HttpClient) { }
 
  logIn(username: string, password: string): Observable<LoginResponse> {
    return this.httpClient.post<LoginResponse>('http://localhost:8080/login',{username: username, password: password}, httpOptions)
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('userid');
  }
  
}
