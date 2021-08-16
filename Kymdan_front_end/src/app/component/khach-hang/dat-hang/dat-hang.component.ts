import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {KhachHangService} from '../../../service/khach-hang.service';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-dat-hang',
  templateUrl: './dat-hang.component.html',
  styleUrls: ['./dat-hang.component.css']
})
export class DatHangComponent implements OnInit {
  public formDangKy: FormGroup;
  public thongTin;
  public taiKhoan;
  public thongBao;
  public canhBao;

  public soTrung = new ErrorStateMatcher();

  constructor(
    public formBuilder: FormBuilder,
    public khachHangService: KhachHangService,
    public router: Router,
    public el: ElementRef,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.formDangKy = this.formBuilder.group({
      tenDangNhap: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50),
        // tslint:disable-next-line:max-line-length
        Validators.pattern('^([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+(\\s[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+)*)$')]],
      email: ['', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{0,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]],
      matKhau: ['', [Validators.required]],
      xacNhanMatKhau: ['', [Validators.required]],
      soDienThoai: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      ngaySinh: ['', [Validators.required]],
      diaChi: ['', [Validators.required]],
      gioiTinh: ['', [Validators.required]],
    })
  }

  dangKy() {
    this.thongTin = {
      soDienThoai: this.formDangKy.value.soDienThoai,
      ten: this.formDangKy.value.tenDangNhap,
      ngaySinh: this.formDangKy.value.ngaySinh,
      diaChi: this.formDangKy.value.diaChi,
      gioiTinh: this.formDangKy.value.gioiTinh,
      email: this.formDangKy.value.email
    };
    this.taiKhoan = {
      tenDangNhap: this.formDangKy.value.tenDangNhap,
      matKhau: this.formDangKy.value.matKhau,
      thongTinDTO: this.thongTin
    };

    if (this.formDangKy.valid) {
      this.thongBao = 'Vui lòng chờ !';
      this.khachHangService.dangKy(this.taiKhoan)
        .subscribe(data => {
          this.thongBao = data.thongBao;
          if (data.thongBao === 'Đăng ký tài khoản thành công !') {
            this.canhBao = data.thongBao;
            this.thongBao = '';
            const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
              width: '555px',
              height: '180px',
              data: {thongBao: this.canhBao},
              disableClose: true
            });

            dialogRefNotice.afterClosed().subscribe(() => {
              this.router.navigate(['dang-nhap', {thongBao: ''}]).then(() => {
              });
            })
          }
        });
    } else {
      for (const thuocTinh of Object.keys(this.formDangKy.controls)) {
        if (this.formDangKy.controls[thuocTinh].invalid) {
          const viTri = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTri.focus();
          break;
        }
      }
    }
  }
}
