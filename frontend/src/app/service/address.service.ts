import {HttpClient, HttpParams, HttpResponse} from '@angular/common/http';
import {Address} from '../model/address.model';
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Category} from "../model/category.model";
import {Customer} from "../model/customer.model";
import {CartEntry} from "../model/cartEntry.model";


type EntityResponseType = HttpResponse<Address>;
type EntityArrayResponseType = HttpResponse<Address[]>;

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  public resourceUrl = 'http://localhost:80/customers/addresses';

  constructor(protected http: HttpClient) {
  }

  query(customerId: string): Observable<EntityArrayResponseType> {
    let parameters = new HttpParams();
    parameters = parameters.append('customerId', customerId);
    return this.http
      .get<Address[]>(`${this.resourceUrl}/by`, {params: parameters, observe: 'response'});
  }

  saveAddress(address?: Address, customerId?: string, type?: string): Observable<EntityResponseType> {
    let parameters = new HttpParams();
    parameters = parameters.append('customerId', customerId);
    parameters = parameters.append('type', type);

    return this.http
      .post<CartEntry>(`${this.resourceUrl}/add-new-address`, address, {
        params: parameters,
        observe: 'response'
      });
  }
}
