import {Component, Inject, OnInit} from '@angular/core';
import {ProductTypeService} from '../../../service/product-type.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {NoticePageComponent} from '../../config/notice-page/notice-page.component';

@Component({
  selector: 'app-delete-product-type',
  templateUrl: './delete-product-type.component.html',
  styleUrls: ['./delete-product-type.component.css']
})
export class DeleteProductTypeComponent implements OnInit {
  public typeName;
  public message;

  constructor(
    public dialogRef: MatDialogRef<DeleteProductTypeComponent>,
    public productTypeService: ProductTypeService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(data => {
      this.typeName = this.data.dataNeed;
    });
  }

  delete() {
    this.productTypeService.delete(this.typeName).subscribe(data => {
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
  }
}
