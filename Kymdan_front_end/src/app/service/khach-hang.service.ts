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

  timBangTen(ten): Observable<any> {
    return this.http.get(this.API + '/timBangTen/' + ten);
  }

  chiTietGioHang(khachHang): Observable<any> {
    return this.http.get(this.API + '/chiTietGioHang/' + khachHang);
  }

  thayDoiSanPham(maChiTiet, soLuong): Observable<any> {
    return this.http.get(this.API + '/thayDoiSanPham/' + maChiTiet + '/' + soLuong);
  }

  xoaSanPham(maChiTiet): Observable<any> {
    return this.http.get(this.API + '/xoaSanPham/' + maChiTiet);
  }

  luuGioHang(tenKhachHang, maSanPham, soLuong): Observable<any> {
    return this.http.get(this.API + '/luuGioHang/' + tenKhachHang + '/' + maSanPham + '/' + soLuong);
  }
}
