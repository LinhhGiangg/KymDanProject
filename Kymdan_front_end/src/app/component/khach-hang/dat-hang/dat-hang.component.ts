import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {KhachHangService} from '../../../service/khach-hang.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {KhachHang} from '../../../model/KhachHang';
import {SanPhamService} from '../../../service/san-pham.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ChiTietGioHang} from '../../../model/ChiTietGioHang';

@Component({
  selector: 'app-dat-hang',
  templateUrl: './dat-hang.component.html',
  styleUrls: ['./dat-hang.component.css']
})
export class DatHangComponent implements OnInit {
  @ViewChild('paypalRef', {static: true}) private paypalRef: ElementRef;
  public formDatHang: FormGroup;
  public tenKhachHang;
  public khachHang = new KhachHang();
  public gioHang = [new ChiTietGioHang()];
  public chiTiet;
  public tienCanThanhToan = 0;
  public tongTienHienThi = '';
  public usd;
  public duLieuCanLay;
  public giaCanLay;
  public khuyenMaiCanLay;
  public hienThiPayPal = false;
  public thongTin;
  public thongBao;
  public kiemTra;
  public xacNhanThanhToan;
  public thongTinDonHang;
  public cachThanhToan = 'Tiền mặt';
  public ngayHienTai = new Date();

  constructor(
    public activatedRouter: ActivatedRoute,
    public formBuilder: FormBuilder,
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
    public sanPhamService: SanPhamService,
    public router: Router,
    public el: ElementRef,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.formDatHang = this.formBuilder.group({
      ten: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50),
        // tslint:disable-next-line:max-line-length
        Validators.pattern('^([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+(\\s[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+)*)$')]],
      soDienThoai: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      diaChi: ['', [Validators.required]],
      ngayNhan: ['', [Validators.required]],
    });

    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.kiemTra = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;

      this.gioHang = [new ChiTietGioHang()];
      this.xacNhanThanhToan = false;
      this.tienCanThanhToan = 0;
      this.tongTienHienThi = '';
      this.usd = 0;
      this.duLieuCanLay = 0;
      this.giaCanLay = 0;
      this.khuyenMaiCanLay = 0;

      this.tenKhachHang = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
      this.khachHangService.timBangTen(this.tenKhachHang)
        .subscribe(ketQua => {
            this.khachHang = ketQua;
            if (this.khachHang != null) {
              this.formDatHang.patchValue(ketQua);
            }
          },
          () => {
          },
          () => {
          });

      this.activatedRouter.params.subscribe(duLieu => {
        this.thongTin = duLieu.thongTin;
        for (let i = 0; i < this.thongTin.split(',').length; i++) {
          this.duLieuCanLay = 0;
          this.khachHangService.timChiTietGioHang(this.thongTin.split(',')[i], this.tenKhachHang).subscribe(
            (ketQua) => {
              this.duLieuCanLay = ketQua;
            },
            () => {
            },
            () => {
              this.layDuLieu(i);
            });
        }
      });
      if (this.hienThiPayPal === false) {
        this.payPal();
      }
    }
  }

  private layDuLieu(i: number) {
    if (this.duLieuCanLay != null) {
      this.chiTiet = new ChiTietGioHang();
      this.chiTiet.ma = this.duLieuCanLay.ma;
      this.chiTiet.sanPham = this.duLieuCanLay.sanPham;
      this.chiTiet.maLoai = this.duLieuCanLay.sanPham.loaiSanPham.ma;
      this.chiTiet.hinh = this.duLieuCanLay.sanPham.loaiSanPham.hinh1;
      this.chiTiet.ten = this.duLieuCanLay.sanPham.loaiSanPham.ten;
      this.chiTiet.kichThuoc = this.duLieuCanLay.sanPham.rong + ' x ' + this.duLieuCanLay.sanPham.dai
        + ' x ' + this.duLieuCanLay.sanPham.cao;
      this.chiTiet.gia = 0;
      this.chiTiet.khuyenMai = 0;
      this.chiTiet.soLuong = this.duLieuCanLay.soLuong;
      this.chiTiet.tongTien = 0;
      if (i === 0) {
        this.gioHang.pop()
      }
      this.gioHang.push(this.chiTiet);
      this.thongTinKhuyenMai(i);
    } else {
      this.hienThongBao('Sản phẩm hiện đang hết hàng hoặc ai đó đã mua trước bạn !')
    }
  }

  private thongTinKhuyenMai(i: number) {
    this.sanPhamService.timKhuyenMaiBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        this.khuyenMaiCanLay = duLieu;
      },
      () => {
      },
      () => {
        if (this.khuyenMaiCanLay != null) {
          this.gioHang[i].khuyenMai = this.khuyenMaiCanLay.giamGia;
        } else this.gioHang[i].khuyenMai = 0;
        this.thongTinGia(i);
      });
  }

  private thongTinGia(i: number) {
    this.sanPhamService.timGiaBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        this.giaCanLay = duLieu;
      },
      () => {
      },
      () => {
        this.gioHang[i].gia = this.giaCanLay.gia;
        if (this.gioHang[i].khuyenMai !== 0) {
          this.gioHang[i].gia = (this.gioHang[i].gia - this.gioHang[i].gia * this.gioHang[i].khuyenMai / 100);
        }
        this.gioHang[i].tongTien = this.gioHang[i].gia * this.gioHang[i].soLuong;
        this.tienCanThanhToan += this.gioHang[i].gia * this.gioHang[i].soLuong;
        this.usd = (this.tienCanThanhToan / 23500).toFixed(2);
        this.tongTienHienThi = this.sanPhamService.tienHienThi(this.tienCanThanhToan);
        this.gioHang[i].giaHienThi = this.sanPhamService.tienHienThi(this.gioHang[i].gia);
        this.gioHang[i].tongTienHienThi = this.sanPhamService.tienHienThi(this.gioHang[i].tongTien);
      });
  }

  chonSoLuong(thayDoi, viTri) {
    if (thayDoi === 1) {
      if (this.gioHang[viTri].soLuong >= 2) {
        this.gioHang[viTri].soLuong -= 1;
      }
    } else {
      if (this.gioHang[viTri].soLuong < this.gioHang[viTri].sanPham.soLuong) {
        this.gioHang[viTri].soLuong = this.gioHang[viTri].soLuong + 1;
      } else {
        this.gioHang[viTri].soLuong = this.gioHang[viTri].sanPham.soLuong;
        this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + this.gioHang[viTri].sanPham.soLuong + ' sản phẩm !')
      }
    }
    this.tienCanThanhToan = 0;
    for (let i = 0; i < this.gioHang.length; i++) {
      this.thongTinGia(i);
    }
  }

  xacNhanThongTin() {
    if (this.formDatHang.valid) {
      let kiemTra = '';
      let ketQua = '';
      let mangTam = [];
      for (let i = 0; i < this.gioHang.length; i++) {
        if (i === 0) {
          kiemTra += this.gioHang[i].ma;
        } else {
          kiemTra = kiemTra + ',' + this.gioHang[i].ma;
        }
      }

      this.khachHangService.kiemTraGioHang(kiemTra).subscribe(
        (duLieu) => {
          ketQua = duLieu.thongBao;
        },
        () => {
        },
        () => {
          if (ketQua === 'OK') {
            this.khachHangService.kiemTraSoLuongMua(kiemTra).subscribe(
              (duLieu) => {
                mangTam = duLieu;
              },
              () => {
              },
              () => {
                for (let i = 0; i < mangTam.length; i++) {
                  if (this.gioHang[i].soLuong > mangTam[i].soLuong) {
                    this.hienThongBao('Sản phẩm không đủ số lượng !')
                  }
                }
              });
            this.xacNhanThanhToan = true;
          } else this.hienThongBao('Sản phẩm hiện đang hết hàng hoặc ai đó đã mua trước bạn !')
        });
    } else {
      for (const thuocTinh of Object.keys(this.formDatHang.controls)) {
        if (this.formDatHang.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }

  payPal() {
    this.hienThiPayPal = true;
    paypal.Buttons(
      {
        style: {
          shape: 'rect',
          color: 'gold',
          layout: 'horizontal',
          label: 'paypal',
          height: 35,
        },

        createOrder: (data, actions) => {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: this.usd,
                  currency_code: 'USD'
                }
              }
            ]
          });
        },

        onCancel(data) {
          alert('Yêu cầu hủy thanh toán thành công !');
        },

        onApprove: (data, actions) => {
          return actions.order.capture().then(() => {
            this.cachThanhToan = 'PayPal';
            this.hienThongBao('Thanh toán thành công !');
          });
        },

        onError: (data, actions) => {
          alert('Lỗi hệ thống !');
        }
      }
    ).render(this.paypalRef.nativeElement);
  }

  thayDoiThongTin() {
    this.xacNhanThanhToan = false;
  }

  thanhToan() {
    this.thongTinDonHang = {
      khachHang: this.tenKhachHang,
      nguoiNhan: this.formDatHang.value.ten,
      diaChi: this.formDatHang.value.diaChi,
      soDienThoai: this.formDatHang.value.soDienThoai,
      ngayNhan: this.formDatHang.value.ngayNhan,
      cachThanhToan: this.cachThanhToan,
      sanPham: '',
      soLuong: '',
      gia: '',
    };

    for (let i = 0; i < this.gioHang.length; i++) {
      if (i === 0) {
        this.thongTinDonHang.sanPham += this.gioHang[i].sanPham.ma;
        this.thongTinDonHang.soLuong += this.gioHang[i].soLuong;
        this.thongTinDonHang.gia += this.gioHang[i].gia;
      } else {
        this.thongTinDonHang.sanPham = this.thongTinDonHang.sanPham + ',' + this.gioHang[i].sanPham.ma;
        this.thongTinDonHang.soLuong = this.thongTinDonHang.soLuong + ',' + this.gioHang[i].soLuong;
        this.thongTinDonHang.gia = this.thongTinDonHang.gia + ',' + this.gioHang[i].gia;
      }
    }

    this.khachHangService.luuDonHang(this.thongTinDonHang).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.hienThongBao('Đơn hàng đã được xác nhận ! Cảm ơn quý khách đã mua hàng tại hệ thống của chúng tôi !');
        this.router.navigate(['/lich-su-mua-hang']).then(() => {
        });
      });
  }

  hienThongBao(thongTin) {
    if (thongTin === 'Sản phẩm không đủ số lượng !') {
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '555px',
        height: '187px',
        data: {thongBao: thongTin},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        location.reload()
      })
    } else if (this.duLieuCanLay == null || thongTin === 'Sản phẩm hiện đang hết hàng hoặc ai đó đã mua trước bạn !') {
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '595px',
        height: '210px',
        data: {thongBao: thongTin},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        location.replace('http://localhost:4200/gio-hang')
      })
    } else {
      if (thongTin.length > 80) {
        const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
          width: '575px',
          height: '209px',
          data: {thongBao: thongTin},
          disableClose: true
        });

        dialogRefNotice.afterClosed().subscribe(() => {
        })
      } else {
        const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
          width: '555px',
          height: '187px',
          data: {thongBao: thongTin},
          disableClose: true
        });

        dialogRefNotice.afterClosed().subscribe(() => {
          if (this.cachThanhToan === 'PayPal') {
            this.thanhToan()
          }
        })
      }
    }
  }

  luuThongTin() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.gioHang.length; i++) {
      this.khachHangService.thayDoiSanPham(this.gioHang[i].ma, this.gioHang[i].soLuong).subscribe(
        () => {
        },
        () => {
        },
        () => {
        });
    }
    this.router.navigate(['/danh-sach-loai', {thongTin: ''}]).then(() => {
    });
  }
}
