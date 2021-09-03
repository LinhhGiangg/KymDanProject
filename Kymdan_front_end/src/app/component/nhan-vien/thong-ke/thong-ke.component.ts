import {Component, OnInit} from '@angular/core';
import {NhanVienService} from '../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';

@Component({
  selector: 'app-thong-ke',
  templateUrl: './thong-ke.component.html',
  styleUrls: ['./thong-ke.component.css']
})
export class ThongKeComponent implements OnInit {
  public doanhThu = [];
  public nhanVien;
  public duLieu: number[] = [];

  public thang: string[] = [];

  constructor(
    public nhanVienService: NhanVienService,
    public taiKhoanService: TaiKhoanService,
  ) {
  }

  ngOnInit(): void {
    this.nhanVien = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.nhanVienService.thongKe(this.nhanVien).subscribe(
      (duLieu) => {
        this.doanhThu = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.doanhThu.length; i++) {
          this.duLieu.push(this.doanhThu[i][0] / 1000000);
          this.thang.push('Tháng ' + this.doanhThu[i][1]);
        }
      });
  }

}
