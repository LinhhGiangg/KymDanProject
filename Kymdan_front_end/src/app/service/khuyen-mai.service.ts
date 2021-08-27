import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KhuyenMaiService {
  public readonly API: string = 'http://localhost:8080/khuyenMai';

  constructor(
    public http: HttpClient
  ) {
  }

  xemTatCa(): Observable<any> {
    return this.http.get(this.API + '/xemTatCa');
  }

  timBangMa(ma): Observable<any> {
    return this.http.get(this.API + '/timBangMa/' + ma);
  }

  timChiTietBangMaKhuyenMai(maKhuyenMai): Observable<any> {
    return this.http.get(this.API + '/timChiTietBangMaKhuyenMai/' + maKhuyenMai);
  }

  taoMoi(thongTin): Observable<any> {
    return this.http.post(this.API + '/taoMoi', thongTin, {headers: {skip: 'true'}});
  }

  sua(thongTin): Observable<any> {
    return this.http.post(this.API + '/sua', thongTin, {headers: {skip: 'true'}});
  }

  xoa(ma): Observable<any> {
    return this.http.get(this.API + '/xoa/' + ma);
  }

  themSanPhamKhuyenMai(maKhuyenMai, maSanPham, giamGia): Observable<any> {
    return this.http.get(this.API + '/themSanPhamKhuyenMai/' + maKhuyenMai + '/' + maSanPham + '/' + giamGia);
  }
}
