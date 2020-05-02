import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Credentials} from "../model/credentials.model";
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {CustomerService} from "./customer.service";
import {Customer} from "../model/customer.model";
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public resourceUrl = 'http://localhost:80/auth/';

  constructor(protected http: HttpClient, private customerService: CustomerService) {
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
    localStorage.removeItem('customer_id');
  }

  public isLoggedIn(): boolean {
    return localStorage.getItem('access_token') !== null;
  }

  public saveCustomerId(credentials: Credentials): void {
    this.customerService.findByUsername(credentials.username).subscribe((rez: HttpResponse<Customer>) => {
      console.log(rez.body.id.toString());
      localStorage.setItem('customer_id', rez.body.id.toString());
    });
  }
}
