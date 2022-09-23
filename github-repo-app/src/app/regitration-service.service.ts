import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './User';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegitrationServiceService {
  registrationUrl = 'http://localhost:8762/register/signup';
  constructor(private http: HttpClient) { }

  registerUser(user: User): Observable<any> {
    console.log('registering user...');
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    const requestOptions: object = {
      /* other options here */
      responseType: 'text'
    };
    return this.http.post(this.registrationUrl, user, requestOptions);
  }
}
