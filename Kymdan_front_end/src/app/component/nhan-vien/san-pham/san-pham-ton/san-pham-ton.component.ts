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
        });
    }
  }
}
