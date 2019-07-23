import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario'
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  usuario: Usuario;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.usuario = new Usuario();
  }

  registro() {
      return this.httpClient.post<Usuario>('http://localhost:8080/usuarios',this.usuario, httpOptions)
      .pipe(retry(1),catchError(this.handleError)).subscribe();
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
