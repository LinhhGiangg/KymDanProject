import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-xoa-san-pham-khuyen-mai',
  templateUrl: './xoa-san-pham-khuyen-mai.component.html',
  styleUrls: ['./xoa-san-pham-khuyen-mai.component.css']
})
export class XoaSanPhamKhuyenMaiComponent implements OnInit {
  public maKhuyenMai;
  public maChiTiet;
  public maSanPham;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<XoaSanPhamKhuyenMaiComponent>,
    public khuyenMaiService: KhuyenMaiService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.maKhuyenMai = this.duLieu.thongTin.split(',')[0];
      this.maChiTiet = this.duLieu.thongTin.split(',')[1];
      this.maSanPham = this.duLieu.thongTin.split(',')[2];
    });
  }

  xoa() {
    this.khuyenMaiService.xoaSanPhamKhuyenMai(this.maChiTiet).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '696px',
        height: '180px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/chi-tiet-khuyen-mai', {thongTin: this.maKhuyenMai}]).then(() => {
        });
        this.dialogRef.close()
      })
    });
  }

  huy() {
    this.router.navigate(['/chi-tiet-khuyen-mai', {thongTin: this.maKhuyenMai}]).then(() => {
    });
    this.dialogRef.close()
  }
}
