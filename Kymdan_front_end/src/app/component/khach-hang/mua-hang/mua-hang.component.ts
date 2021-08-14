import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DangNhapService} from '../../../service/dang-nhap.service';
import {MatDialog} from '@angular/material/dialog';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {SanPham} from '../../../model/SanPham';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {SanPhamService} from '../../../service/san-pham.service';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';

@Component({
  selector: 'app-mua-hang',
  templateUrl: './mua-hang.component.html',
  styleUrls: ['./mua-hang.component.css']
})
export class MuaHangComponent implements OnInit {

  constructor(
    public activatedRouter: ActivatedRoute,
    public sanPhamService: SanPhamService,
    public loaiSanPhamService: LoaiSanPhamService,
    public dangNhapService: DangNhapService,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }
  public thongBao;
  public quyen = 'Nothing';
  public tenDangNhap;
  public maLoai;
  public thongTinSanPham;
  public soLuong = 1;
  public gia: string;
  public giaBan: string;
  public kichThuoc = '120x200';
  public doDay = '5';
  public sanPham = new SanPham();
  public loaiSanPham = new LoaiSanPham();

  private static hienThiGia(thongTin) {
    let hangTrieu;
    let hangNgan;
    // tslint:disable-next-line:radix
    hangTrieu = (Number.parseInt(thongTin) / 1000000).toString().split('.')[0] + '';
    // tslint:disable-next-line:radix
    hangNgan = ((Number.parseInt(thongTin) - Number.parseInt(hangTrieu) * 1000000) / 1000).toString().split('.')[0] + '';
    if (hangNgan === '0') {
      return hangTrieu + ',000,000'
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 10) {
      return hangTrieu + ',00' + hangNgan + ',000';
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 100) {
      return hangTrieu + ',0' + hangNgan + ',000';
    } else {
      return hangTrieu + ',' + hangNgan + ',000';
    }
  }

  ngOnInit(): void {
    if (this.dangNhapService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.dangNhapService.thongTinNguoiDungHienTai.quyen;
      this.tenDangNhap = this.dangNhapService.thongTinNguoiDungHienTai.tenDangNhap;
    }

    this.activatedRouter.params.subscribe(duLieu => {
      this.maLoai = duLieu.maLoai;
    });

    this.thongTinSanPham = this.maLoai + ',120x200,5';

    this.loaiSanPhamService.timBangMaLoai(this.maLoai).subscribe(
      (duLieu) => {
        this.loaiSanPham = duLieu;
      },
      () => {
      },
      () => {
      });

    this.sanPhamDauTien(this.thongTinSanPham)
  }

  sanPhamDauTien(thongTinSanPham) {
    this.sanPhamService.sanPhamDauTien(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
      },
      () => {
      },
      () => {
        if (this.sanPham != null) {
          // @ts-ignore
          this.gia = MuaHangComponent.hienThiGia(this.sanPham.gia);
          // tslint:disable-next-line:radix
          this.giaBan =
            // tslint:disable-next-line:radix
            (Number.parseInt(this.sanPham.gia) - (Number.parseInt(this.sanPham.gia) * Number.parseInt(this.sanPham.giamGia) / 100)) + '';
          // @ts-ignore
          this.giaBan = MuaHangComponent.hienThiGia(this.giaBan);
          this.kichThuoc = this.sanPham.rong + 'x200';
          this.doDay = this.sanPham.cao;
        }
      });
  }

  chonSanPham(thongTinSanPham) {
    // xử lý lượt xem
    // xử lý mua khi chưa đăng nhập, login xong trả lại vị trí bđ
    this.sanPhamService.chonSanPham(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
        if (this.sanPham.gia) {
          // tslint:disable-next-line:radix
          // this.gia = Number.parseInt(this.sanPham.gia);
          // tslint:disable-next-line:radix
          // this.giaBan = this.gia - (this.gia * Number.parseInt(this.sanPham.giamGia) / 100);
        }
      },
      () => {
      },
      () => {
      });
  }

  chonKichThuoc(kichThuoc) {
    this.kichThuoc = kichThuoc;
  }

  chonDoDay(doDay) {
    this.doDay = doDay;
  }

  chonSoLuong(soLuong) {
    if (soLuong === 1) {
      if (this.soLuong >= 2) {
        this.soLuong = this.soLuong - 1;
      }
    } else {
      // tslint:disable-next-line:radix
      if (this.soLuong < Number.parseInt(this.sanPham.soLuong)) {
        this.soLuong = this.soLuong + 1;
      } else this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + this.sanPham.soLuong + ' sản phẩm !')
    }
  }

  luuGioHang() {
  }

  hienThongBao(thongBao) {
    this.thongBao = thongBao;
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '555px',
      height: '180px',
      data: {thongBao: this.thongBao},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(() => {
      if (this.thongBao === 'Cần đăng nhập trước khi mua sản phẩm !') {
        this.router.navigate(['/dang-nhap', {message: ''}]).then(() => {
        });
      }
    })
  }
}
