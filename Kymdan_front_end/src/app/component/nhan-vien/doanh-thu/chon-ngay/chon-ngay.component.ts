import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDatepicker} from '@angular/material/datepicker';
import {Router} from '@angular/router';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-chon-ngay',
  templateUrl: './chon-ngay.component.html',
  styleUrls: ['./chon-ngay.component.css']
})
export class ChonNgayComponent implements OnInit {
  public formChonNgay: FormGroup;
  public ngayHienTai = new Date();
  public gioiHanNgay = new Date('yyyy/MM/dd');

  constructor(
    public dialogRef: MatDialogRef<ChonNgayComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.ngayHienTai = new Date();
    this.formChonNgay = this.formBuilder.group({
      ngayBatDau: ['', [Validators.required]],
      ngayKetThuc: ['', [Validators.required]],
    });
  }

  hoanTatChonNgay() {
    if (this.formChonNgay.valid) {
      const THONG_TIN = this.formChonNgay.value.ngayBatDau + ',' + this.formChonNgay.value.ngayKetThuc;
      this.router.navigate(['/thong-ke', {thongTin: THONG_TIN}]).then(() => {
      });
      this.dialogRef.close()
    } else {
      for (const thuocTinh of Object.keys(this.formChonNgay.controls)) {
        if (this.formChonNgay.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }

  gioiHanNgayKetThuc(ngayBatDau: MatDatepicker<any>) {
    this.gioiHanNgay = ngayBatDau._datepickerInput.value;
  }
}
