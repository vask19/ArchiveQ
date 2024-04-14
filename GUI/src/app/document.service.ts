import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(private http: HttpClient) { }

  fetchData(): Observable<any> {
    return this.http.get('http://localhost:8080/documents');
  }

  postData(data: any): Observable<any> {
    return this.http.post('http://localhost:8080/documents', data);
  }
}
