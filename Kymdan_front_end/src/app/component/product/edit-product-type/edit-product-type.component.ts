import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductType} from '../../../model/ProductType';
import {ProductTypeService} from '../../../service/product-type.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {NoticePageComponent} from '../../config/notice-page/notice-page.component';

@Component({
  selector: 'app-edit-product-type',
  templateUrl: './edit-product-type.component.html',
  styleUrls: ['./edit-product-type.component.css']
})
export class EditProductTypeComponent implements OnInit {
  public formEdit: FormGroup;
  public productType;
  public productTypeNeed;
  public message;
  public checkImage = false;
  public image;
  public imgSrc: string;
  public selectedImage = new ProductType();

  constructor(
    public productTypeService: ProductTypeService,
    public dialogRef: MatDialogRef<EditProductTypeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(data => {
      this.productTypeNeed = this.data.dataNeed;
    });

    this.formEdit = this.formBuilder.group({
      typeName: [this.productTypeNeed.typeName],
      description1: [this.productTypeNeed.description.split(',')[0], [Validators.required, Validators.maxLength(80)]],
      description2: [this.productTypeNeed.description.split(',')[1], [Validators.maxLength(80)]],
      description3: [this.productTypeNeed.description.split(',')[2], [Validators.maxLength(80)]],
      price: [this.productTypeNeed.price, [Validators.required, Validators.pattern('^([1-9]{1})([0-9]{7})$')]],
      image: [''],
    });
    this.image = this.productTypeNeed.image1;
  }

  onSubmitEdit() {
    if (this.formEdit.valid) {
      if (this.checkImage) {
        this.image = 'assets/' + this.image;
      }
      this.productType = {
        typeName: this.productTypeNeed.typeName,
        description:
          this.formEdit.value.description1 + ',' + this.formEdit.value.description2 + ',' + this.formEdit.value.description3,
        image: this.image,
        price: this.formEdit.value.price,
      };

      this.productTypeService.edit(this.productType)
        .subscribe(data => {
          this.message = data.message;
          const dialogRefNotice = this.dialog.open(NoticePageComponent, {
            width: '555px',
            height: '180px',
            data: {message: this.message},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/product-type-management', {message: ''}]).then(() => {
            });
            this.dialogRef.close()
          })
        });
    } else {
      for (const key of Object.keys(this.formEdit.controls)) {
        if (this.formEdit.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formControlName="' + key + '"]');
          invalidControl.focus();
          break;
        }
      }
    }
  }

  choosePhoto(image) {
    const file = image;
    if (file.files[0] && file.files[0].type.match('image*')) {
      const fileReader = new FileReader();
      fileReader.onload = (event: any) => {
        this.imgSrc = event.target.result;
      };
      fileReader.readAsDataURL(file.files[0]);
      this.selectedImage = file.files[0];
      this.image = this.selectedImage.name;
    } {
      this.checkImage = false;
    }
    // sửa lỗi cancel
  }
}
