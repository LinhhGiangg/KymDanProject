import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SanPhamService} from '../../../../service/san-pham.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-them-san-pham',
  templateUrl: './them-san-pham.component.html',
  styleUrls: ['./them-san-pham.component.css']
})
export class ThemSanPhamComponent implements OnInit {
  public tenDangNhap;
  public formTaoMoi: FormGroup;
  public maLoai;
  public thongBao;

  constructor(
    public taiKhoanService: TaiKhoanService,
    public sanPhamService: SanPhamService,
    public dialogRef: MatDialogRef<ThemSanPhamComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.tenDangNhap = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;

    this.activatedRouter.params.subscribe(() => {
      this.maLoai = this.duLieu.thongTin;
    });

    this.formTaoMoi = this.formBuilder.group({
      ma: ['', [Validators.required, Validators.pattern('^(SP-)[0-9]{7}$')]],
      maLoai: [this.maLoai],
      kichThuoc: ['120x200'],
      doDay: ['5'],
      gia: ['', [Validators.required, Validators.pattern('^([1-9]{1})([0-9]{6,7})$')]],
      soLuong: ['', [Validators.required, Validators.pattern('^([1-9]{1})([0-9]*)$')]],
      nhanVien: [this.tenDangNhap],
    });
  }

  taoMoi() {
    if (this.formTaoMoi.valid) {
      this.sanPhamService.taoMoi(this.formTaoMoi.value)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if (this.thongBao === 'Tạo mới thành công !') {
            const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
              width: '555px',
              height: '180px',
              data: {thongBao: this.thongBao},
              disableClose: true
            });

            dialogRefNotice.afterClosed().subscribe(() => {
              this.router.navigate(['/danh-sach-san-pham', {thongTin: this.maLoai}]).then(() => {
              });
              this.dialogRef.close()
            })
          }
        });
    } else {
      for (const thuocTinh of Object.keys(this.formTaoMoi.controls)) {
        if (this.formTaoMoi.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }

  huy() {
    this.router.navigate(['/danh-sach-san-pham', {thongTin: this.maLoai}]).then(() => {
    });
    this.dialogRef.close()
  }
}
