import { Injectable } from '@angular/core';
import { Nota } from './nota';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NotaService {

  private notasUrl = 'http://localhost:8080/notas';

  constructor(private http: HttpClient) { }

  getNotas(username: string): Observable<Nota[]> {
    const url = `${this.notasUrl}/${username}`; 
    return this.http.get<Nota[]>(url);
  }
}
