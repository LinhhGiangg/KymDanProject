import {NgModule} from '@angular/core';

import {ThongBaoComponent} from './component/cau-hinh/thong-bao/thong-bao.component';
import {TaoMoiLoaiComponent} from './component/nhan-vien/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from './component/nhan-vien/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from './component/nhan-vien/loai-san-pham/xoa-loai/xoa-loai.component';
import {SuaMatKhauComponent} from './component/ca-nhan/sua-mat-khau/sua-mat-khau.component';
import {XoaSanPhamComponent} from './component/nhan-vien/san-pham/xoa-san-pham/xoa-san-pham.component';
import {ThemSanPhamComponent} from './component/nhan-vien/san-pham/them-san-pham/them-san-pham.component';
import {SuaSanPhamComponent} from './component/nhan-vien/san-pham/sua-san-pham/sua-san-pham.component';
import {ThemKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/them-khuyen-mai/them-khuyen-mai.component';
import {SuaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/sua-khuyen-mai/sua-khuyen-mai.component';
import {XoaKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/xoa-khuyen-mai/xoa-khuyen-mai.component';
import {ThemSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/them-san-pham-khuyen-mai/them-san-pham-khuyen-mai.component';
import {SuaSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/sua-san-pham-khuyen-mai/sua-san-pham-khuyen-mai.component';
import {PhanCongComponent} from './component/nhan-vien/don-hang/phan-cong/phan-cong.component';
import {XoaSanPhamKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/xoa-san-pham-khuyen-mai/xoa-san-pham-khuyen-mai.component';
import {QuenMatKhauComponent} from './component/ca-nhan/quen-mat-khau/quen-mat-khau.component';
import {ChonNgayComponent} from './component/nhan-vien/doanh-thu/chon-ngay/chon-ngay.component';

import {Routes, RouterModule} from '@angular/router';
import {TrangChuComponent} from './component/cau-hinh/trang-chu/trang-chu.component';
import {DanhSachLoaiComponent} from './component/khach-hang/danh-sach-loai/danh-sach-loai.component';
import {DangNhapComponent} from './component/cau-hinh/dang-nhap/dang-nhap.component';
import {DangKyComponent} from './component/khach-hang/dang-ky/dang-ky.component';
import {ThongTinComponent} from './component/ca-nhan/thong-tin/thong-tin.component';
import {MuaHangComponent} from './component/khach-hang/mua-hang/mua-hang.component';
import {QuanLyLoaiComponent} from './component/nhan-vien/loai-san-pham/quan-ly-loai/quan-ly-loai.component';
import {ChuyenHangComponent} from './component/nhan-vien-giao-hang/chuyen-hang/chuyen-hang.component';
import {DatHangComponent} from './component/khach-hang/dat-hang/dat-hang.component';
import {DanhSachSanPhamComponent} from './component/nhan-vien/san-pham/danh-sach-san-pham/danh-sach-san-pham.component';
import {DanhSachKhuyenMaiComponent} from './component/nhan-vien/khuyen-mai/danh-sach-khuyen-mai/danh-sach-khuyen-mai.component';
import {GioHangComponent} from './component/khach-hang/gio-hang/gio-hang.component';
import {LichSuMuaHangComponent} from './component/khach-hang/lich-su-mua-hang/lich-su-mua-hang.component';
import {ChiTietDonHangComponent} from './component/khach-hang/chi-tiet-don-hang/chi-tiet-don-hang.component';
import {DanhSachDonHangComponent} from './component/nhan-vien/don-hang/danh-sach-don-hang/danh-sach-don-hang.component';
import {ChiTietKhuyenMaiComponent} from './component/nhan-vien/san-pham-khuyen-mai/chi-tiet-khuyen-mai/chi-tiet-khuyen-mai.component';
import {XacNhanGiaoComponent} from './component/nhan-vien-giao-hang/xac-nhan-giao/xac-nhan-giao.component';
import {ThongKeComponent} from './component/nhan-vien/doanh-thu/thong-ke/thong-ke.component';
import {HuyDonHangComponent} from './component/khach-hang/huy-don-hang/huy-don-hang.component';
import {SaiDuongDanComponent} from './component/cau-hinh/sai-duong-dan/sai-duong-dan.component';
import {HoaDonComponent} from './component/nhan-vien/hoa-don/hoa-don.component';

const routes: Routes = [
  {path: '', component: TrangChuComponent},
  {path: 'dang-nhap', component: DangNhapComponent},
  {path: 'dang-ky', component: DangKyComponent},
  // {path: 'thong-bao', component: ThongBaoComponent},

  // *** Thông tin tài khoản
  {path: 'thong-tin', component: ThongTinComponent},
  // {path: 'sua-mat-khau', component: SuaMatKhauComponent},
  // {path: 'quen-mat-khau', component: QuenMatKhauComponent},

  // *** Khách Hàng
  {path: 'danh-sach-loai', component: DanhSachLoaiComponent},
  {path: 'mua-hang', component: MuaHangComponent},
  {path: 'dat-hang', component: DatHangComponent},
  {path: 'gio-hang', component: GioHangComponent},
  {path: 'lich-su-mua-hang', component: LichSuMuaHangComponent},
  {path: 'huy-don-hang', component: HuyDonHangComponent},
  {path: 'chi-tiet-don-hang', component: ChiTietDonHangComponent},

  // *** Nhân Viên
  {path: 'quan-ly-loai', component: QuanLyLoaiComponent},
  // {path: 'them-loai', component: TaoMoiLoaiComponent},
  // {path: 'sua-loai', component: SuaLoaiComponent},
  // {path: 'xoa-loai', component: XoaLoaiComponent},

  {path: 'danh-sach-san-pham', component: DanhSachSanPhamComponent},
  // {path: 'them-san-pham', component: ThemSanPhamComponent},
  // {path: 'sua-san-pham', component: SuaSanPhamComponent},
  // {path: 'xoa-san-pham', component: XoaSanPhamComponent},

  {path: 'danh-sach-khuyen-mai', component: DanhSachKhuyenMaiComponent},
  // {path: 'them-khuyen-mai', component: ThemKhuyenMaiComponent},
  // {path: 'sua-khuyen-mai', component: SuaKhuyenMaiComponent},
  // {path: 'xoa-khuyen-mai', component: XoaKhuyenMaiComponent},

  {path: 'chi-tiet-khuyen-mai', component: ChiTietKhuyenMaiComponent},
  // {path: 'them-san-pham-khuyen-mai', component: ThemSanPhamKhuyenMaiComponent},
  // {path: 'sua-san-pham-khuyen-mai', component: SuaSanPhamKhuyenMaiComponent},
  // {path: 'xoa-san-pham-khuyen-mai', component: XoaSanPhamKhuyenMaiComponent},

  {path: 'danh-sach-don-hang', component: DanhSachDonHangComponent},
  // {path: 'phan-cong', component: PhanCongComponent},

  {path: 'danh-sach-hoa-don', component: HoaDonComponent},

  {path: 'thong-ke', component: ThongKeComponent},
  // {path: 'chon-ngay', component: ChonNgayComponent},

  // *** Nhân Viên Giao Hàng
  {path: 'chuyen-hang', component: ChuyenHangComponent},
  {path: 'xac-nhan-giao', component: XacNhanGiaoComponent},

  // *** Sai đường dẫn
  {path: '**', component: SaiDuongDanComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
