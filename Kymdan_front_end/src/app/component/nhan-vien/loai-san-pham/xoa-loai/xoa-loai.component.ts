import {Component, Inject, OnInit} from '@angular/core';
import {LoaiSanPhamService} from '../../../../service/loai-san-pham.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-xoa-loai',
  templateUrl: './xoa-loai.component.html',
  styleUrls: ['./xoa-loai.component.css']
})
export class XoaLoaiComponent implements OnInit {
  public tenLoai;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<XoaLoaiComponent>,
    public loaiSanPhamService: LoaiSanPhamService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.tenLoai = this.duLieu.thongTin;
    });
  }

  xoa() {
    this.loaiSanPhamService.xoa(this.tenLoai).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '696px',
        height: '180px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/quan-ly-loai']).then(() => {
        });
        this.dialogRef.close()
      })
      });
  }
}
