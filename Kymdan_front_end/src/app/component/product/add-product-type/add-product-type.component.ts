import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ProductTypeService} from '../../../service/product-type.service';
import {Router} from '@angular/router';
import {ProductType} from '../../../model/ProductType';
import {NoticePageComponent} from '../../config/notice-page/notice-page.component';

@Component({
  selector: 'app-add-product-type',
  templateUrl: './add-product-type.component.html',
  styleUrls: ['./add-product-type.component.css']
})
export class AddProductTypeComponent implements OnInit {
  public formCreate: FormGroup;
  public productType;
  public message;
  public checkImage = false;
  public imgSrc: string;
  public selectedImage = new ProductType();

  constructor(
    public productTypeService: ProductTypeService,
    public dialogRef: MatDialogRef<AddProductTypeComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.formCreate = this.formBuilder.group({
      typeName: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(250)]],
      description1: ['', [Validators.required, Validators.maxLength(80)]],
      description2: ['', [Validators.maxLength(80)]],
      description3: ['', [Validators.maxLength(80)]],
      price: ['', [Validators.required, Validators.pattern('^([1-9]{1})([0-9]{7})$')]],
      image: ['', [Validators.required]],
    });
  }

  onSubmitAdd() {
    if (this.formCreate.valid) {
      this.productType = {
        typeName: this.formCreate.value.typeName,
        description:
          this.formCreate.value.description1 + ',' + this.formCreate.value.description2 + ',' + this.formCreate.value.description3,
        image: 'assets/' + this.selectedImage.name,
        price: this.formCreate.value.price,
      };

      this.productTypeService.addNew(this.productType)
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
      for (const key of Object.keys(this.formCreate.controls)) {
        if (this.formCreate.controls[key].invalid) {
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
        this.checkImage = true;
      };
      fileReader.readAsDataURL(file.files[0]);
      this.selectedImage = file.files[0];
    }
    // sửa lỗi cancel
  }
}
