import {Component, OnInit} from '@angular/core';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {KhachHangService} from '../../../service/khach-hang.service';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {HuyDonHangComponent} from '../huy-don-hang/huy-don-hang.component';

@Component({
  selector: 'app-lich-su-mua-hang',
  templateUrl: './lich-su-mua-hang.component.html',
  styleUrls: ['./lich-su-mua-hang.component.css']
})
export class LichSuMuaHangComponent implements OnInit {
  public gioHang = [];
  public thongBao;
  public khachHang;
  public quyen;

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.khachHang = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      if (this.quyen === 'Khách Hàng') {
        this.khachHangService.xemDonHang(this.khachHang).subscribe(
          (duLieu) => {
            this.gioHang = duLieu;
          },
          () => {
          },
          () => {
          });
      }
    }
  }

  xemChiTietDonHang(ma) {
    this.router.navigate(['/chi-tiet-don-hang', {thongTin: ma}]).then(() => {
    });
  }

  huyDonHang(ma) {
    const dialogRefDelete = this.dialog.open(HuyDonHangComponent, {
      width: '715px',
      height: '175px',
      data: {thongTin: ma},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit()
    })
  }
}
