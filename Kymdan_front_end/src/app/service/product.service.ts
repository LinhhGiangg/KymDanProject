import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public readonly API: string = 'http://localhost:8080/product';

  constructor(
    public http: HttpClient
  ) {
  }

  findProductByTypeID(typeID): Observable<any> {
    return this.http.get(this.API + '/view/' + typeID);
  }

  saveCart(userName, productID, productInformation): Observable<any> {
    return this.http.get(this.API + '/save-cart/' + userName + '/' + productID + '/' + productInformation);
  }
}
