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
    console.log('auth');
    return this.http.post<Credentials>(this.resourceUrl, credentials, {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json'),
      observe: 'response'
    });
  }
}
