import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DescriptorService {

  constructor(private http: HttpClient) { }

  fetchData(): Observable<any> {
    return this.http.get('http://localhost:8080/descriptors');
  }

  postData(data: any): Observable<any> {
    return this.http.post('http://localhost:8080/descriptor', data);
  }

  sendDataToBackend(name: string, value: string) : Observable<any> {
    const descriptorData = { name: name, value: value };
    console.log(name)
    console.log(1)
    console.log(value)
    return this.http.post<any>('http://localhost:8080/descriptors', descriptorData);
  }

}
