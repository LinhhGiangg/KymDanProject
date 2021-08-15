import {Component, OnInit} from '@angular/core';
import {TaiKhoanService} from '../../../service/tai-khoan.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  public taiKhoanHienTai;

  constructor(public taiKhoanService: TaiKhoanService) {
    this.taiKhoanHienTai = JSON.parse(localStorage.getItem('taiKhoanHienTai'));
  }

  ngOnInit() {
    this.taiKhoanService.hoTen.subscribe(duLieu => {
      this.taiKhoanHienTai = duLieu;
    });
  }

  dangXuat() {
    this.taiKhoanService.dangXuat();
    this.taiKhoanHienTai = null;
    this.taiKhoanService.broadcastLoginChange(this.taiKhoanHienTai);
  }
}
