import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {KhachHangService} from '../../../service/khach-hang.service';
import {SanPhamService} from '../../../service/san-pham.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';

@Component({
  selector: 'app-chi-tiet-don-hang',
  templateUrl: './chi-tiet-don-hang.component.html',
  styleUrls: ['./chi-tiet-don-hang.component.css']
})
export class ChiTietDonHangComponent implements OnInit {
  public danhSachChiTiet = [];
  public maDonHang;
  public quyen;
  public gia;
  public kiemTra;
  public tienHienThi;
  public tongTien = 0;

  constructor(
    public taiKhoanService: TaiKhoanService,
    public activatedRouter: ActivatedRoute,
    public khachHangService: KhachHangService,
    public sanPhamService: SanPhamService,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.kiemTra = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      this.gia = 0;
      this.quyen = '';
      this.tongTien = 0;
      this.tienHienThi = '';
      this.danhSachChiTiet = [];
      this.activatedRouter.params.subscribe(duLieu => {
        this.maDonHang = duLieu.thongTin;
        if (this.maDonHang.split(',').length > 1) {
          this.maDonHang = duLieu.thongTin.split(',')[0];
          this.quyen = duLieu.thongTin.split(',')[1];
        } else this.maDonHang = duLieu.thongTin;
      });

      this.khachHangService.xemChiTietDonHang(this.maDonHang).subscribe(
        (duLieu) => {
          this.danhSachChiTiet = duLieu;
        },
        () => {
        },
        () => {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.danhSachChiTiet.length; i++) {
            this.gia = this.danhSachChiTiet[i].gia;
            this.danhSachChiTiet[i].giaHienThi = this.sanPhamService.tienHienThi(this.danhSachChiTiet[i].gia);
            // tslint:disable-next-line:radix
            this.tongTien += this.danhSachChiTiet[i].soLuong * this.gia;
          }
          this.tienHienThi = this.sanPhamService.tienHienThi(this.tongTien);
        });
    }
  }

  troVe() {
    if (this.quyen === '') {
      this.router.navigate(['/lich-su-mua-hang']).then(() => {
      });
    } else {
      this.router.navigate(['/danh-sach-don-hang']).then(() => {
      });
    }
  }
}
