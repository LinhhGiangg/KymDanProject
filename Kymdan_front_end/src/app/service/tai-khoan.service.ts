import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {map} from 'rxjs/operators';
import {TaiKhoan} from '../model/TaiKhoan';

@Injectable({
  providedIn: 'root'
})
export class TaiKhoanService {
  readonly API = 'http://localhost:8080/taiKhoan';

  hoTen: Subject<string> = new Subject();
  public nguoiDungHienTai: BehaviorSubject<TaiKhoan>;
  public taiKhoanHienTai: Observable<TaiKhoan>;
  luuThongTin;

  broadcastLoginChange(text: string) {
    this.hoTen.next(text);
  }

  constructor(public http: HttpClient) {
    this.luuThongTin = JSON.parse(localStorage.getItem('taiKhoanHienTai'));
    this.nguoiDungHienTai = new BehaviorSubject<TaiKhoan>(this.luuThongTin);
    this.taiKhoanHienTai = this.nguoiDungHienTai.asObservable();
  }

  public get thongTinNguoiDungHienTai(): TaiKhoan {
    return this.nguoiDungHienTai.value;
  }

  xacThuc(taiKhoan): Observable<any> {
    return this.http.post<any>(this.API + '/xacThuc', taiKhoan)
      .pipe(map(nguoiDung => {
        localStorage.setItem('taiKhoanHienTai', JSON.stringify(nguoiDung));
        localStorage.setItem('token', nguoiDung.token);
        this.nguoiDungHienTai.next(nguoiDung);
        return nguoiDung;
      }));
  }

  dangXuat() {
    localStorage.removeItem('taiKhoanHienTai');
    localStorage.removeItem('token');
    this.nguoiDungHienTai.next(null);
  }

  xemThongTin(ten, quyen): Observable<any> {
    return this.http.get(this.API + '/xemThongTin/' + ten + '/' + quyen);
  }

  suaThongTin(thongTinMoi): Observable<any> {
    return this.http.post(this.API + '/suaThongTin', thongTinMoi, {headers: {skip: 'true'}});
  }

  suaMatKhau(tenDangNhap, matKhauCu, matKhauMoi): Observable<any> {
    return this.http.get(this.API + '/suaMatKhau/' + tenDangNhap + '/' + matKhauCu + '/' + matKhauMoi);
  }

  layMatKhau(mail): Observable<any> {
    return this.http.get(this.API + '/layMatKhau/' + mail);
  }
}
