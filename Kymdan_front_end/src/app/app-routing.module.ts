import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TrangChuComponent} from './component/cau-hinh/trang-chu/trang-chu.component';
import {DanhSachLoaiComponent} from './component/loai-san-pham/danh-sach-loai/danh-sach-loai.component';
import {DangNhapComponent} from './component/cau-hinh/dang-nhap/dang-nhap.component';
import {DangKyComponent} from './component/khach-hang/dang-ky/dang-ky.component';
import {ThongTinComponent} from './component/ca-nhan/thong-tin/thong-tin.component';
import {MuaHangComponent} from './component/khach-hang/mua-hang/mua-hang.component';
import {ThongBaoComponent} from './component/cau-hinh/thong-bao/thong-bao.component';
import {QuanLyLoaiComponent} from './component/loai-san-pham/quan-ly-loai/quan-ly-loai.component';
import {ChuyenHangComponent} from './component/nhan-vien-giao-hang/chuyen-hang/chuyen-hang.component';
import {TaoMoiLoaiComponent} from './component/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from './component/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from './component/loai-san-pham/xoa-loai/xoa-loai.component';
import {SuaMatKhauComponent} from './component/ca-nhan/sua-mat-khau/sua-mat-khau.component';
import {DatHangComponent} from './component/khach-hang/dat-hang/dat-hang.component';
import {DanhSachSanPhamComponent} from './component/san-pham/danh-sach-san-pham/danh-sach-san-pham.component';
import {XoaSanPhamComponent} from './component/san-pham/xoa-san-pham/xoa-san-pham.component';
import {ThemSanPhamComponent} from './component/san-pham/them-san-pham/them-san-pham.component';
import {SuaSanPhamComponent} from './component/san-pham/sua-san-pham/sua-san-pham.component';

const routes: Routes = [
  {path: '', component: TrangChuComponent},
  {path: 'thong-bao', component: ThongBaoComponent},
  {path: 'dang-nhap', component: DangNhapComponent},
  {path: 'dang-ky', component: DangKyComponent},

  // Thông tin tài khoản
  {path: 'thong-tin', component: ThongTinComponent},
  {path: 'sua-mat-khau', component: SuaMatKhauComponent},

  // Khách Hàng
  {path: 'danh-sach-loai', component: DanhSachLoaiComponent},
  {path: 'mua-hang', component: MuaHangComponent},
  {path: 'dat-hang', component: DatHangComponent},

  // Nhân Viên
  {path: 'quan-ly-loai', component: QuanLyLoaiComponent},
  {path: 'them-loai', component: TaoMoiLoaiComponent},
  {path: 'sua-loai', component: SuaLoaiComponent},
  {path: 'xoa-loai', component: XoaLoaiComponent},
  {path: 'danh-sach-san-pham', component: DanhSachSanPhamComponent},
  {path: 'them-san-pham', component: ThemSanPhamComponent},
  {path: 'sua-san-pham', component: SuaSanPhamComponent},
  {path: 'xoa-san-pham', component: XoaSanPhamComponent},

  // Nhân Viên Giao Hàng
  {path: 'chuyen-hang', component: ChuyenHangComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
