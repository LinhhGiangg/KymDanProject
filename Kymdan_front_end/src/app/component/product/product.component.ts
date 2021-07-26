import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  protected productList = [];
  protected flagPosition;
  private type = 1;

  constructor(
    protected productService: ProductService,
    public router: Router,
  ) {
  }

  ngOnInit() {
    this.productService.findProductByTypeName(this.type).subscribe(
      (data) => {
        this.productList = data;
      },
      () => {
      },
      () => {
      });
  }

  filter(value) {
    this.flagPosition = value;
    this.productService.findProductByTypeAndPrice(this.type, value).subscribe(
      (data) => {
        this.productList = data;
      },
      () => {
      },
      () => {
      });
  }

  viewProduct(id) {
    this.router.navigate(['buy', {productID: id}]).then(r => {
    });
  }
}
