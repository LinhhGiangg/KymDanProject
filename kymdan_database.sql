use kymdan;

-- Quyền
insert into kymdan.quyen (ma, ten) values (1, 'Nhân Viên');
insert into kymdan.quyen (ma, ten) values (2, 'Nhân Viên Giao Hàng');
insert into kymdan.quyen (ma, ten) values (3, 'Khách Hàng');

-- Nhân viên, Nhân viên giao hàng, Khách hàng
insert into kymdan.nhan_vien (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values ('NV-0000001', 'Linh Giang', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'linhgiang@gmail.com');
insert into kymdan.nhan_vien (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values ('NV-0000002', 'Nguyen Khang', 'Nam', '1990-01-01', 'Đăk Lăk', '0769333333', 'nguyenkhang@gmail.com');
insert into kymdan.nhan_vien_giao_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email, ten_cong_ty) values ('NVGH-00001', 'Thanh Phong', 'Nam', '1999-05-30', 'Sài Gòn', '0905111111', 'shipper@gmail.com', 'Grab');
insert into kymdan.nhan_vien_giao_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email, ten_cong_ty) values ('NVGH-00002', 'Phong Tran', 'Nam', '1999-05-15', 'Sài Gòn', '0905222222', 'shipper2@gmail.com', 'Bee');
insert into kymdan.nhan_vien_giao_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email, ten_cong_ty) values ('NVGH-00003', 'Tran Duc', 'Nam', '1999-05-05', 'Sài Gòn', '0905333333', 'shipper3@gmail.com', 'Now');
insert into kymdan.khach_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (1, 'Khoi Nguyen', 'Nam', '1995-05-27', 'Quảng Nam', '0905999999', 'khoinguyen@gmail.com');
insert into kymdan.khach_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (2, 'Phuong Thao', 'Nữ', '1973-01-01', 'Dak Lak', '0905111111', 'phuongthao@gmail.com');

-- Tài khoản
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien) values ('Linh Giang', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 1, 'NV-0000001');
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien) values ('Nguyen Khang', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 1, 'NV-0000002');
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien_giao_hang) values ('Thanh Phong', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 2, 'NVGH-00001');
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien_giao_hang) values ('Phong Tran', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 2, 'NVGH-00002');
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien_giao_hang) values ('Tran Duc', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 2, 'NVGH-00003');
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_khach_hang) values ('Khoi Nguyen', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 3, 1);
insert into kymdan.tai_khoan (ten_dang_nhap, mat_khau, ma_quyen, ma_khach_hang) values ('Phuong Thao', '$2a$10$p.QypqLUDiV7hVx8MJAk7OMAZcv2VdesvHwf3Sn0UZ4MNKzCsl75u', 3, 2);

-- Loại sản phẩm
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000111', 'Nệm (mattress) KYMDAN Deluxe', 'assets/sanPham11.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® được NASA công nhận,Giúp giảm đau tại các điểm chịu lực,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', '2021-03-11', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000222', 'Nệm (mattress) KYMDAN UltimateCare', 'assets/sanPham12.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® nâng đỡ cơ thể,Công nghệ Dynamic Support tăng khả năng đàn hồi,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', '2021-03-15', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000333', 'Nệm (mattress) KYMDAN Deluxe Premium', 'assets/sanPham15.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Ứng dụng công nghệ hiện đại PuroTex,Tích hợp 3 lớp cao su đặc biệt,Lớp phủ sinh học Nanobiotic', '2021-08-29', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000444', 'Nệm (mattress) KYMDAN Massage', 'assets/sanPham16.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Nâng đỡ 5 vùng cơ thể,Độ thoáng khí tốt,Lõi nệm kháng khuẩn', '2021-08-30', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000555', 'Nệm (mattress) KYMDAN Y Tế', 'assets/sanPham17.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Công nghệ HourGlass Support® độc quyền,Lớp Memory Foam có độ bền cao', '2021-09-01', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000666', 'Nệm (mattress) KYMDAN Premium', 'assets/sanPham1.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Lõi nệm kháng khuẩn,Lớp Memory Foam có độ bền cao', '2021-09-02', 0);
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, ngay_tao, luong_mua) values ('KD-0000777', 'Nệm (mattress) KYMDAN Royal', 'assets/sanPham5.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Chống dị ứng,Lớp Memory Foam có độ bền cao', '2021-09-03', 0);

-- Sản phẩm
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000001', '120', '200', '5', 5, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000002', '140', '200', '5', 0, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000003', '160', '200', '5', 2, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000004', '180', '200', '5', 3, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000005', '200', '200', '5', 5, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000006', '120', '200', '10', 2, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000007', '140', '200', '10', 3, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000008', '160', '200', '10', 5, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000009', '180', '200', '10', 8, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000010', '200', '200', '10', 6, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000011', '120', '200', '15', 5, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000012', '140', '200', '15', 3, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000013', '160', '200', '15', 2, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000014', '180', '200', '15', 6, 'KD-0000111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000015', '200', '200', '15', 3, 'KD-0000111');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000016', '120', '200', '5', 5, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000017', '140', '200', '5', 7, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000018', '160', '200', '5', 2, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000019', '180', '200', '5', 3, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000020', '120', '200', '10', 2, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000021', '140', '200', '10', 3, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000022', '160', '200', '10', 5, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000023', '180', '200', '10', 8, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000024', '120', '200', '15', 5, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000025', '140', '200', '15', 6, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000026', '160', '200', '15', 5, 'KD-0000222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000027', '180', '200', '15', 3, 'KD-0000222');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000028', '120', '200', '5', 8, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000029', '140', '200', '5', 3, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000030', '160', '200', '5', 5, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000031', '200', '200', '5', 6, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000032', '120', '200', '10', 3, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000033', '140', '200', '10', 6, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000034', '160', '200', '10', 5, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000035', '200', '200', '10', 7, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000036', '120', '200', '15', 6, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000037', '140', '200', '15', 8, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000038', '160', '200', '15', 3, 'KD-0000333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000039', '200', '200', '15', 6, 'KD-0000333');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000040', '120', '200', '5', 5, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000041', '160', '200', '5', 2, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000042', '180', '200', '5', 3, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000043', '200', '200', '5', 5, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000044', '120', '200', '10', 2, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000045', '160', '200', '10', 5, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000046', '180', '200', '10', 8, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000047', '200', '200', '10', 3, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000048', '120', '200', '15', 5, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000049', '160', '200', '15', 7, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000050', '180', '200', '15', 5, 'KD-0000444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000051', '200', '200', '15', 3, 'KD-0000444');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000052', '120', '200', '5', 2, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000053', '140', '200', '5', 3, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000054', '160', '200', '5', 5, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000055', '180', '200', '5', 3, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000056', '120', '200', '10', 7, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000057', '140', '200', '10', 9, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000058', '160', '200', '10', 2, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000059', '180', '200', '10', 8, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000060', '120', '200', '15', 9, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000061', '140', '200', '15', 6, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000062', '160', '200', '15', 9, 'KD-0000555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000063', '180', '200', '15', 6, 'KD-0000555');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000064', '120', '200', '5', 5, 'KD-0000666');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000065', '140', '200', '5', 3, 'KD-0000666');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000066', '160', '200', '5', 5, 'KD-0000666');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000067', '180', '200', '5', 7, 'KD-0000666');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000068', '120', '200', '10', 6, 'KD-0000666');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000069', '120', '200', '5', 5, 'KD-0000777');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000070', '140', '200', '5', 3, 'KD-0000777');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000071', '160', '200', '5', 5, 'KD-0000777');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000072', '180', '200', '5', 8, 'KD-0000777');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-0000073', '120', '200', '10', 7, 'KD-0000777');

-- Chi tiết giá
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (15000000, '2021-07-10', 'SP-0000001', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (15200000, '2021-08-15', 'SP-0000001', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (16300000, '2021-06-15', 'SP-0000002', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (16700000, '2021-08-15', 'SP-0000002', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (17530000, '2021-05-15', 'SP-0000003', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (17220000, '2021-08-15', 'SP-0000003', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18200000, '2021-05-30', 'SP-0000004', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18120000, '2021-08-15', 'SP-0000004', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18900000, '2021-05-27', 'SP-0000005', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18860000, '2021-08-15', 'SP-0000005', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (16860000, '2021-09-03', 'SP-0000006', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (17860000, '2021-09-03', 'SP-0000007', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18860000, '2021-09-03', 'SP-0000008', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (19860000, '2021-09-03', 'SP-0000009', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (20860000, '2021-09-03', 'SP-0000010', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (17860000, '2021-09-03', 'SP-0000011', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18860000, '2021-09-03', 'SP-0000012', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (19860000, '2021-09-03', 'SP-0000013', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (20860000, '2021-09-03', 'SP-0000014', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (21860000, '2021-09-03', 'SP-0000015', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18560000, '2021-09-03', 'SP-0000016', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (19460000, '2021-09-03', 'SP-0000017', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (20560000, '2021-09-03', 'SP-0000018', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (21060000, '2021-09-03', 'SP-0000019', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (22040000, '2021-09-03', 'SP-0000020', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (23160000, '2021-09-03', 'SP-0000021', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (18460000, '2021-09-03', 'SP-0000022', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (19510000, '2021-09-03', 'SP-0000023', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (20860000, '2021-09-03', 'SP-0000024', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (21690000, '2021-09-03', 'SP-0000025', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (21950000, '2021-09-03', 'SP-0000026', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (22430000, '2021-09-03', 'SP-0000027', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (19860000, '2021-09-03', 'SP-0000028', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (20860000, '2021-09-03', 'SP-0000029', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (21860000, '2021-09-03', 'SP-0000030', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (22860000, '2021-09-03', 'SP-0000031', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (23860000, '2021-09-03', 'SP-0000032', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (24860000, '2021-09-03', 'SP-0000033', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (25860000, '2021-09-03', 'SP-0000034', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (26860000, '2021-09-03', 'SP-0000035', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (27860000, '2021-09-03', 'SP-0000036', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (28860000, '2021-09-03', 'SP-0000037', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (29860000, '2021-09-03', 'SP-0000038', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (30860000, '2021-09-03', 'SP-0000039', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (31860000, '2021-09-03', 'SP-0000040', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (32860000, '2021-09-03', 'SP-0000041', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (34860000, '2021-09-03', 'SP-0000042', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (35860000, '2021-09-03', 'SP-0000043', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (36860000, '2021-09-03', 'SP-0000044', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (37860000, '2021-09-03', 'SP-0000045', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (38860000, '2021-09-03', 'SP-0000046', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (40860000, '2021-09-03', 'SP-0000047', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (41860000, '2021-09-03', 'SP-0000048', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (42860000, '2021-09-03', 'SP-0000049', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (43860000, '2021-09-03', 'SP-0000050', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (44860000, '2021-09-03', 'SP-0000051', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (45860000, '2021-09-03', 'SP-0000052', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (46860000, '2021-09-03', 'SP-0000053', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (47760000, '2021-09-03', 'SP-0000054', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (48860000, '2021-09-03', 'SP-0000055', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (49860000, '2021-09-03', 'SP-0000056', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (50860000, '2021-09-03', 'SP-0000057', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (51860000, '2021-09-03', 'SP-0000058', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (52860000, '2021-09-03', 'SP-0000059', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (53860000, '2021-09-03', 'SP-0000060', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (54660000, '2021-09-03', 'SP-0000061', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (55560000, '2021-09-03', 'SP-0000062', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (56860000, '2021-09-03', 'SP-0000063', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (45860000, '2021-09-03', 'SP-0000064', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (46860000, '2021-09-03', 'SP-0000065', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (47760000, '2021-09-03', 'SP-0000066', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (48860000, '2021-09-03', 'SP-0000067', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (49860000, '2021-09-03', 'SP-0000068', 'NV-0000001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (45860000, '2021-09-03', 'SP-0000069', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (46860000, '2021-09-03', 'SP-0000070', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (47760000, '2021-09-03', 'SP-0000071', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (48860000, '2021-09-03', 'SP-0000072', 'NV-0000001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values (49860000, '2021-09-03', 'SP-0000073', 'NV-0000001');

-- Khuyến mãi
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000111', 'Khuyến mãi đợt 1', 'Mừng ngày Quốc tế lao động', '2021-05-01', '2021-05-05', 'NV-0000001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000222', 'Khuyến mãi đợt 2', 'Mừng ngày của Mẹ', '2021-05-08', '2021-05-15', 'NV-0000002');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000333', 'Khuyến mãi đợt 3', 'Mừng ngày Quốc tế Thiếu Nhi', '2021-06-01', '2021-06-08', 'NV-0000001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000444', 'Khuyến mãi đợt 4', 'Khuyến mãi mùa CoVid', '2021-08-01', '2021-08-31', 'NV-0000002');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000555', 'Khuyến mãi đợt 5', 'Mừng ngày Quốc Khánh', '2021-09-01', '2021-09-22', 'NV-0000001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-0000666', 'Khuyến mãi đợt 6', 'Khuyến mãi hậu CoVid', '2021-09-23', '2021-10-23', 'NV-0000002');

-- Chi tiết khuyến mãi
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (25, 'KM-0000111', 'SP-0000001');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000111', 'SP-0000003');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000111', 'SP-0000004');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (5, 'KM-0000111', 'SP-0000005');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (20, 'KM-0000111', 'SP-0000006');

insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (11, 'KM-0000222', 'SP-0000011');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000222', 'SP-0000012');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (5, 'KM-0000222', 'SP-0000014');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000222', 'SP-0000015');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (7, 'KM-0000222', 'SP-0000016');

insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (9, 'KM-0000333', 'SP-0000022');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (17, 'KM-0000333', 'SP-0000023');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000333', 'SP-0000024');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (7, 'KM-0000333', 'SP-0000025');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000333', 'SP-0000026');

insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (25, 'KM-0000444', 'SP-0000001');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000444', 'SP-0000003');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000444', 'SP-0000004');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (5, 'KM-0000444', 'SP-0000005');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (20, 'KM-0000444', 'SP-0000006');

insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (25, 'KM-0000555', 'SP-0000001');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (21, 'KM-0000555', 'SP-0000003');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (20, 'KM-0000555', 'SP-0000005');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (17, 'KM-0000555', 'SP-0000007');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (9, 'KM-0000555', 'SP-0000015');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000555', 'SP-0000016');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (7, 'KM-0000555', 'SP-0000017');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (5, 'KM-0000555', 'SP-0000029');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000555', 'SP-0000030');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000555', 'SP-0000031');

insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (25, 'KM-0000666', 'SP-0000003');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (20, 'KM-0000666', 'SP-0000006');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (22, 'KM-0000666', 'SP-0000007');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000666', 'SP-0000009');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (9, 'KM-0000666', 'SP-0000011');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000666', 'SP-0000015');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (5, 'KM-0000666', 'SP-0000027');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000666', 'SP-0000031');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000666', 'SP-0000033');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (11, 'KM-0000666', 'SP-0000041');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000666', 'SP-0000045');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (22, 'KM-0000666', 'SP-0000049');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000666', 'SP-0000050');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (15, 'KM-0000666', 'SP-0000051');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (17, 'KM-0000666', 'SP-0000065');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (11, 'KM-0000666', 'SP-0000068');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (25, 'KM-0000666', 'SP-0000069');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (20, 'KM-0000666', 'SP-0000072');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values (10, 'KM-0000666', 'SP-0000073');

-- Đơn hàng
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42673487', 'Tiền mặt', 'Quảng Nam', '2021-04-09', '2021-04-15', 'Thanh Nhi', '0905689666', 'Hoàn tất', 1, 'NV-0000002', 'NVGH-00003');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42673499', 'PayPal', 'Quảng Ninh', '2021-04-20', '2021-04-28', 'Thanh Trúc', '0765606476', 'Hoàn tất', 2, 'NV-0000001', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42676531', 'Tiền mặt', 'Sài Gòn', '2021-05-11', '2021-05-18', 'Phuong Thanh', '0905222222', 'Hoàn tất', 2, 'NV-0000001', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675095', 'Tiền mặt', 'Sài Gòn', '2021-05-12', '2021-05-20', 'Phuong Trang', '0916952275', 'Hoàn tất', 1, 'NV-0000002', 'NVGH-00002');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675097', 'PayPal', 'Tiền Giang', '2021-06-21', '2021-06-28', 'Thanh Nhi', '0905666666', 'Hoàn tất', 1, 'NV-0000002', 'NVGH-00003');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675651', 'Tiền mặt', 'Kiên Giang', '2021-06-01', '2021-06-05', 'Song Nhi', '0956655665', 'Hoàn tất', 2, 'NV-0000001', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675085', 'Tiền mặt', 'Quảng Nam', '2021-06-30', '2021-07-03', 'Thanh Thao', '0935626999', 'Hoàn tất', 1, 'NV-0000002', 'NVGH-00002');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675088', 'PayPal', 'Quảng Nam', '2021-07-08', '2021-07-18', 'Trinh Nhan', '0969966575', 'Hoàn tất', 1, 'NV-0000002', 'NVGH-00003');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42675093', 'PayPal', 'Sài Gòn', '2021-07-24', '2021-07-31', 'Phuong Thanh', '0905222222', 'Hoàn tất', 2, 'NV-0000001', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH42676093', 'Tiền mặt', 'Đăk Lăk', '2021-08-24', '2021-08-29', 'Phuong Thao', '0905135661', 'Hoàn tất', 2, 'NV-0000001', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH40023690', 'PayPal', 'Đà Nẵng', '2021-09-01', '2021-09-03', 'Thanh Do', '0905994599', 'Đã phân công', 1, 'NV-0000002', 'NVGH-00003');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH40023691', 'Tiền mặt', 'Đà Nẵng', '2021-09-02', '2021-09-04', 'Khoi Nguyen', '0905999945', 'Đã phân công', 2, 'NV-0000002', 'NVGH-00002');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH40023695', 'Tiền mặt', 'Đà Lạt', '2021-09-02', '2021-09-05', 'Khoa Nguyen', '0905999969', 'Đã phân công', 2, 'NV-0000001', 'NVGH-00003');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH40023658', 'PayPal', 'Phan Thiết', '2021-09-03', '2021-09-07', 'Khai Nguyen', '0905999958', 'Đã phân công', 1, 'NV-0000001', 'NVGH-00002');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang, ma_nhan_vien, ma_nhan_vien_giao_hang) values ('DH40023635', 'PayPal', 'Đà Nẵng', '2021-09-08', '2021-09-09', 'Khoi Nguyen', '0905999927', 'Đã phân công', 1, 'NV-0000002', 'NVGH-00001');
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang) values ('DH20263406', 'Tiền mặt', 'Quảng Nam', '2021-09-02', '2021-10-09', 'Thanh Nhi', '0905666666', 'Chờ duyệt', 1);
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang) values ('DH32877125', 'Tiền mặt', 'Đà Nẵng', '2021-09-02', '2021-10-10', 'Khoi Nguyen', '0905999999', 'Chờ duyệt', 1);
insert into kymdan.don_hang(ma, cach_thanh_toan, dia_chi, ngay_dat, ngay_nhan, nguoi_nhan, so_dien_thoai, trang_thai, ma_khach_hang) values ('DH41208273', 'Tiền mặt', 'Đăk Lăk', '2021-09-03', '2021-10-11', 'Phuong Thao', '0905111111', 'Chờ duyệt', 2);

insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (14860000, 15, 'DH42673487', 'SP-0000001');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (14860000, 17, 'DH42676531', 'SP-0000001');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (15820000, 8, 'DH42675095', 'SP-0000003');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (17860000, 5, 'DH42675095', 'SP-0000005');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (16870000, 6, 'DH42675095', 'SP-0000007');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (15860000, 9, 'DH42675093', 'SP-0000006');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20500000, 3, 'DH42675093', 'SP-0000015');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20560000, 2, 'DH42676093', 'SP-0000024');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (28860000, 3, 'DH42676093', 'SP-0000038');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (17560000, 2, 'DH40023690', 'SP-0000022');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (45860000, 1, 'DH40023690', 'SP-0000055');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (50395000, 3, 'DH20263406', 'SP-0000058');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20632000, 3, 'DH20263406', 'SP-0000029');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (17860000, 1, 'DH32877125', 'SP-0000016');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (19460000, 2, 'DH41208273', 'SP-0000023');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (42860000, 3, 'DH42675097', 'SP-0000049');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (51860000, 3, 'DH42675097', 'SP-0000058'); 
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (17560000, 3, 'DH42673499', 'SP-0000022');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20500000, 3, 'DH40023658', 'SP-0000015');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20560000, 3, 'DH40023658', 'SP-0000024');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (14860000, 3, 'DH40023635', 'SP-0000001');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (51860000, 3, 'DH40023635', 'SP-0000058');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (16870000, 3, 'DH40023635', 'SP-0000007');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (28860000, 3, 'DH40023695', 'SP-0000038');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (51860000, 3, 'DH40023691', 'SP-0000058');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (44860000, 3, 'DH40023691', 'SP-0000051');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (31860000, 3, 'DH42675088', 'SP-0000040');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (32860000, 3, 'DH42675088', 'SP-0000041');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (20860000, 3, 'DH42675085', 'SP-0000014');
insert into kymdan.chi_tiet_don_hang(gia, so_luong, ma_don_hang, ma_san_pham) values (21860000, 3, 'DH42675651', 'SP-0000015');

-- Hóa đơn
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD43379802', '0042671234', '2021-04-11', 222900000, 'DH42673487', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD47176541', '0049176541', '2021-05-12', 252620000, 'DH42676531', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD42670123', '0044875095', '2021-06-24', 317080000, 'DH42675095', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD68547213', '0036598741', '2021-07-25', 204240000, 'DH42675093', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD95687432', '0063259874', '2021-08-29', 127700000, 'DH42676093', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD14568347', '0156321478', '2021-09-03', 80980000, 'DH40023690', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD21568398', '0556321475', '2021-08-25', 94720000, 'DH42675097', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD16568397', '0256321476', '2021-04-25', 17560000, 'DH42673499', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD32568396', '0956321469', '2021-09-05', 41060000, 'DH40023658', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD82568395', '0356321477', '2021-09-09', 83590000, 'DH40023635', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD71568394', '1056321470', '2021-09-04', 28860000, 'DH40023695', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD89568393', '9056321472', '2021-09-04', 50720000, 'DH40023691', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD95568392', '8056321475', '2021-07-15', 64720000, 'DH42675088', 'NV-0000001');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD34568391', '6156321459', '2021-07-02', 20860000, 'DH42675085', 'NV-0000002');
insert into kymdan.hoa_don(ma, ma_so_thue, ngay_tao, tong_tien, ma_don_hang, ma_nhan_vien) values ('HD52568586', '3556321454', '2021-06-03', 21860000, 'DH42675651', 'NV-0000002');


DELIMITER //
CREATE PROCEDURE loc_chi_tiet_don_hang()
BEGIN
	select * from chi_tiet_don_hang 
		where ma_don_hang in (
			select ma from don_hang where datediff(now(), don_hang.ngay_dat) < 30 and trang_thai = 'Hoàn tất'
    );
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE xem_loai_moi()
BEGIN
	select * from loai_san_pham
		where datediff(now(), loai_san_pham.ngay_tao) < 30
		order by ngay_tao desc limit 5;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE kiem_tra_san_pham(san_pham char(10))
BEGIN
	select ma from chi_tiet_don_hang
		where ma_san_pham = san_pham;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE thong_ke(ngay_bat_dau date, ngay_ket_thuc date)
BEGIN
	select sum(tong_tien) as doanh_thu, ngay_tao as ngay 
		from hoa_don
        where ngay_tao >= ngay_bat_dau and ngay_tao <= ngay_ket_thuc
        and ma_don_hang in ( select ma from don_hang where trang_thai = 'Hoàn tất' )
		group by ngay
        order by ngay;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE chon_san_pham_khuyen_mai(khuyen_mai char(10))
BEGIN
	select ma from san_pham
		where ma not in (
			select ma_san_pham from chi_tiet_khuyen_mai where ma_khuyen_mai = khuyen_mai
        );
END //
DELIMITER ;