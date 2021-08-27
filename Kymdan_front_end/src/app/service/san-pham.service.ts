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

  hienThiGia(thongTin) {
    let hangTrieu;
    let hangNgan;
    // tslint:disable-next-line:radix
    hangTrieu = (Number.parseInt(thongTin) / 1000000).toString().split('.')[0] + '';
    // tslint:disable-next-line:radix
    hangNgan = ((Number.parseInt(thongTin) - Number.parseInt(hangTrieu) * 1000000) / 1000).toString().split('.')[0] + '';
    if (hangNgan === '0') {
      return hangTrieu + '.000.000'
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 10) {
      return hangTrieu + '.00' + hangNgan + '.000';
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 100) {
      return hangTrieu + '.0' + hangNgan + '.000';
    } else {
      return hangTrieu + '.' + hangNgan + '.000';
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
