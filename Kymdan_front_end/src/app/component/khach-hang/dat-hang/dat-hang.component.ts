import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {KhachHangService} from '../../../service/khach-hang.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {KhachHang} from '../../../model/KhachHang';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {SanPhamService} from '../../../service/san-pham.service';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {SanPham} from '../../../model/SanPham';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-dat-hang',
  templateUrl: './dat-hang.component.html',
  styleUrls: ['./dat-hang.component.css']
})
export class DatHangComponent implements OnInit {
  @ViewChild('paypalRef', {static: true}) private paypalRef: ElementRef;
  public formDatHang: FormGroup;
  public loaiSanPham = new LoaiSanPham();
  public khachHang = new KhachHang();
  public sanPham = new SanPham();
  public soLuong;
  public gia: string;
  public usd;
  public thongTin;
  public thongBao;

  constructor(
    public activatedRouter: ActivatedRoute,
    public formBuilder: FormBuilder,
    public khachHangService: KhachHangService,
    public loaiSanPhamService: LoaiSanPhamService,
    public sanPhamService: SanPhamService,
    public router: Router,
    public el: ElementRef,
    public dialog: MatDialog,
  ) {
  }

  private static hienThiGia(thongTin) {
    let hangTrieu;
    let hangNgan;
    // tslint:disable-next-line:radix
    hangTrieu = (Number.parseInt(thongTin) / 1000000).toString().split('.')[0] + '';
    // tslint:disable-next-line:radix
    hangNgan = ((Number.parseInt(thongTin) - Number.parseInt(hangTrieu) * 1000000) / 1000).toString().split('.')[0] + '';
    if (hangNgan === '0') {
      return hangTrieu + '.000.000'
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 10) {
      return hangTrieu + '.00' + hangNgan + '.000';
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 100) {
      return hangTrieu + '.0' + hangNgan + '.000';
    } else {
      return hangTrieu + '.' + hangNgan + '.000';
    }
  }

  ngOnInit() {
    this.payPal();
    this.formDatHang = this.formBuilder.group({
      ten: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50),
        // tslint:disable-next-line:max-line-length
        Validators.pattern('^([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+(\\s[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+)*)$')]],
      soDienThoai: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      diaChi: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{0,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]],
    });

    this.activatedRouter.params.subscribe(duLieu => {
      this.thongTin = duLieu.thongTin;
      this.khachHangService.timBangTen(this.thongTin.split(',')[0])
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

      this.loaiSanPhamService.timBangMaLoai(this.thongTin.split(',')[1])
        .subscribe(ketQua => {
            this.loaiSanPham = ketQua;
          },
          () => {
          },
          () => {
          });

      this.sanPhamService.timBangMa(this.thongTin.split(',')[2])
        .subscribe(ketQua => {
            this.sanPham = ketQua;
          },
          () => {
          },
          () => {
            this.gia =
              // tslint:disable-next-line:radix
              (Number.parseInt(this.sanPham.gia) - (Number.parseInt(this.sanPham.gia) * Number.parseInt(this.sanPham.giamGia) / 100)) + '';
            // @ts-ignore
            this.gia = DatHangComponent.hienThiGia(this.gia);

            // tslint:disable-next-line:radix
            this.usd = ((Number.parseInt(this.sanPham.gia)
              // tslint:disable-next-line:radix
              - (Number.parseInt(this.sanPham.gia) * Number.parseInt(this.sanPham.giamGia) / 100))/23500) + '';
            // tslint:disable-next-line:radix
            this.usd = Number.parseInt(this.usd);
          });
      this.soLuong = this.thongTin.split(',')[3];
    });
  }

  xacNhanThongTin() {
    if (this.formDatHang.valid) {
      this.thongBao = 'Vui lòng chờ !';
      // this.khachHangService.dangKy(this.khachHang)
      //   .subscribe(data => {
      //     this.thongBao = data.thongBao;
      //     if (data.thongBao === 'Đăng ký tài khoản thành công !') {
      //       const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      //         width: '555px',
      //         height: '180px',
      //         data: {thongBao: this.thongBao},
      //         disableClose: true
      //       });
      //
      //       dialogRefNotice.afterClosed().subscribe(() => {
      //         this.router.navigate(['dang-nhap', {thongBao: ''}]).then(() => {
      //         });
      //       })
      //     }
      //   });
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

  chonSoLuong(soLuong) {
    if (soLuong === 1) {
      if (this.soLuong >= 2) {
        this.soLuong = this.soLuong - 1;
      }
    } else {
      // tslint:disable-next-line:radix
      if (this.soLuong < Number.parseInt(this.sanPham.soLuong)) {
        this.soLuong = this.soLuong + 1;
      } else {
        this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + this.sanPham.soLuong + ' sản phẩm !')
      }
    }
  }

  hienThongBao(thongTin) {
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '555px',
      height: '205px',
      data: {thongBao: thongTin},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(() => {
    })
  }

  payPal() {
    paypal.Buttons(
      {
        style: {
          shape: 'rect',
          color: 'gold',
          layout: 'horizontal',
          label: 'paypal',
          height: 55,
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
            alert('Đã thanh toán !')
          });
        },

        onError: (data, actions) => {
          alert('Lỗi hệ thống !');
        }
      }
    ).render(this.paypalRef.nativeElement);
  }
}
