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
  public message;
  public role = 'Nothing';
  public userName;
  public typeID;
  public informationProduct;
  public flagSize = 1;
  public flagThick = 1;
  public amount = 1;
  public realPrice: number;
  public price: number;
  public product = new SanPham();
  public productType = new LoaiSanPham();

  constructor(
    public activatedRouter: ActivatedRoute,
    public productService: SanPhamService,
    public productTypeService: LoaiSanPhamService,
    public loginService: DangNhapService,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    if (this.loginService.thongTinNguoiDungHienTai != null) {
      this.role = this.loginService.thongTinNguoiDungHienTai.quyen;
      this.userName = this.loginService.thongTinNguoiDungHienTai.tenDangNhap;
    }

    this.activatedRouter.params.subscribe(data => {
      this.typeID = data.typeID;
    });

    this.productTypeService.timBangMaLoai(this.typeID).subscribe(
      (data) => {
        this.productType = data;
      },
      () => {
      },
      () => {
      });

    this.productService.timBangMaLoai(this.typeID).subscribe(
      (data) => {
        this.product = data;
        // tslint:disable-next-line:radix
        this.price = Number.parseInt(this.product.gia);
        this.realPrice = this.price;
      },
      () => {
      },
      () => {
      });
  }

  chooseSize(size) {
    this.flagSize = size;
    if (size !== 1 || this.flagThick !== 1) {
      this.realPrice = this.price + (this.price * this.flagSize * 0.12) + (this.price * this.flagThick * 0.12);
    } else this.realPrice = this.price;
  }

  chooseThick(thick) {
    this.flagThick = thick;
    if (thick !== 1 || this.flagSize !== 1) {
      this.realPrice = this.price + (this.price * this.flagSize * 0.12) + (this.price * this.flagThick * 0.12);
    } else this.realPrice = this.price;
  }

  changeAmount(value) {
    if (value === 1) {
      if (this.amount >= 2) {
        this.amount = this.amount - 1;
      }
    } else {
      // tslint:disable-next-line:radix
      // if (this.amount < Number.parseInt(this.view-loai-san-pham-type.amount)) {
      //   this.amount = this.amount + 1;
      // } else this.openNoticePage('Hiện tại mặt hàng này chỉ còn ' + this.view-loai-san-pham-type.amount + ' sản phẩm !')
    }
  }

  saveCart() {
    this.informationProduct = this.amount + ',' + this.realPrice;
    // this.productService.saveCart(this.userName, this.typeID, this.informationProduct).subscribe(
    //   (data) => {
    //     this.openNoticePage(data.message);
    //     this.router.navigate(['view-loai-san-pham-type', {}]).then(r => {
    //     });
    //   },
    //   () => {
    //   },
    //   () => {
    //   });
  }

  openNoticePage(value) {
    this.message = value;
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '555px',
      height: '180px',
      data: {message: this.message},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(result => {
    })
  }
}
