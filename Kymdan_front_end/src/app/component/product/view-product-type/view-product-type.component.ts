import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from '../../../service/product-type.service';
import {Router} from '@angular/router';
import {ProductType} from '../../../model/ProductType';

@Component({
  selector: 'app-view-product-type',
  templateUrl: './view-product-type.component.html',
  styleUrls: ['./view-product-type.component.css']
})
export class ViewProductTypeComponent implements OnInit {
  public productTypeList = [new ProductType()];
  public flagPosition;

  constructor(
    public productService: ProductTypeService,
    public router: Router,
  ) {
  }

  ngOnInit() {
    this.productService.findAll().subscribe(
      (data) => {
        this.productTypeList = data;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.productTypeList.length; i++) {
          this.productTypeList[i].description1 = this.productTypeList[i].description.split(',')[0];
          this.productTypeList[i].description2 = this.productTypeList[i].description.split(',')[1];
          this.productTypeList[i].description3 = this.productTypeList[i].description.split(',')[2];
        }
      });
  }

  filter(value) {
    this.flagPosition = value;
    this.productService.findByPrice(value).subscribe(
      (data) => {
        this.productTypeList = data;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.productTypeList.length; i++) {
          this.productTypeList[i].description1 = this.productTypeList[i].description.split(',')[0];
          this.productTypeList[i].description2 = this.productTypeList[i].description.split(',')[1];
          this.productTypeList[i].description3 = this.productTypeList[i].description.split(',')[2];
        }
      });
  }

  viewProduct(id) {
    this.router.navigate(['buy', {typeID: id}]).then(r => {
    });
  }
}
