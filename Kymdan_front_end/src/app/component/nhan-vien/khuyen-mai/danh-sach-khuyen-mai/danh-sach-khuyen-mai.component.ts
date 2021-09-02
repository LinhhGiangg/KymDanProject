import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {ThemKhuyenMaiComponent} from '../them-khuyen-mai/them-khuyen-mai.component';
import {SuaKhuyenMaiComponent} from '../sua-khuyen-mai/sua-khuyen-mai.component';
import {XoaKhuyenMaiComponent} from '../xoa-khuyen-mai/xoa-khuyen-mai.component';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-danh-sach-khuyen-mai',
  templateUrl: './danh-sach-khuyen-mai.component.html',
  styleUrls: ['./danh-sach-khuyen-mai.component.css']
})
export class DanhSachKhuyenMaiComponent implements OnInit {
  public danhSach = [];
  public thongBao;
  public ngayHienTai = new Date();

  constructor(
    public khuyenMaiService: KhuyenMaiService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.khuyenMaiService.xemTatCa().subscribe(
      (duLieu) => {
        this.danhSach = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSach.length; i++) {
          if (Date.parse(this.danhSach[i].ngayBatDau) > Date.parse(this.ngayHienTai.toDateString())) {
            this.danhSach[i].trangThai = 'Chưa khuyến mãi';
          } else {
            this.danhSach[i].trangThai = 'Đã khuyến mãi';
          }
        }
      });
  }

  taoMoi() {
    this.thongBao = '';
    const dialogRefAdd = this.dialog.open(ThemKhuyenMaiComponent, {
      width: '750px',
      height: '445px',
      data: {thongTin: this.danhSach[0].ngayKetThuc},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  sua(ma) {
    this.khuyenMaiService.timBangMa(ma).subscribe(
      (duLieu) => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSach.length; i++) {
          if (this.danhSach[i].ma === ma) {
            if (i > 0) {
              duLieu.gioiHanTruoc = this.danhSach[i + 1].ngayKetThuc;
              duLieu.gioiHanSau = this.danhSach[i - 1].ngayBatDau;
            } else {
              duLieu.gioiHanTruoc = this.danhSach[i + 1].ngayKetThuc;
            }
          }
        }
        this.taoFormSua(duLieu)
      },
      () => {
      },
      () => {
      });
  }

  taoFormSua(duLieu) {
    this.thongBao = '';
    const dialogRefEdit = this.dialog.open(SuaKhuyenMaiComponent, {
      width: '750px',
      height: '435px',
      data: {thongTin: duLieu},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xoa(ma) {
    this.thongBao = '';
    const dialogRefDelete = this.dialog.open(XoaKhuyenMaiComponent, {
      width: '715px',
      height: '175px',
      data: {thongTin: ma},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xemChiTiet(ma) {
    this.router.navigate(['/chi-tiet-khuyen-mai', {thongTin: ma}]).then(() => {
    });
  }

  khongTheSuaXoa() {
    this.thongBao = 'Khuyến mãi này đang được áp dụng hoặc đã quá hạn !';
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '655px',
      height: '180px',
      data: {thongBao: this.thongBao},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(() => {
    })
  }
}
