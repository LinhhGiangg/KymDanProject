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

  danhSachDonHang(thongTin): Observable<any> {
    return this.http.get(this.API + '/danhSachDonHang/' + thongTin);
  }

  danhSachNhanVienGiaoHang(thongTin): Observable<any> {
    return this.http.get(this.API + '/danhSachNhanVienGiaoHang/' + thongTin);
  }

  giaoHangHoanTat(thongTin): Observable<any> {
    return this.http.get(this.API + '/giaoHangHoanTat/' + thongTin);
  }

  thongKe(thongTin): Observable<any> {
    return this.http.post(this.API + '/thongKe', thongTin, {headers: {skip: 'true'}});
  }

  phanCongGiaoHang(thongTin): Observable<any> {
    return this.http.post(this.API + '/phanCongGiaoHang', thongTin, {headers: {skip: 'true'}});
  }

  danhSachHoaDon(thongTin): Observable<any> {
    return this.http.get(this.API + '/danhSachHoaDon/' + thongTin);
  }
}
