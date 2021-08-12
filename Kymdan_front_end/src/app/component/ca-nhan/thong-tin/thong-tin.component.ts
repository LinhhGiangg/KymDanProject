import {Component, ElementRef, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DangNhapService} from '../../../service/dang-nhap.service';
import {TaiKhoan} from '../../../model/TaiKhoan';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import {SuaMatKhauComponent} from '../sua-mat-khau/sua-mat-khau.component';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-thong-tin',
  templateUrl: './thong-tin.component.html',
  styleUrls: ['./thong-tin.component.css']
})
export class ThongTinComponent implements OnInit {
  public tenDangNhap;
  public quyen;
  public nguoiDung = new TaiKhoan();
  public thongBao;
  public canhBao;
  public xacNhanSua = false;
  public formSuaThongTin: FormGroup;
  public thongTinMoi;

  constructor(
    public formBuilder: FormBuilder,
    public dangNhapService: DangNhapService,
    public router: Router,
    public el: ElementRef,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.formSuaThongTin = this.formBuilder.group({
      hoTen: [''],
      email: [''],
      matKhau: [''],
      soDienThoai: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      ngaySinh: ['', [Validators.required, this.kiemTraTuoi]],
      diaChi: ['', [Validators.required]],
      gioiTinh: ['', [Validators.required]],
    });
    this.tenDangNhap = this.dangNhapService.thongTinNguoiDungHienTai.tenDangNhap;
    this.quyen = this.dangNhapService.thongTinNguoiDungHienTai.quyen;
    this.dangNhapService.xemThongTin(this.tenDangNhap, this.quyen).subscribe(duLieu => {
      this.nguoiDung = duLieu;
      this.formSuaThongTin.patchValue(duLieu);
    });
  }

  suaThongTin() {
    this.xacNhanSua = true;
    this.ngOnInit();
    this.thongBao = ''
  }

  kiemTraTuoi(control: AbstractControl) {
    const ngaySinh = new Date(control.value);
    const ngayHienTai = new Date();
    const soTuoi = (ngayHienTai.getTime() - ngaySinh.getTime()) / (1000 * 60 * 60 * 24 * 365);
    return (soTuoi > 16 && soTuoi < 150) ? true : {ageError: true};
  }

  suaDuLieu() {
    this.thongTinMoi = {
      soDienThoai: this.formSuaThongTin.value.soDienThoai,
      hoTen: this.formSuaThongTin.value.hoTen,
      ngaySinh: this.formSuaThongTin.value.ngaySinh,
      diaChi: this.formSuaThongTin.value.diaChi,
      gioiTinh: this.formSuaThongTin.value.gioiTinh,
      email: this.formSuaThongTin.value.email,
      quyen: this.quyen
    };

    if (this.formSuaThongTin.valid) {
      this.dangNhapService.suaThongTin(this.thongTinMoi)
        .subscribe(duLieu => {
          this.canhBao = duLieu.thongBao;
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '555px',
            height: '180px',
            data: {thongBao: this.canhBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.xacNhanSua = false;
            this.ngOnInit();
          })
        });
    } else {
      for (const thuocTinh of Object.keys(this.formSuaThongTin.controls)) {
        if (this.formSuaThongTin.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }

  suaMatKhau() {
    this.thongBao = '';
    const dialogRefEdit = this.dialog.open(SuaMatKhauComponent, {
      width: '500px',
      height: '319px',
      data: {thongTin: ''},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(result => {
      this.thongBao = result;
      this.ngOnInit()
    })
  }
}
