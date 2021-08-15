import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-sua-loai',
  templateUrl: './sua-loai.component.html',
  styleUrls: ['./sua-loai.component.css']
})
export class SuaLoaiComponent implements OnInit {
  public formSua: FormGroup;
  public duLieuMoi;
  public duLieuCu;
  public thongBao;
  public hinh;
  public kiemTraHinh;
  public diaChiHinh: string;
  public bienDem = 0;
  public hinhDuocChon = new LoaiSanPham();

  constructor(
    public loaiSanPhamService: LoaiSanPhamService,
    public dialogRef: MatDialogRef<SuaLoaiComponent>,
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
      ten: [this.duLieuCu.ten],
      moTa1: [this.duLieuCu.moTa.split(',')[0], [Validators.required, Validators.maxLength(80)]],
      moTa2: [this.duLieuCu.moTa.split(',')[1], [Validators.maxLength(80)]],
      moTa3: [this.duLieuCu.moTa.split(',')[2], [Validators.maxLength(80)]],
      hinh: [''],
    });
    this.hinh = this.duLieuCu.hinh1;
  }

  suaDuLieu() {
    if (this.formSua.valid) {
      if (this.kiemTraHinh || this.bienDem !== 0) {
        this.hinh = 'assets/' + this.hinh;
      }
      this.duLieuMoi = {
        ten: this.duLieuCu.ten,
        moTa:
          this.formSua.value.moTa1 + ',' + this.formSua.value.moTa2 + ',' + this.formSua.value.moTa3,
        hinh: this.hinh,
      };

      this.loaiSanPhamService.sua(this.duLieuMoi)
        .subscribe(ketQua => {
          this.thongBao = ketQua.thongBao;
          const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
            width: '555px',
            height: '180px',
            data: {thongBao: this.thongBao},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/quan-ly-loai', {thongBao: ''}]).then(() => {
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

  chonHinh(image) {
    this.kiemTraHinh = false;
    const file = image;
    if (file.files[0] && file.files[0].type.match('image*')) {
      const fileReader = new FileReader();
      fileReader.onload = (event: any) => {
        this.diaChiHinh = event.target.result;
      };
      fileReader.readAsDataURL(file.files[0]);
      this.hinhDuocChon = file.files[0];
      this.hinh = this.hinhDuocChon.name;
      this.kiemTraHinh = true;
      this.bienDem += 1;
    }
  }
}
