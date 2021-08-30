import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TrangChuComponent} from './component/cau-hinh/trang-chu/trang-chu.component';
import {DanhSachLoaiComponent} from './component/khach-hang/danh-sach-loai/danh-sach-loai.component';
import {DangNhapComponent} from './component/cau-hinh/dang-nhap/dang-nhap.component';
import {DangKyComponent} from './component/khach-hang/dang-ky/dang-ky.component';
import {ThongTinComponent} from './component/ca-nhan/thong-tin/thong-tin.component';
import {MuaHangComponent} from './component/khach-hang/mua-hang/mua-hang.component';
import {ThongBaoComponent} from './component/cau-hinh/thong-bao/thong-bao.component';
import {QuanLyLoaiComponent} from './component/nhan-vien/loai-san-pham/quan-ly-loai/quan-ly-loai.component';
import {ChuyenHangComponent} from './component/nhan-vien-giao-hang/chuyen-hang/chuyen-hang.component';
import {TaoMoiLoaiComponent} from './component/nhan-vien/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from './component/nhan-vien/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from './component/nhan-vien/loai-san-pham/xoa-loai/xoa-loai.component';
import {SuaMatKhauComponent} from './component/ca-nhan/sua-mat-khau/sua-mat-khau.component';
import {DatHangComponent} from './component/khach-hang/dat-hang/dat-hang.component';
import {DanhSachSanPhamComponent} from './component/nhan-vien/san-pham/danh-sach-san-pham/danh-sach-san-pham.component';
import {XoaSanPhamComponent} from './component/nhan-vien/san-pham/xoa-san-pham/xoa-san-pham.component';
import {ThemSanPhamComponent} from './component/nhan-vien/san-pham/them-san-pham/them-san-pham.component';
import {SuaSanPhamComponent} from './component/nhan-vien/san-pham/sua-san-pham/sua-san-pham.component';
import {DanhSachKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/danh-sach-khuyen-mai/danh-sach-khuyen-mai.component';
import {ThemKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/them-khuyen-mai/them-khuyen-mai.component';
import {SuaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/sua-khuyen-mai/sua-khuyen-mai.component';
import {XoaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/xoa-khuyen-mai/xoa-khuyen-mai.component';
import {GioHangComponent} from './component/khach-hang/gio-hang/gio-hang.component';
import {LichSuMuaHangComponent} from './component/khach-hang/lich-su-mua-hang/lich-su-mua-hang.component';
import {ChiTietDonHangComponent} from './component/khach-hang/chi-tiet-don-hang/chi-tiet-don-hang.component';
import {DanhSachDonHangComponent} from './component/nhan-vien/don-hang/danh-sach-don-hang/danh-sach-don-hang.component';
import {ChiTietKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/chi-tiet-khuyen-mai/chi-tiet-khuyen-mai.component';
import {DanhSachPhieuTraComponent} from './component/nhan-vien/phieu-tra/danh-sach-phieu-tra/danh-sach-phieu-tra.component';
import {ThemSanPhamKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/them-san-pham-khuyen-mai/them-san-pham-khuyen-mai.component';
import {SuaSanPhamKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/sua-san-pham-khuyen-mai/sua-san-pham-khuyen-mai.component';

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
  {path: 'gio-hang', component: GioHangComponent},
  {path: 'lich-su-mua-hang', component: LichSuMuaHangComponent},
  {path: 'chi-tiet-don-hang', component: ChiTietDonHangComponent},

  // Nhân Viên
  {path: 'quan-ly-loai', component: QuanLyLoaiComponent},
  {path: 'them-loai', component: TaoMoiLoaiComponent},
  {path: 'sua-loai', component: SuaLoaiComponent},
  {path: 'xoa-loai', component: XoaLoaiComponent},

  {path: 'danh-sach-san-pham', component: DanhSachSanPhamComponent},
  {path: 'them-san-pham', component: ThemSanPhamComponent},
  {path: 'sua-san-pham', component: SuaSanPhamComponent},
  {path: 'xoa-san-pham', component: XoaSanPhamComponent},

  {path: 'danh-sach-khuyen-mai', component: DanhSachKhuyenMaiComponent},
  {path: 'chi-tiet-khuyen-mai', component: ChiTietKhuyenMaiComponent},
  {path: 'them-khuyen-mai', component: ThemKhuyenMaiComponent},
  {path: 'sua-khuyen-mai', component: SuaKhuyenMaiComponent},
  {path: 'xoa-khuyen-mai', component: XoaKhuyenMaiComponent},
  {path: 'them-san-pham-khuyen-mai', component: ThemSanPhamKhuyenMaiComponent},
  {path: 'sua-san-pham-khuyen-mai', component: SuaSanPhamKhuyenMaiComponent},

  {path: 'danh-sach-don-hang', component: DanhSachDonHangComponent},

  {path: 'danh-sach-phieu-tra', component: DanhSachPhieuTraComponent},

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
