import {HttpClient, HttpParams, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Order} from '../model/order.model';
import {OrderEntry} from '../model/orderEntry.model';
import {Observable} from "rxjs";
import {CartEntry} from "../model/cartEntry.model";
import {CartEntriesList} from "../model/cartEntriesList.model";
import {Category} from "../model/category.model";

type OrderResponseType = HttpResponse<Order>;
type OrderArrayResponseType = HttpResponse<Order[]>;
type OrderEntryResponseType = HttpResponse<OrderEntry>;
type OrderEntryArrayResponseType = HttpResponse<OrderEntry[]>;

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  public resourceUrl = 'http://localhost:80/orders';

  constructor(protected http: HttpClient) {
  }

  placeOrder(cartEntries: CartEntry[], customerId: string, deliveryMode: string,
             paymentMode: string, quantity: number): Observable<OrderResponseType> {
    let parameters = new HttpParams();
    parameters = parameters.append('customerId', customerId.toString()).append('paymentMode', paymentMode)
      .append('deliveryMode', deliveryMode).append('quantity', quantity.toString());
    const cartEntriesList = new CartEntriesList();
    cartEntriesList.cartEntries = cartEntries;
    return this.http.post<Order>(`${this.resourceUrl}/place-order`, cartEntriesList, {
      params: parameters,
      observe: 'response'
    });
  }

  getOrdersByCustomerId(req?: any): Observable<OrderArrayResponseType> {
    let parameters = new HttpParams();
    const customerId: string = localStorage.getItem('customer_id');
    parameters = parameters.append('customerId', customerId);
    return this.http
      .get<Order[]>(`${this.resourceUrl}/by`, {params: parameters, observe: 'response'});
  }

  getAllOrders(): Observable<OrderArrayResponseType> {
    return this.http.get<Order[]>(this.resourceUrl, {observe: 'response'});
  }
}
