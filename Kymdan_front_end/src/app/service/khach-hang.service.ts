import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KhachHangService {
  readonly API = 'http://localhost:8080/khachHang';

  constructor(public http: HttpClient) {
  }

  dangKy(taiKhoan): Observable<any> {
    return this.http.post(this.API + '/dangKy', taiKhoan, {headers: {skip: 'true'}});
  }
}
