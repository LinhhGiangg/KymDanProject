import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';

@Component({
  selector: 'app-them-san-pham-khuyen-mai',
  templateUrl: './them-san-pham-khuyen-mai.component.html',
  styleUrls: ['./them-san-pham-khuyen-mai.component.css']
})
export class ThemSanPhamKhuyenMaiComponent implements OnInit {
  public formThem: FormGroup;
  public maKhuyenMai;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<ThemSanPhamKhuyenMaiComponent>,
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
      this.maKhuyenMai = this.duLieu.thongTin;
    });

    this.formThem = this.formBuilder.group({
      maSanPham: ['', [Validators.required, Validators.pattern('^(SP-)[0-9]{3}$')]],
      giamGia: ['', [Validators.required, Validators.pattern('^([1-9]{1})([0-9]?)$')]],
    });
  }

  them() {
    if (this.formThem.valid) {
      this.khuyenMaiService.themSanPhamKhuyenMai(this.maKhuyenMai, this.formThem.value.maSanPham, this.formThem.value.giamGia)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if (this.thongBao === 'Thêm sản phẩm khuyến mãi thành công !') {
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
      for (const thuocTinh of Object.keys(this.formThem.controls)) {
        if (this.formThem.controls[thuocTinh].invalid) {
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
