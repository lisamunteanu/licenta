import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {CartEntry} from '../model/cartEntry.model';

type CartEntryResponseType = HttpResponse<CartEntry>;
type CartEntryArrayResponseType = HttpResponse<CartEntry[]>;

@Injectable({
  providedIn: 'root'
})
export class CartService {
  public resourceUrl = 'http://localhost:80/orders/cart';

  constructor(protected http: HttpClient) {
  }

  getCartEntriesByUserId(userId?: string): Observable<CartEntryArrayResponseType> {
    let parameters = new HttpParams();
    parameters = parameters.append('userId', userId);
    return this.http
      .get<CartEntry[]>(`${this.resourceUrl}/cart-entries/by`, {params: parameters, observe: 'response'});
  }

  addToCart(cartEntry?: CartEntry, userId?: string): Observable<CartEntryResponseType> {
    let parameters = new HttpParams();
    parameters = parameters.append('userId', userId);

    return this.http
      .post<CartEntry>(`${this.resourceUrl}/add-to-cart`, cartEntry, {
        params: parameters,
        observe: 'response'
      });
  }

  removeOrUpdateCart(cartEntryId?: string, userId?: string): Observable<any> {
    let parameters = new HttpParams();
    parameters = parameters.append('cartEntryId', cartEntryId);
    parameters = parameters.append('userId', userId);
    return this.http.delete(`${this.resourceUrl}/cart-entries/by`, {
      params: parameters,
      observe: 'response'
    });
  }

}
