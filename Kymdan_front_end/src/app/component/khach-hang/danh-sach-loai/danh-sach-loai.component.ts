import {Component, OnInit} from '@angular/core';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {Router} from '@angular/router';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {SanPhamService} from '../../../service/san-pham.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-danh-sach-loai',
  templateUrl: './danh-sach-loai.component.html',
  styleUrls: ['./danh-sach-loai.component.css']
})
export class DanhSachLoaiComponent implements OnInit {
  public danhSachLoai = [new LoaiSanPham()];
  public danhSachLoc = [];
  public viTri;
  public thongBao;
  public tenCanTim = '';
  public kiemTraLoc = false;
  public kiemTraBanChay = false;

  constructor(
    public loaiSanPhamService: LoaiSanPhamService,
    public sanPhamService: SanPhamService,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.tenCanTim = '';
    this.kiemTraLoc = false;
    this.kiemTraBanChay = false;
    this.loaiSanPhamService.xemTatCa().subscribe(
      (duLieu) => {
        this.danhSachLoai = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSachLoai.length; i++) {
          this.danhSachLoai[i].moTa1 = this.danhSachLoai[i].moTa.split(',')[0];
          this.danhSachLoai[i].moTa2 = this.danhSachLoai[i].moTa.split(',')[1];
          this.danhSachLoai[i].moTa3 = this.danhSachLoai[i].moTa.split(',')[2];
        }
        this.danhSachLoc = this.danhSachLoai.reverse();
      });
  }

  locTheoGia(khoangGia) {
    this.viTri = khoangGia;
    this.kiemTraLoc = true;
    // this.loaiSanPhamService.locTheoGia(khoangGia).subscribe(
    //   (duLieu) => {
    //     this.danhSachLoai = duLieu;
    //   },
    //   () => {
    //   },
    //   () => {
    //     // tslint:disable-next-line:prefer-for-of
    //     for (let i = 0; i < this.danhSachLoai.length; i++) {
    //       this.danhSachLoai[i].moTa1 = this.danhSachLoai[i].moTa.split(',')[0];
    //       this.danhSachLoai[i].moTa2 = this.danhSachLoai[i].moTa.split(',')[1];
    //       this.danhSachLoai[i].moTa3 = this.danhSachLoai[i].moTa.split(',')[2];
    //     }
    //   });
  }

  xemLoaiMoi() {
    this.kiemTraBanChay = false;
    this.loaiSanPhamService.xemLoaiMoi().subscribe(
      (duLieu) => {
        this.danhSachLoai = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSachLoai.length; i++) {
          this.danhSachLoai[i].moTa1 = this.danhSachLoai[i].moTa.split(',')[0];
          this.danhSachLoai[i].moTa2 = this.danhSachLoai[i].moTa.split(',')[1];
          this.danhSachLoai[i].moTa3 = this.danhSachLoai[i].moTa.split(',')[2];
        }
        this.danhSachLoc = this.danhSachLoai;
      });
  }

  xemLoaiBanChay() {
    this.kiemTraBanChay = true;
    this.loaiSanPhamService.xemLoaiBanChay().subscribe(
      (duLieu) => {
        this.danhSachLoai = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSachLoai.length; i++) {
          this.danhSachLoai[i].moTa1 = this.danhSachLoai[i].moTa.split(',')[0];
          this.danhSachLoai[i].moTa2 = this.danhSachLoai[i].moTa.split(',')[1];
          this.danhSachLoai[i].moTa3 = this.danhSachLoai[i].moTa.split(',')[2];
        }
        this.danhSachLoc = this.danhSachLoai;
      });
  }

  locTheoTen() {
    this.danhSachLoc = [];
    if (this.tenCanTim !== '') {
      let kiTu;
      let mangTam;
      kiTu = this.tenCanTim.trim().toLowerCase();
      mangTam = kiTu.split(' ');
      kiTu = '';
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < mangTam.length; i++) {
        if (mangTam[i] !== '') {
          if (i === mangTam.length - 1) {
            kiTu += mangTam[i].trim();
          } else kiTu += mangTam[i].trim() + ' ';
        }
      }

      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.danhSachLoai.length; i++) {
        if ((this.danhSachLoai[i].ten + '').toLowerCase().indexOf(kiTu) > -1) {
          this.danhSachLoc.push(this.danhSachLoai[i]);
        }
      }
    } else this.danhSachLoc = this.danhSachLoai;
  }

  xemSanPham(ma) {
    this.sanPhamService.locTheoMaLoai(ma).subscribe(
      (duLieu) => {
        if (duLieu.length !== 0) {
          this.router.navigate(['mua-hang', {thongTin: ma}]).then(() => {
          });
        } else {
          this.thongBao = 'Hiện tại loại này chưa có sản phẩm !';
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '555px',
            height: '180px',
            data: {thongBao: this.thongBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/danh-sach-loai']).then(() => {
            });
          })
        }
      },
      () => {
      },
      () => {
      });
  }

  lamMoi() {
    this.ngOnInit()
  }
}
