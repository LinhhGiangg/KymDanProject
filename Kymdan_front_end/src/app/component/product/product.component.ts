import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  protected productList = [];
  protected flagPosition;

  constructor(
    protected productService: ProductService,
  ) {
  }

  ngOnInit() {
    this.productService.findProductByTypeName(1).subscribe(
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
    this.productService.findProductByTypeAndPrice(1, value).subscribe(
      (data) => {
        this.productList = data;
      },
      () => {
      },
      () => {
      });
  }
}
