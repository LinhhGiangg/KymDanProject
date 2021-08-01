import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {LoginService} from '../../service/login.service';
import {MatDialog} from '@angular/material/dialog';
import {NoticePageComponent} from '../notice-page/notice-page.component';
import {Product} from '../../model/Product';
import {ProductType} from '../../model/ProductType';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  private message;
  private role = 'Nothing';
  private userName;
  private typeID;
  private informationProduct;
  private flagSize = 1;
  private flagThick = 1;
  private amount = 1;
  private realPrice: number;
  private price: number;
  private product = new Product();
  private productType = new ProductType();

  constructor(
    private activedRouter: ActivatedRoute,
    protected productService: ProductService,
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

    this.activedRouter.params.subscribe(data => {
      this.typeID = data.typeID;
    });

    this.productService.findProductTypeByID(this.typeID).subscribe(
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
      // if (this.amount < Number.parseInt(this.product.amount)) {
      //   this.amount = this.amount + 1;
      // } else this.openNoticePage('Hiện tại mặt hàng này chỉ còn ' + this.product.amount + ' sản phẩm !')
    }
  }

  saveCart() {
    this.informationProduct = this.amount + ',' + this.realPrice;
    // this.productService.saveCart(this.userName, this.typeID, this.informationProduct).subscribe(
    //   (data) => {
    //     this.openNoticePage(data.message);
    //     this.router.navigate(['product', {}]).then(r => {
    //     });
    //   },
    //   () => {
    //   },
    //   () => {
    //   });
  }

  openNoticePage(value) {
    this.message = value;
    const dialogRefEdit = this.dialog.open(NoticePageComponent, {
      width: '555px',
      height: '180px',
      data: {message: this.message},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(result => {
    })
  }
}
