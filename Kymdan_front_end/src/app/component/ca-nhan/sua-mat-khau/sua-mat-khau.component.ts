import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ErrorStateMatcher} from '@angular/material/core';
import {Router} from '@angular/router';
import {DangNhapService} from '../../../service/dang-nhap.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-sua-mat-khau',
  templateUrl: './sua-mat-khau.component.html',
  styleUrls: ['./sua-mat-khau.component.css']
})
export class SuaMatKhauComponent implements OnInit {
  public tenDangNhap;
  public thongBao;
  public formSuaMatKhau: FormGroup;

  public soTrung = new ErrorStateMatcher();

  constructor(
    public dialogRef: MatDialogRef<SuaMatKhauComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dangNhapService: DangNhapService,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.tenDangNhap = this.dangNhapService.thongTinNguoiDungHienTai.tenDangNhap;
    this.formSuaMatKhau = this.formBuilder.group({
      matKhauCu: ['', [Validators.required]],
      matKhauMoi: ['', [Validators.required]],
      xacNhanMatKhauMoi: ['', [Validators.required]],
    }, {validator: this.xacNhanMatKhau('matKhauMoi', 'xacNhanMatKhauMoi')});
  }

  xacNhanMatKhau(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (matchingControl.errors && !matchingControl.errors.confirmedValidator) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({confirmedValidator: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

  sua() {
    if (this.formSuaMatKhau.valid) {
      this.dangNhapService.suaMatKhau(this.tenDangNhap, this.formSuaMatKhau.value.matKhauCu, this.formSuaMatKhau.value.matKhauMoi)
        .subscribe(duLieu => {
          this.thongBao = duLieu.thongBao;
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '555px',
            height: '180px',
            data: {thongBao: this.thongBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/thong-tin', {message: ''}]).then(() => {
            });
            this.dialogRef.close()
          })
        });
    } else {
      for (const thuocTinh of Object.keys(this.formSuaMatKhau.controls)) {
        if (this.formSuaMatKhau.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }
}
