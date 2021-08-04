import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginService} from '../../../service/login.service';
import {MatDialog} from '@angular/material/dialog';
import {NoticePageComponent} from '../../config/notice-page/notice-page.component';
import {Product} from '../../../model/Product';
import {ProductType} from '../../../model/ProductType';
import {ProductService} from '../../../service/product.service';
import {ProductTypeService} from '../../../service/product-type.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
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
  public product = new Product();
  public productType = new ProductType();

  constructor(
    public activatedRouter: ActivatedRoute,
    public productService: ProductService,
    public productTypeService: ProductTypeService,
    public loginService: LoginService,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    if (this.loginService.currentUserValue != null) {
      this.role = this.loginService.currentUserValue.role;
      this.userName = this.loginService.currentUserValue.username;
    }

    this.activatedRouter.params.subscribe(data => {
      this.typeID = data.typeID;
    });

    this.productTypeService.findByID(this.typeID).subscribe(
      (data) => {
        this.productType = data;
      },
      () => {
      },
      () => {
      });

    this.productService.findProductByTypeID(this.typeID).subscribe(
      (data) => {
        this.product = data;
        // tslint:disable-next-line:radix
        this.price = Number.parseInt(this.product.price);
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
      // if (this.amount < Number.parseInt(this.view-product-type.amount)) {
      //   this.amount = this.amount + 1;
      // } else this.openNoticePage('Hiện tại mặt hàng này chỉ còn ' + this.view-product-type.amount + ' sản phẩm !')
    }
  }

  saveCart() {
    this.informationProduct = this.amount + ',' + this.realPrice;
    // this.productService.saveCart(this.userName, this.typeID, this.informationProduct).subscribe(
    //   (data) => {
    //     this.openNoticePage(data.message);
    //     this.router.navigate(['view-product-type', {}]).then(r => {
    //     });
    //   },
    //   () => {
    //   },
    //   () => {
    //   });
  }

  openNoticePage(value) {
    this.message = value;
    const dialogRefNotice = this.dialog.open(NoticePageComponent, {
      width: '555px',
      height: '180px',
      data: {message: this.message},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(result => {
    })
  }
}
