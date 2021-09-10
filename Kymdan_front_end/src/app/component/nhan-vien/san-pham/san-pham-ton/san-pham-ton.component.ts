import {Component, OnInit} from '@angular/core';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';
import {SanPhamService} from '../../../../service/san-pham.service';

@Component({
  selector: 'app-san-pham-ton',
  templateUrl: './san-pham-ton.component.html',
  styleUrls: ['./san-pham-ton.component.css']
})
export class SanPhamTonComponent implements OnInit {
  public danhSach = [];
  public danhSachLoai = [];
  public danhSachHienThi = [];
  public thongBao;
  public quyen = '';

  constructor(
    public taiKhoanService: TaiKhoanService,
    public sanPhamService: SanPhamService,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;

      this.sanPhamService.sanPhamTon(this.quyen).subscribe(
        (duLieu) => {
          this.danhSach = duLieu;
        },
        () => {
        },
        () => {
          let phanTu;
          let mangViTri = [];
          let mangDoiTuong = [];

          for (; this.danhSach.length > 0;) {
            phanTu = this.danhSach[0];
            mangViTri.push(0);
            this.danhSachLoai.push(phanTu.loaiSanPham.ten);
            mangDoiTuong.push(phanTu);

            for (let i = 1; i < this.danhSach.length; i++) {
              if (this.danhSach[i].loaiSanPham.ten === phanTu.loaiSanPham.ten) {
                mangDoiTuong.push(this.danhSach[i]);
                mangViTri.push(i);
              }
            }

            this.danhSachHienThi.push(mangDoiTuong);

            // tslint:disable-next-line:prefer-for-of
            for (let i = 0; i < mangViTri.length; i++) {
              this.danhSach.splice(mangViTri[i] - i, 1);
            }

            mangDoiTuong = [];
            mangViTri = [];
          }
        });
    }
  }
}
