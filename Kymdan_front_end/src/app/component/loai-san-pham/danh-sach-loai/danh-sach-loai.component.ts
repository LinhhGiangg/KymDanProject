import {Component, OnInit} from '@angular/core';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {Router} from '@angular/router';
import {LoaiSanPham} from '../../../model/LoaiSanPham';

@Component({
  selector: 'app-danh-sach-loai',
  templateUrl: './danh-sach-loai.component.html',
  styleUrls: ['./danh-sach-loai.component.css']
})
export class DanhSachLoaiComponent implements OnInit {
  public danhSachLoai = [new LoaiSanPham()];
  public viTri;
  public danhSachLoc = false;
  public kiemTraBanChay = false;

  constructor(
    public loaiSanPhamService: LoaiSanPhamService,
    public router: Router,
  ) {
  }

  ngOnInit() {
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
      });
  }

  locTheoGia(khoangGia) {
    this.viTri = khoangGia;
    this.danhSachLoc = true;
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

  xemSanPham(ma) {
    this.router.navigate(['mua-hang', {maLoai: ma}]).then(() => {
    });
  }

  xemLoaiMoi() {
    this.kiemTraBanChay = true;
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
      });
  }

  xemLoaiBanChay() {
    this.kiemTraBanChay = false;
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
      });
  }

  lamMoi() {
    this.danhSachLoc = false;
    this.kiemTraBanChay = false;
    this.ngOnInit();
  }
}
