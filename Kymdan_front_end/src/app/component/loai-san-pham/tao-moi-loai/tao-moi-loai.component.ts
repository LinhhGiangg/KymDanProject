import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {Router} from '@angular/router';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-tao-moi-loai',
  templateUrl: './tao-moi-loai.component.html',
  styleUrls: ['./tao-moi-loai.component.css']
})
export class TaoMoiLoaiComponent implements OnInit {
  public formTaoMoi: FormGroup;
  public loai;
  public thongBao;
  public tenHinh;
  public kiemTraHinh = false;
  public diaChiHinh: string;
  public hinhDuocChon = new LoaiSanPham();

  constructor(
    public loaiSanPhamService: LoaiSanPhamService,
    public dialogRef: MatDialogRef<TaoMoiLoaiComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.formTaoMoi = this.formBuilder.group({
      ma: ['', [Validators.required]],
      ten: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(250)]],
      moTa1: ['', [Validators.required, Validators.maxLength(80)]],
      moTa2: ['', [Validators.maxLength(80)]],
      moTa3: ['', [Validators.maxLength(80)]],
      hinh: [''],
    });
  }

  taoMoi() {
    if (this.formTaoMoi.valid && this.tenHinh != null) {
      this.loai = {
        ma: this.formTaoMoi.value.ma,
        ten: this.formTaoMoi.value.ten,
        moTa:
          this.formTaoMoi.value.moTa1 + ',' + this.formTaoMoi.value.moTa2 + ',' + this.formTaoMoi.value.moTa3,
        hinh: 'assets/' + this.tenHinh,
      };

      this.loaiSanPhamService.taoMoi(this.loai)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          if (this.thongBao === 'Thêm thành công !') {
            const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
              width: '555px',
              height: '180px',
              data: {thongBao: this.thongBao},
              disableClose: true
            });

            this.thongBao = '';

            dialogRefNotice.afterClosed().subscribe(() => {
              this.router.navigate(['/quan-ly-loai', {message: ''}]).then(() => {
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

  chonHinh(image) {
    const file = image;
    if (file.files[0] && file.files[0].type.match('image*')) {
      const fileReader = new FileReader();
      fileReader.onload = (event: any) => {
        this.diaChiHinh = event.target.result;
        this.kiemTraHinh = true;
      };
      fileReader.readAsDataURL(file.files[0]);
      this.hinhDuocChon = file.files[0];
      this.tenHinh = this.hinhDuocChon.name
    }
  }
}
