import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {Category} from "../model/category.model";

type EntityResponseType = HttpResponse<Category>;
type EntityArrayResponseType = HttpResponse<Category[]>;

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  public resourceUrl = 'http://localhost:80/products/categories';

  constructor(protected http: HttpClient) {
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    return this.http.get<Category[]>(this.resourceUrl, {observe: 'response'});
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<Category>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  findAllUniverseCategories(): Observable<EntityArrayResponseType>{
    return this.http.get<Category[]>(`${this.resourceUrl}/universe`,{ observe: 'response' });
  }

}
