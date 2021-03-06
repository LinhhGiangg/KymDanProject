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

  danhSachChiTietGioHang(khachHang): Observable<any> {
    return this.http.get(this.API + '/danhSachChiTietGioHang/' + khachHang);
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

  timChiTietGioHang(maSanPham, khachHang): Observable<any> {
    return this.http.get(this.API + '/timChiTietGioHang/' + maSanPham + '/' + khachHang);
  }

  luuDonHang(thongTinDonHang): Observable<any> {
    return this.http.post(this.API + '/luuDonHang', thongTinDonHang, {headers: {skip: 'true'}});
  }

  xemDonHang(khachHang): Observable<any> {
    return this.http.get(this.API + '/xemDonHang/' + khachHang);
  }

  xemChiTietDonHang(maDonHang): Observable<any> {
    return this.http.get(this.API + '/xemChiTietDonHang/' + maDonHang);
  }

  huyDonHang(maDonHang): Observable<any> {
    return this.http.get(this.API + '/huyDonHang/' + maDonHang);
  }

  kiemTraGioHang(thongTin): Observable<any> {
    return this.http.get(this.API + '/kiemTraGioHang/' + thongTin);
  }

  kiemTraSoLuongMua(thongTin): Observable<any> {
    return this.http.get(this.API + '/kiemTraSoLuongMua/' + thongTin);
  }
}
