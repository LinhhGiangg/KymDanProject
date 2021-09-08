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

  tienHienThi(thongTin) {
    thongTin = thongTin + '';
    if (thongTin.length >= 7 && thongTin.length <= 9) {
      return thongTin.slice(-(thongTin.length), -6) + '.' + thongTin.slice(-6, -3) + '.000';
    } else if (thongTin.length >= 10 && thongTin.length <= 12) {
      return thongTin.slice(-(thongTin.length), -9) + '.' + thongTin.slice(-9, -6) + '.' + thongTin.slice(-6, -3) + '.000';
    }
  }

  locTheoMaLoai(maLoai): Observable<any> {
    return this.http.get(this.API + '/locTheoMaLoai/' + maLoai);
  }

  sanPhamDauTien(thongTin): Observable<any> {
    return this.http.get(this.API + '/sanPhamDauTien/' + thongTin);
  }

  chonSanPham(thongTin): Observable<any> {
    return this.http.get(this.API + '/chonSanPham/' + thongTin);
  }

  xoa(ma): Observable<any> {
    return this.http.get(this.API + '/xoa/' + ma);
  }

  timBangMa(ma): Observable<any> {
    return this.http.get(this.API + '/timBangMa/' + ma);
  }

  sua(sanPham): Observable<any> {
    return this.http.post(this.API + '/sua', sanPham, {headers: {skip: 'true'}});
  }

  taoMoi(sanPham): Observable<any> {
    return this.http.post(this.API + '/taoMoi', sanPham, {headers: {skip: 'true'}});
  }

  timGiaBangMaSanPham(ma): Observable<any> {
    return this.http.get(this.API + '/timGiaBangMaSanPham/' + ma);
  }

  timKhuyenMaiBangMaSanPham(ma): Observable<any> {
    return this.http.get(this.API + '/timKhuyenMaiBangMaSanPham/' + ma);
  }
}
