import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public readonly APIType: string = 'http://localhost:8080/productType';
  public readonly API: string = 'http://localhost:8080/product';

  constructor(
    public http: HttpClient
  ) {
  }

  findAllProductType(): Observable<any> {
    return this.http.get(this.APIType + '/list');
  }

  findProductTypeByPrice(price): Observable<any> {
    return this.http.get(this.APIType + '/list/' + price);
  }

  findProductTypeByID(typeID): Observable<any> {
    return this.http.get(this.APIType + '/find/' + typeID);
  }

  findProductByTypeID(typeID): Observable<any> {
    return this.http.get(this.API + '/view/' + typeID);
  }

  addNewProductType(productType): Observable<any> {
    return this.http.post(this.APIType + '/add', productType, {headers: {skip: 'true'}});
  }

  saveCart(userName, productID, productInformation): Observable<any> {
    return this.http.get(this.API + '/save-cart/' + userName + '/' + productID + '/' + productInformation);
  }
}
