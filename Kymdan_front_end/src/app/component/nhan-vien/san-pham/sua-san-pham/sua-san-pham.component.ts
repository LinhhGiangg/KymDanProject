import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {SanPhamService} from '../../../../service/san-pham.service';

@Component({
  selector: 'app-sua-san-pham',
  templateUrl: './sua-san-pham.component.html',
  styleUrls: ['./sua-san-pham.component.css']
})
export class SuaSanPhamComponent implements OnInit {
  public formSua: FormGroup;
  public duLieuMoi;
  public duLieuCu;
  public thongBao;

  constructor(
    public sanPhamService: SanPhamService,
    public dialogRef: MatDialogRef<SuaSanPhamComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.duLieuCu = this.duLieu.thongTin;
    });

    this.formSua = this.formBuilder.group({
      ma: [this.duLieuCu.ma],
      gia: [this.duLieuCu.gia, [Validators.required, Validators.pattern('^([1-9]{1})([0-9]{6,7})$')]],
      soLuong: [this.duLieuCu.soLuong, [Validators.required, Validators.pattern('^([1-9]{1})([0-9]*)$')]],
      giamGia: [this.duLieuCu.giamGia, [Validators.required, Validators.pattern('^([0-9]{1})([0-9]?)$')]],
    });
  }

  suaDuLieu() {
    if (this.formSua.valid) {
      this.duLieuMoi = {
        ma: this.duLieuCu.ma,
        gia: this.formSua.value.gia,
        soLuong: this.formSua.value.soLuong,
        giamGia: this.formSua.value.giamGia,
      };

      this.sanPhamService.sua(this.duLieuMoi)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '555px',
            height: '180px',
            data: {thongBao: this.thongBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/danh-sach-san-pham', {thongTin: this.duLieuCu.loaiSanPham.ma}]).then(() => {
            });
            this.dialogRef.close()
          })
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
    this.router.navigate(['/danh-sach-san-pham', {thongTin: this.duLieuCu.loaiSanPham.ma}]).then(() => {
    });
    this.dialogRef.close()
  }
}
