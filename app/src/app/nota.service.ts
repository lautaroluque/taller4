import { Injectable } from '@angular/core';
import { Nota } from './nota';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NotaService {

  private notasUrl = 'http://localhost:8080/notas';

  constructor(private http: HttpClient, private router: Router) { }

  getNotas(username: string): Observable<Nota[]> {
    const url = `${this.notasUrl}/${username}`; 
    return this.http.get<Nota[]>(url);
  }

  getNota(username: string, id: string): Observable<Nota> {
    const url = `${this.notasUrl}/${username}/${id}`; 
    return this.http.get<Nota>(url);
  }

  putNota(nota: Nota): Observable<Nota> {
    const url = `${this.notasUrl}/${nota.id}`;
    return this.http.put<Nota>(url, nota);
  }

  postNota(nota: Nota): Observable<Nota> {
    const url = `${this.notasUrl}`;
    return this.http.post<Nota>(url, nota);
  }

  deleteNota(nota: Nota): Observable<any> {
    const url = `${this.notasUrl}/${nota.id}`;
    return this.http.delete(url);
  }

  editNota(nota: Nota): void {
    this.router.navigate([`nota/${nota.id}`]);
  }
}
