import {Component, OnInit} from '@angular/core';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {SanPhamService} from '../../../service/san-pham.service';
import {NhanVienService} from '../../../service/nhan-vien.service';

@Component({
  selector: 'app-hoa-don',
  templateUrl: './hoa-don.component.html',
  styleUrls: ['./hoa-don.component.css']
})
export class HoaDonComponent implements OnInit {
  public danhSachHoaDon = [];
  public quyen = '';

  constructor(
    public taiKhoanService: TaiKhoanService,
    public nhanVienService: NhanVienService,
    public sanPhamService: SanPhamService,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;

      this.nhanVienService.danhSachHoaDon(this.quyen).subscribe(
        (duLieu) => {
          this.danhSachHoaDon = duLieu;
        },
        () => {
        },
        () => {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.danhSachHoaDon.length; i++) {
            this.danhSachHoaDon[i].tienHienThi = this.sanPhamService.tienHienThi(this.danhSachHoaDon[i].tongTien);
          }
        });
    }
  }
}
