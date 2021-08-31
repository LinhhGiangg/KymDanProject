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
import {DanhSachLoaiComponent} from './component/khach-hang/danh-sach-loai/danh-sach-loai.component';
import {DangNhapComponent} from './component/cau-hinh/dang-nhap/dang-nhap.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {DangKyComponent} from './component/khach-hang/dang-ky/dang-ky.component';
import {ThongTinComponent} from './component/ca-nhan/thong-tin/thong-tin.component';
import {SuaMatKhauComponent} from './component/ca-nhan/sua-mat-khau/sua-mat-khau.component';
import {MuaHangComponent} from './component/khach-hang/mua-hang/mua-hang.component';
import {ThongBaoComponent} from './component/cau-hinh/thong-bao/thong-bao.component';
import {QuanLyLoaiComponent} from './component/nhan-vien/loai-san-pham/quan-ly-loai/quan-ly-loai.component';
import {ChuyenHangComponent} from './component/nhan-vien-giao-hang/chuyen-hang/chuyen-hang.component';
import {TaoMoiLoaiComponent} from './component/nhan-vien/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from './component/nhan-vien/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from './component/nhan-vien/loai-san-pham/xoa-loai/xoa-loai.component';
import {DatHangComponent} from './component/khach-hang/dat-hang/dat-hang.component';
import {DanhSachSanPhamComponent} from './component/nhan-vien/san-pham/danh-sach-san-pham/danh-sach-san-pham.component';
import {ThemSanPhamComponent} from './component/nhan-vien/san-pham/them-san-pham/them-san-pham.component';
import {SuaSanPhamComponent} from './component/nhan-vien/san-pham/sua-san-pham/sua-san-pham.component';
import {XoaSanPhamComponent} from './component/nhan-vien/san-pham/xoa-san-pham/xoa-san-pham.component';
import {DanhSachKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/danh-sach-khuyen-mai/danh-sach-khuyen-mai.component';
import {ThemKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/them-khuyen-mai/them-khuyen-mai.component';
import {SuaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/sua-khuyen-mai/sua-khuyen-mai.component';
import {XoaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/xoa-khuyen-mai/xoa-khuyen-mai.component';
import {ChiTietKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/chi-tiet-khuyen-mai/chi-tiet-khuyen-mai.component';
import {GioHangComponent} from './component/khach-hang/gio-hang/gio-hang.component';
import {LichSuMuaHangComponent} from './component/khach-hang/lich-su-mua-hang/lich-su-mua-hang.component';
import {ChiTietDonHangComponent} from './component/khach-hang/chi-tiet-don-hang/chi-tiet-don-hang.component';
import {DanhSachDonHangComponent} from './component/nhan-vien/don-hang/danh-sach-don-hang/danh-sach-don-hang.component';
import {DanhSachPhieuTraComponent} from './component/nhan-vien/phieu-tra/danh-sach-phieu-tra/danh-sach-phieu-tra.component';
import {ThemSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/them-san-pham-khuyen-mai/them-san-pham-khuyen-mai.component';
import {SuaSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/sua-san-pham-khuyen-mai/sua-san-pham-khuyen-mai.component';
import {PhanCongComponent} from './component/nhan-vien/don-hang/phan-cong/phan-cong.component';
import {MatRadioModule} from '@angular/material/radio';
import {XacNhanGiaoComponent} from './component/nhan-vien-giao-hang/xac-nhan-giao/xac-nhan-giao.component';
import {XoaSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/xoa-san-pham-khuyen-mai/xoa-san-pham-khuyen-mai.component';

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
    XoaSanPhamComponent,
    DanhSachKhuyenMaiComponent,
    ThemKhuyenMaiComponent,
    SuaKhuyenMaiComponent,
    XoaKhuyenMaiComponent,
    ChiTietKhuyenMaiComponent,
    GioHangComponent,
    LichSuMuaHangComponent,
    ChiTietDonHangComponent,
    DanhSachDonHangComponent,
    DanhSachPhieuTraComponent,
    ThemSanPhamKhuyenMaiComponent,
    SuaSanPhamKhuyenMaiComponent,
    PhanCongComponent,
    XacNhanGiaoComponent,
    XoaSanPhamKhuyenMaiComponent
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
    MatRadioModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
