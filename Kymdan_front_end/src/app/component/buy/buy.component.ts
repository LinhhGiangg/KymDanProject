import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/Product';
import {LoginService} from '../../service/login.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  private customerID;
  private productID;
  private informationProduct;
  private flagSize = 1;
  private flagThick = 1;
  private amount = 1;
  private realPrice: number;
  private price: number;
  private product = new Product();

  constructor(
    private activedRouter: ActivatedRoute,
    protected productService: ProductService,
    public loginService: LoginService,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.customerID = this.loginService.currentUserValue.id;

    this.activedRouter.params.subscribe(data => {
      this.productID = data.productID;
    });

    this.productService.findProductByID(this.productID).subscribe(
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
      if (this.amount < Number.parseInt(this.product.amount)) {
        this.amount = this.amount + 1;
      } else alert('Hiện tại mặt hàng này chỉ còn ' + this.product.amount + ' sản phẩm !');
    }
  }

  saveCart() {
    this.informationProduct = this.amount + ',' + this.realPrice + ',' + this.flagSize + ',' + this.flagThick;
    this.productService.saveCart(this.customerID, this.productID, this.informationProduct).subscribe(
      (data) => {
        console.log('ok')
      },
      () => {
      },
      () => {
      });
  }
}
