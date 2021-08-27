import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {MatDatepicker} from '@angular/material/datepicker';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-them-khuyen-mai',
  templateUrl: './them-khuyen-mai.component.html',
  styleUrls: ['./them-khuyen-mai.component.css']
})
export class ThemKhuyenMaiComponent implements OnInit {
  public tenDangNhap;
  public formTaoMoi: FormGroup;
  public thongBao;
  public ngayKhuyenMaiCuoi;
  public ngayNhoNhat = new Date();
  public gioiHanNgay = new Date('yyyy/MM/dd');

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khuyenMaiService: KhuyenMaiService,
    public dialogRef: MatDialogRef<ThemKhuyenMaiComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.ngayNhoNhat = new Date();
    this.ngayKhuyenMaiCuoi = this.duLieu.thongTin;
    if (Date.parse(this.ngayKhuyenMaiCuoi) > Date.parse(this.ngayNhoNhat.toDateString())) {
      this.ngayNhoNhat = new Date(this.ngayKhuyenMaiCuoi);
      this.ngayNhoNhat.setDate(this.ngayNhoNhat.getDate() + 1);
    }
    this.tenDangNhap = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.formTaoMoi = this.formBuilder.group({
      ma: ['', [Validators.required, Validators.pattern('^(KM-)[0-9]{3}$')]],
      ten: ['', [Validators.required]],
      moTa: ['', [Validators.required]],
      ngayBatDau: ['', [Validators.required]],
      ngayKetThuc: ['', [Validators.required]],
      tenNhanVien: [this.tenDangNhap]
    });
  }

  taoMoi() {
    if (this.formTaoMoi.valid) {
      this.khuyenMaiService.taoMoi(this.formTaoMoi.value)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if(this.thongBao === 'Tạo mới thành công !') {
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
      for (const thuocTinh of Object.keys(this.formTaoMoi.controls)) {
        if (this.formTaoMoi.controls[thuocTinh].invalid) {
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
