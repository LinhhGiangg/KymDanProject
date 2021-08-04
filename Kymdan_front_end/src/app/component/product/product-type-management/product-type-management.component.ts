import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from '../../../service/product-type.service';
import {ProductType} from '../../../model/ProductType';
import {MatDialog} from '@angular/material/dialog';
import {AddProductTypeComponent} from '../add-product-type/add-product-type.component';
import {EditProductTypeComponent} from '../edit-product-type/edit-product-type.component';
import {DeleteProductTypeComponent} from '../delete-product-type/delete-product-type.component';

@Component({
  selector: 'app-product-type-management',
  templateUrl: './product-type-management.component.html',
  styleUrls: ['./product-type-management.component.css']
})
export class ProductTypeManagementComponent implements OnInit {
  public productTypeList = [new ProductType()];
  public message;

  constructor(
    public productTypeService: ProductTypeService,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.productTypeService.findAll().subscribe(
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

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  edit(id) {
    this.productTypeService.findByID(id).subscribe(
      (data) => {
        this.editProductType(data)
      },
      () => {
      },
      () => {
      });
  }

  editProductType(data) {
    this.message = '';
    const dialogRefEdit = this.dialog.open(EditProductTypeComponent, {
      width: '750px',
      height: '690px',
      data: {dataNeed: data},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  delete(typeName) {
    this.message = '';
    const dialogRefDelete = this.dialog.open(DeleteProductTypeComponent, {
      width: '690px',
      height: '180px',
      data: {dataNeed: typeName},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  view(id) {
  }
}
