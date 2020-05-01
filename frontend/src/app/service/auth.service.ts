import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Credentials} from "../model/credentials.model";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public resourceUrl = 'http://localhost:80/auth/';

  constructor(protected http: HttpClient) {
  }

  authenticate(credentials: Credentials): Observable<any> {
    return this.http.post<Credentials>(this.resourceUrl, credentials, {
      observe: 'response'
    }).pipe(map(res => {
      res.headers.get('authorization');
      localStorage.setItem('access_token', res.headers.get('authorization'));
    }));
  }

  logout() {
    localStorage.removeItem('access_token');
  }

  public isLoggedIn(): boolean {
    return localStorage.getItem('access_token') !== null;
  }
}
