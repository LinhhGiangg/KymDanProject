import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  protected readonly API: string = 'http://localhost:8080/product';

  constructor(
    protected http: HttpClient
  ) {
  }

  findProductByTypeName(typeID): Observable<any> {
    return this.http.get(this.API + '/list/' + typeID);
  }

  findProductByTypeAndPrice(typeID, price): Observable<any> {
    return this.http.get(this.API + '/list/' + typeID + '/' + price);
  }
}
