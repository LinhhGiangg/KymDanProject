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
}
