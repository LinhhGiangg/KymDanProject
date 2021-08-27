import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NhanVienService {
  public readonly API: string = 'http://localhost:8080/nhanVien';

  constructor(
    public http: HttpClient
  ) { }

  danhSachDonHang(nhanVien): Observable<any> {
    return this.http.get(this.API + '/danhSachDonHang/' + nhanVien);
  }
}
