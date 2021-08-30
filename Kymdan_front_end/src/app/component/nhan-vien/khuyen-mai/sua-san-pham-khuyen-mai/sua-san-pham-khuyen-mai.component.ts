import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-sua-san-pham-khuyen-mai',
  templateUrl: './sua-san-pham-khuyen-mai.component.html',
  styleUrls: ['./sua-san-pham-khuyen-mai.component.css']
})
export class SuaSanPhamKhuyenMaiComponent implements OnInit {
  public formSua: FormGroup;
  public maKhuyenMai;
  public maChiTiet;
  public maSanPham;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<SuaSanPhamKhuyenMaiComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dialog: MatDialog,
    public activatedRouter: ActivatedRoute,
    public khuyenMaiService: KhuyenMaiService,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.maKhuyenMai = this.duLieu.thongTin.split(',')[0];
      this.maChiTiet = this.duLieu.thongTin.split(',')[1];
      this.maSanPham = this.duLieu.thongTin.split(',')[2];
    });

    this.formSua = this.formBuilder.group({
      maSanPham: [this.maSanPham],
      giamGia: ['', [Validators.required, Validators.pattern('^([1-9]{1})([0-9]?)$')]],
    });
  }

  sua() {
    if (this.formSua.valid) {
      this.khuyenMaiService.suaSanPhamKhuyenMai(this.maChiTiet, this.formSua.value.giamGia)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if (this.thongBao === 'Sửa thành công !') {
            const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
              width: '555px',
              height: '180px',
              data: {thongBao: this.thongBao},
              disableClose: true
            });

            dialogRefNotice.afterClosed().subscribe(() => {
              this.router.navigate(['/chi-tiet-khuyen-mai', {thongTin: this.maKhuyenMai}]).then(() => {
              });
              this.dialogRef.close()
            })
          }
        });
    } else {
      for (const thuocTinh of Object.keys(this.formSua.controls)) {
        if (this.formSua.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }

  huy() {
    this.router.navigate(['/chi-tiet-khuyen-mai', {thongTin: this.maKhuyenMai}]).then(() => {
    });
    this.dialogRef.close()
  }

}
