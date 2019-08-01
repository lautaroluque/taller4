import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UploadResponse } from './uploadresponse';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private imagenesUrl = 'http://localhost:8080/subir/';

  constructor(private http: HttpClient) { }

  public upload(file: File, username: string): Observable<UploadResponse> {
      const formData: FormData = new FormData();
      formData.append('file', file, file.name);
      return this.http.post<UploadResponse>(`${this.imagenesUrl}${username}`, formData)
  }
}
