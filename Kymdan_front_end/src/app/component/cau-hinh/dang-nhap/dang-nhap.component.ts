import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-dang-nhap',
  templateUrl: './dang-nhap.component.html',
  styleUrls: ['./dang-nhap.component.css']
})
export class DangNhapComponent implements OnInit {
  public formDangNhap: FormGroup;
  public taiKhoan;
  public thongBao;
  public thongTin = '';

  constructor(
    public formBuilder: FormBuilder,
    public taiKhoanService: TaiKhoanService,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public el: ElementRef,
  ) {
  }

  ngOnInit() {
    this.activatedRouter.params.subscribe(duLieu => {
      this.thongTin= duLieu.thongTin;
    });

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
      this.taiKhoanService.xacThuc(this.taiKhoan)
        .subscribe(duLieu => {
          if (duLieu.thongBao) {
            this.thongBao = duLieu.thongBao;
            this.taiKhoanService.dangXuat();
          } else {
            this.taiKhoan = duLieu;
            this.taiKhoanService.broadcastLoginChange(this.taiKhoan);
            if (this.taiKhoan.quyen === 'Khách Hàng') {
              if (this.thongTin !== undefined) {
                this.router.navigate(['/mua-hang', {thongTin: this.thongTin}]).then(() => {
                });
              } else {
                this.router.navigateByUrl('').then();
              }
            } else if (this.taiKhoan.quyen === 'Nhân Viên') {
              if (this.thongTin !== undefined) {
                this.router.navigate(['/mua-hang', {thongTin: this.thongTin}]).then(() => {
                });
              } else {
                this.router.navigateByUrl('/quan-ly-loai').then();
              }
            } else if (this.taiKhoan.quyen === 'Nhân Viên Giao Hàng') {
              this.router.navigateByUrl('/chuyen-hang').then();
            }
          }
        }, () => {
          this.thongBao = 'Lỗi hệ thống !';
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
