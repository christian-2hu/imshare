import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Environment } from '../environment/environment';
import { Response } from '../models/response.model';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http: HttpClient) { }

  public uploadImage(file: any): Observable<Response> {
    return this.http.post<Response>(Environment.baseUrl, file);
  }

}
