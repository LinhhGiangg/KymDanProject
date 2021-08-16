import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material.module';
import {HttpClientModule} from '@angular/common/http';
import {NavBarComponent} from './component/cau-hinh/nav-bar/nav-bar.component';
import {FooterComponent} from './component/cau-hinh/footer/footer.component';
import {TrangChuComponent} from './component/cau-hinh/trang-chu/trang-chu.component';
import {DanhSachLoaiComponent} from './component/loai-san-pham/danh-sach-loai/danh-sach-loai.component';
import {DangNhapComponent} from './component/cau-hinh/dang-nhap/dang-nhap.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {DangKyComponent} from './component/khach-hang/dang-ky/dang-ky.component';
import {ThongTinComponent} from './component/ca-nhan/thong-tin/thong-tin.component';
import {SuaMatKhauComponent} from './component/ca-nhan/sua-mat-khau/sua-mat-khau.component';
import {MuaHangComponent} from './component/khach-hang/mua-hang/mua-hang.component';
import {ThongBaoComponent} from './component/cau-hinh/thong-bao/thong-bao.component';
import {QuanLyLoaiComponent} from './component/loai-san-pham/quan-ly-loai/quan-ly-loai.component';
import {ChuyenHangComponent} from './component/nhan-vien-giao-hang/chuyen-hang/chuyen-hang.component';
import {TaoMoiLoaiComponent} from './component/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from './component/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from './component/loai-san-pham/xoa-loai/xoa-loai.component';
import {DatHangComponent} from './component/khach-hang/dat-hang/dat-hang.component';
import { DanhSachSanPhamComponent } from './component/san-pham/danh-sach-san-pham/danh-sach-san-pham.component';
import { ThemSanPhamComponent } from './component/san-pham/them-san-pham/them-san-pham.component';
import { SuaSanPhamComponent } from './component/san-pham/sua-san-pham/sua-san-pham.component';
import { XoaSanPhamComponent } from './component/san-pham/xoa-san-pham/xoa-san-pham.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    TrangChuComponent,
    DanhSachLoaiComponent,
    DangNhapComponent,
    DangKyComponent,
    ThongTinComponent,
    SuaMatKhauComponent,
    MuaHangComponent,
    ThongBaoComponent,
    QuanLyLoaiComponent,
    ChuyenHangComponent,
    TaoMoiLoaiComponent,
    SuaLoaiComponent,
    XoaLoaiComponent,
    DatHangComponent,
    DanhSachSanPhamComponent,
    ThemSanPhamComponent,
    SuaSanPhamComponent,
    XoaSanPhamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
