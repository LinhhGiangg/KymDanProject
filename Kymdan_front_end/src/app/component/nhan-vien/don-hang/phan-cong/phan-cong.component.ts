import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {NhanVienService} from '../../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-phan-cong',
  templateUrl: './phan-cong.component.html',
  styleUrls: ['./phan-cong.component.css']
})
export class PhanCongComponent implements OnInit {
  public formPhanCong: FormGroup;
  public maDonHang;
  public nhanVien;
  public danhSach = [];
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<PhanCongComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dialog: MatDialog,
    public activatedRouter: ActivatedRoute,
    public nhanVienService: NhanVienService,
    public taiKhoanService: TaiKhoanService,
  ) {
  }

  ngOnInit(): void {
    this.nhanVien = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.activatedRouter.params.subscribe(() => {
      this.maDonHang = this.duLieu.thongTin;
    });

    this.nhanVienService.danhSachNhanVienGiaoHang(this.nhanVien)
      .subscribe(ketQua => {
        this.danhSach = ketQua;
      });

    this.formPhanCong = this.formBuilder.group({
      maDonHang: [this.maDonHang],
      giaoHang: ['', [Validators.required]],
    });
  }

  sua() {
    if (this.formPhanCong.valid) {
      const THONG_TIN = this.maDonHang + ',' + this.nhanVien + ',' + this.formPhanCong.value.giaoHang;
      this.nhanVienService.phanCongGiaoHang(THONG_TIN)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if (this.thongBao === 'Thành công !') {
            const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
              width: '555px',
              height: '180px',
              data: {thongBao: this.thongBao},
              disableClose: true
            });

            dialogRefNotice.afterClosed().subscribe(() => {
              this.router.navigate(['/danh-sach-don-hang']).then(() => {
              });
              this.dialogRef.close()
            })
          }
        });
    } else {
      for (const thuocTinh of Object.keys(this.formPhanCong.controls)) {
        if (this.formPhanCong.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }
}
