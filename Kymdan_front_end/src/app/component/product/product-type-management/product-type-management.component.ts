import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ProductType} from '../../../model/ProductType';
import {MatDialog} from '@angular/material/dialog';
import {AddProductTypeComponent} from '../add-product-type/add-product-type.component';
import {ActivatedRoute} from '@angular/router';
import {EditProductTypeComponent} from '../edit-product-type/edit-product-type.component';

@Component({
  selector: 'app-product-type-management',
  templateUrl: './product-type-management.component.html',
  styleUrls: ['./product-type-management.component.css']
})
export class ProductTypeManagementComponent implements OnInit {
  public productTypeList = [new ProductType()];
  public message;

  constructor(
    public productService: ProductService,
    public dialog: MatDialog,
    public activatedRouter: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(data => {
      this.message = data.message;
    });

    this.productService.findAllProductType().subscribe(
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

  addProductType() {
    this.message = '';
    const dialogRefAdd = this.dialog.open(AddProductTypeComponent, {
      width: '750px',
      height: '690px',
      data: {dataNeed: ''},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(result => {
      this.ngOnInit();
      this.message = result;
    })
  }

  editProductType(data) {
    this.message = '';
    const dialogRefEdit = this.dialog.open(EditProductTypeComponent, {
      width: '750px',
      height: '690px',
      data: {dataNeed: data},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(result => {
      this.ngOnInit();
      this.message = result;
    })
  }

  edit(id) {
    this.productService.findProductTypeByID(id).subscribe(
      (data) => {
        this.editProductType(data)
      },
      () => {
      },
      () => {
      });
  }
}
