import {Component, OnInit} from '@angular/core';
import {DangNhapService} from '../../../service/dang-nhap.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  public taiKhoanHienTai;

  constructor(public dangNhapService: DangNhapService) {
    this.taiKhoanHienTai = JSON.parse(localStorage.getItem('taiKhoanHienTai'));
  }

  ngOnInit() {
    this.dangNhapService.hoTen.subscribe(duLieu => {
      this.taiKhoanHienTai = duLieu;
    });
  }

  dangXuat() {
    this.dangNhapService.dangXuat();
    this.taiKhoanHienTai = null;
    this.dangNhapService.broadcastLoginChange(this.taiKhoanHienTai);
  }
}
