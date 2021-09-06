import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {KhachHangService} from '../../../service/khach-hang.service';

@Component({
  selector: 'app-huy-don-hang',
  templateUrl: './huy-don-hang.component.html',
  styleUrls: ['./huy-don-hang.component.css']
})
export class HuyDonHangComponent implements OnInit {
  public ma;
  public thongBao;

  constructor(
    public dialogRef: MatDialogRef<HuyDonHangComponent>,
    public khachHangService: KhachHangService,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public activatedRouter: ActivatedRoute,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.activatedRouter.params.subscribe(() => {
      this.ma = this.duLieu.thongTin;
    });
  }

  huy() {
    this.khachHangService.huyDonHang(this.ma).subscribe(duLieu => {
      this.thongBao = duLieu.thongBao;
      const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
        width: '715px',
        height: '181px',
        data: {thongBao: this.thongBao},
        disableClose: true
      });

      dialogRefNotice.afterClosed().subscribe(() => {
        this.router.navigate(['/lich-su-mua-hang']).then(() => {
        });
        this.dialogRef.close()
      })
    });
  }
}
