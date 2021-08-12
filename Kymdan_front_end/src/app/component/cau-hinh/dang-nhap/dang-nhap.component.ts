import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DangNhapService} from '../../../service/dang-nhap.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dang-nhap',
  templateUrl: './dang-nhap.component.html',
  styleUrls: ['./dang-nhap.component.css']
})
export class DangNhapComponent implements OnInit {
  public formDangNhap: FormGroup;
  public taiKhoan;
  public thongBao;

  constructor(
    public formBuilder: FormBuilder,
    public dangNhapService: DangNhapService,
    public router: Router,
    public el: ElementRef,
  ) {
  }

  ngOnInit() {
    this.formDangNhap = this.formBuilder.group({
      tenDangNhap: ['', [Validators.required]],
      matKhau: ['', [Validators.required]],
    });
  }

  dangNhap() {
    if (this.formDangNhap.valid) {
      this.taiKhoan = {
        tenDangNhap: this.formDangNhap.value.tenDangNhap,
        matKhau: this.formDangNhap.value.matKhau
      };
      this.dangNhapService.xacThuc(this.taiKhoan)
        .subscribe(duLieu => {
          if (duLieu.thongBao) {
            this.thongBao = duLieu.thongBao;
            this.dangNhapService.dangXuat();
          } else {
            this.taiKhoan = duLieu;
            this.dangNhapService.broadcastLoginChange(this.taiKhoan);
            if (this.taiKhoan.quyen === 'Khách Hàng') {
              this.router.navigateByUrl('');
            } else if (this.taiKhoan.quyen === 'Nhân Viên') {
              this.router.navigateByUrl('/quan-ly-loai');
            } else if (this.taiKhoan.quyen === 'Nhân Viên Giao Hàng') {
              this.router.navigateByUrl('/chuyen-hang');
            }
          }
        }, error => {
          this.thongBao = 'Sai email hoặc mật khẩu !';
        });
    } else {
      for (const thuocTinh of Object.keys(this.formDangNhap.controls)) {
        if (this.formDangNhap.controls[thuocTinh].invalid) {
          const viTriLoi = this.el.nativeElement.querySelector('[formControlName="' + thuocTinh + '"]');
          viTriLoi.focus();
          break;
        }
      }
    }
  }
}
