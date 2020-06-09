import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExportService {
  public resourceUrl = 'http://localhost:80/exports';

  constructor(protected http: HttpClient) {
  }

  exportOrders(): Observable<any> {
    return this.http.get<any>(`${this.resourceUrl}/orders-export/`, {observe: 'response'});
  }

  exportOrderEntries(): Observable<any> {
    return this.http.get<any>(`${this.resourceUrl}/order-entries-export/`, {observe: 'response'});
  }

}
