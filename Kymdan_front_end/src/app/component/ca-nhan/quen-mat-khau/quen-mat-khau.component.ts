import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-quen-mat-khau',
  templateUrl: './quen-mat-khau.component.html',
  styleUrls: ['./quen-mat-khau.component.css']
})
export class QuenMatKhauComponent implements OnInit {
  public formQuen: FormGroup;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<QuenMatKhauComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public taiKhoanService: TaiKhoanService,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.formQuen = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{0,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]],
    });
  }

  layMatKhau() {
    if (this.formQuen.valid) {
      this.thongBao = 'Vui lòng chờ !';
      this.taiKhoanService.layMatKhau(this.formQuen.value.mail)
        .subscribe(duLieu => {
          this.thongBao = duLieu.thongBao;
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '625px',
            height: '180px',
            data: {thongBao: this.thongBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/dang-nhap']).then(() => {
            });
            this.dialogRef.close()
          })
        });
    } else {
      for (const thuocTinh of Object.keys(this.formQuen.controls)) {
        if (this.formQuen.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }
}
