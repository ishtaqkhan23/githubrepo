import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    const requestOptions: object = {
      /* other options here */
      responseType: 'text'
    };
    return this.http.get<string>('http://localhost:8762/signin?username=' + username + '&password=' + password, requestOptions);
  }
}
