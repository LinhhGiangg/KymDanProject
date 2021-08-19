import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {SanPhamService} from '../../../../service/san-pham.service';

@Component({
  selector: 'app-xoa-san-pham',
  templateUrl: './xoa-san-pham.component.html',
  styleUrls: ['./xoa-san-pham.component.css']
})
export class XoaSanPhamComponent implements OnInit {
  public ma;
  public maLoai;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<XoaSanPhamComponent>,
    public sanPhamService: SanPhamService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.ma = this.duLieu.thongTin.split(',')[0];
      this.maLoai = this.duLieu.thongTin.split(',')[1];
    });
  }

  xoa() {
    this.sanPhamService.xoa(this.ma).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '696px',
        height: '195px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/danh-sach-san-pham', {thongTin: this.maLoai}]).then(() => {
        });
        this.dialogRef.close()
      })
    });
  }

  huy() {
    this.router.navigate(['/danh-sach-san-pham', {thongTin: this.maLoai}]).then(() => {
    });
    this.dialogRef.close()
  }
}
