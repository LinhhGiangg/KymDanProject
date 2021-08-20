import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {KhuyenMai} from '../../../../model/KhuyenMai';
import {ChiTietKhuyenMai} from '../../../../model/ChiTietKhuyenMai';

@Component({
  selector: 'app-chi-tiet-khuyen-mai',
  templateUrl: './chi-tiet-khuyen-mai.component.html',
  styleUrls: ['./chi-tiet-khuyen-mai.component.css']
})
export class ChiTietKhuyenMaiComponent implements OnInit {
  public khuyenMai = new KhuyenMai();
  public chiTietKhuyenMai = new ChiTietKhuyenMai();
  public maSanPham;
  public giamGia;

  constructor(
    public khuyenMaiService: KhuyenMaiService,
    public dialogRef: MatDialogRef<ChiTietKhuyenMaiComponent>,
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.khuyenMai = this.duLieu.thongTin;
    this.khuyenMaiService.timChiTietBangMa(this.duLieu.thongTin.ma)
      .subscribe(ketQua => {
        this.chiTietKhuyenMai = ketQua;
        },
        () => {
        },
        () => {
          this.maSanPham = this.chiTietKhuyenMai.sanPham.ma;
          this.giamGia = this.chiTietKhuyenMai.giamGia;
        });
  }
}
