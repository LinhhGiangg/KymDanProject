import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {NhanVienService} from '../../../service/nhan-vien.service';

@Component({
  selector: 'app-xac-nhan-giao',
  templateUrl: './xac-nhan-giao.component.html',
  styleUrls: ['./xac-nhan-giao.component.css']
})
export class XacNhanGiaoComponent implements OnInit {
  public maDonHang;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<XacNhanGiaoComponent>,
    public nhanVienService: NhanVienService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.maDonHang = this.duLieu.thongTin;
    });
  }

  chuyenTrangThai() {
    this.nhanVienService.giaoHangHoanTat(this.maDonHang).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '550px',
        height: '178px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/chuyen-hang']).then(() => {
        });
        this.dialogRef.close()
      })
    });
  }
}
