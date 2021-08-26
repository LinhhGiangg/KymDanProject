import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {KhachHangService} from '../../../service/khach-hang.service';

@Component({
  selector: 'app-chi-tiet-don-hang',
  templateUrl: './chi-tiet-don-hang.component.html',
  styleUrls: ['./chi-tiet-don-hang.component.css']
})
export class ChiTietDonHangComponent implements OnInit {
  public maDonHang;
  public danhSachChiTiet = [];
  public khachHang;
  public quyen;

  constructor(
    public activatedRouter: ActivatedRoute,
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(duLieu => {
      this.maDonHang = duLieu.thongTin;
    });

    this.khachHang = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
    if (this.quyen === 'Khách Hàng') {
      this.khachHangService.xemChiTietDonHang(this.maDonHang).subscribe(
        (duLieu) => {
          this.danhSachChiTiet = duLieu;
        },
        () => {
        },
        () => {
        });
    }
  }

}
