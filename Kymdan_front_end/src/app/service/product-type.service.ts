import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {
  public readonly API: string = 'http://localhost:8080/productType';

  constructor(
    public http: HttpClient
  ) {
  }

  findAll(): Observable<any> {
    return this.http.get(this.API + '/list');
  }

  findByPrice(price): Observable<any> {
    return this.http.get(this.API + '/list/' + price);
  }

  findByID(typeID): Observable<any> {
    return this.http.get(this.API + '/find/' + typeID);
  }

  addNew(productType): Observable<any> {
    return this.http.post(this.API + '/add', productType, {headers: {skip: 'true'}});
  }

  edit(productType): Observable<any> {
    return this.http.post(this.API + '/edit', productType, {headers: {skip: 'true'}});
  }

  delete(typeName): Observable<any> {
    return this.http.get(this.API + '/delete/' + typeName);
  }
}
