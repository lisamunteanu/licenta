import {HttpClient, HttpResponse} from '@angular/common/http';
import {Product} from '../model/product.model';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

type EntityResponseType = HttpResponse<Product>;
type EntityArrayResponseType = HttpResponse<Product[]>;

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public resourceUrl = 'http://localhost:80/products';

  constructor(protected http: HttpClient) {
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    return this.http.get<Product[]>(this.resourceUrl, {observe: 'response'});
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<Product>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

}
