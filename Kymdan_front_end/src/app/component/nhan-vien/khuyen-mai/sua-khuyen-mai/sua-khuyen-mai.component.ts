import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {MatDatepicker} from '@angular/material/datepicker';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-sua-khuyen-mai',
  templateUrl: './sua-khuyen-mai.component.html',
  styleUrls: ['./sua-khuyen-mai.component.css']
})
export class SuaKhuyenMaiComponent implements OnInit {
  public tenDangNhap;
  public formSua: FormGroup;
  public thongBao;
  public gioiHanTruoc;
  public gioiHanSau;
  public gioiHanNgay = new Date('yyyy/MM/dd');

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khuyenMaiService: KhuyenMaiService,
    public dialogRef: MatDialogRef<SuaKhuyenMaiComponent>,
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

    this.formSua = this.formBuilder.group({
      ma: [this.duLieu.thongTin.ma],
      ten: [this.duLieu.thongTin.ten],
      moTa: [this.duLieu.thongTin.moTa, [Validators.required]],
      ngayBatDau: [this.duLieu.thongTin.ngayBatDau, [Validators.required]],
      ngayKetThuc: [this.duLieu.thongTin.ngayKetThuc, [Validators.required]],
      tenNhanVien: [this.tenDangNhap]
    });

    this.gioiHanTruoc = new Date(this.duLieu.thongTin.gioiHanTruoc);
    this.gioiHanTruoc.setDate(this.gioiHanTruoc.getDate() + 1);
    if (this.duLieu.thongTin.gioiHanSau !== undefined) {
      this.gioiHanSau = new Date(this.duLieu.thongTin.gioiHanSau);
      this.gioiHanSau.setDate(this.gioiHanSau.getDate() - 1);
    }
  }

  sua() {
    if (this.formSua.valid) {
      this.formSua.value.ten = '';
      if (this.duLieu.thongTin.ngayBatDau !== this.formSua.value.ngayBatDau) {
        this.formSua.value.ten += '1';
      }
      if (this.duLieu.thongTin.ngayKetThuc !== this.formSua.value.ngayKetThuc) {
        this.formSua.value.ten += '2';
      }

      this.khuyenMaiService.sua(this.formSua.value)
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
              this.router.navigate(['/danh-sach-khuyen-mai']).then(() => {
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

  gioiHanNgayKetThuc(ngayBatDau: MatDatepicker<any>) {
    this.gioiHanNgay = ngayBatDau._datepickerInput.value;
  }

  chonLaiNgayKetThuc(ngayBatDau: MatDatepicker<any>) {
    this.gioiHanNgay = ngayBatDau._datepickerInput.value;
  }
}
