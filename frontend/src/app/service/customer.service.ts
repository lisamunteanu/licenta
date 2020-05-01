import {Injectable} from "@angular/core";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from '../model/customer.model';

type EntityResponseType = HttpResponse<Customer>;
type EntityArrayResponseType = HttpResponse<Customer[]>;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public resourceUrl = 'http://localhost:80/customers';

  constructor(protected http: HttpClient) {
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    return this.http.get<Customer[]>(this.resourceUrl, {observe: 'response'});
  }

  findByUsername(username: string): Observable<EntityResponseType> {
    return this.http
      .get<Customer>(`${this.resourceUrl}/${username}`, {observe: 'response'});
  }

  register(customer: Customer): Observable<{}> {
    return this.http.post<string>(this.resourceUrl + '/register', customer);
  }

}
