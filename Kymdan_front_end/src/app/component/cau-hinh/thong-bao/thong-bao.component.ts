import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-thong-bao',
  templateUrl: './thong-bao.component.html',
  styleUrls: ['./thong-bao.component.css']
})
export class ThongBaoComponent implements OnInit {
  public thongBao;

  constructor(
    @Inject(MAT_DIALOG_DATA) public duLieu: any,
  ) {
  }

  ngOnInit(): void {
    this.thongBao = this.duLieu.thongBao;
  }

}
