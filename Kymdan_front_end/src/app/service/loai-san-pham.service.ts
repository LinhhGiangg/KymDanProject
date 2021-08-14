import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoaiSanPhamService {
  public readonly API: string = 'http://localhost:8080/loaiSanPham';

  constructor(
    public http: HttpClient
  ) {
  }

  xemTatCa(): Observable<any> {
    return this.http.get(this.API + '/xemTatCa');
  }

  locTheoGia(gia): Observable<any> {
    return this.http.get(this.API + '/locTheoGia/' + gia);
  }

  timBangMaLoai(maLoai): Observable<any> {
    return this.http.get(this.API + '/timBangMaLoai/' + maLoai);
  }

  taoMoi(loaiSanPham): Observable<any> {
    return this.http.post(this.API + '/taoMoi', loaiSanPham, {headers: {skip: 'true'}});
  }

  sua(loaiSanPham): Observable<any> {
    return this.http.post(this.API + '/sua', loaiSanPham, {headers: {skip: 'true'}});
  }

  xoa(ten): Observable<any> {
    return this.http.get(this.API + '/xoa/' + ten);
  }

  xemLoaiMoi(): Observable<any> {
    return this.http.get(this.API + '/xemLoaiMoi');
  }

  xemLoaiBanChay(): Observable<any> {
    return this.http.get(this.API + '/xemLoaiBanChay');
  }

  timTheoTen(ten): Observable<any> {
    return this.http.get(this.API + '/timTheoTen/' + ten);
  }
}
