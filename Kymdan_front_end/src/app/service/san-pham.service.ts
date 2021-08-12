import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SanPhamService {
  public readonly API: string = 'http://localhost:8080/sanPham';

  constructor(
    public http: HttpClient
  ) {
  }

  timBangMaLoai(maLoai): Observable<any> {
    return this.http.get(this.API + '/timBangMaLoai/' + maLoai);
  }

  saveCart(userName, productID, productInformation): Observable<any> {
    return this.http.get(this.API + '/save-cart/' + userName + '/' + productID + '/' + productInformation);
  }
}
