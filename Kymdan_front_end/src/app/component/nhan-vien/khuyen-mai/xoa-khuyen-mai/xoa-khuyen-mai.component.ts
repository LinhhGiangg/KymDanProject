import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../../cau-hinh/thong-bao/thong-bao.component';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';

@Component({
  selector: 'app-xoa-khuyen-mai',
  templateUrl: './xoa-khuyen-mai.component.html',
  styleUrls: ['./xoa-khuyen-mai.component.css']
})
export class XoaKhuyenMaiComponent implements OnInit {
  public ma;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<XoaKhuyenMaiComponent>,
    public khuyenMaiService: KhuyenMaiService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.ma = this.duLieu.thongTin;
    });
  }

  xoa() {
    this.khuyenMaiService.xoa(this.ma).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '715px',
        height: '180px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/danh-sach-khuyen-mai']).then(() => {
        });
        this.dialogRef.close()
      })
    });
  }
}
