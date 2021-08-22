use kymdan;

-- Quyền
insert into kymdan.quyen (ma, ten) values (1, 'Nhân Viên');
insert into kymdan.quyen (ma, ten) values (2, 'Nhân Viên Giao Hàng');
insert into kymdan.quyen (ma, ten) values (3, 'Khách Hàng');

-- Nhân viên, Nhân viên giao hàng, Khách hàng
insert into kymdan.nhan_vien (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values ('NV-001', 'Linh Giang', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'linhgiang58999@gmail.com');
insert into kymdan.nhan_vien (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values ('NV-002', 'Nhan Vien', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'gianglinh58999@gmail.com');
insert into kymdan.nhan_vien_giao_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email, ten_cong_ty) values ('NVGH-001', 'Shipper', 'Nam', '1999-05-30', 'Sài Gòn', '0905111111', 'shipper@gmail.com', 'Grab');
insert into kymdan.khach_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (1, 'Khach Hang', 'Nam', '1995-05-27', 'Quảng Nam', '0905999999', 'supea@gmail.com');

-- Tài khoản
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien) values (1, 'Linh Giang', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 1, 'NV-001');
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien_giao_hang) values (2, 'Shipper', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 2, 'NVGH-001');
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_khach_hang) values (3, 'Khach Hang', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 3, 1);
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien) values (5, 'Nhan Vien', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 1, 'NV-002');

-- Loại sản phẩm
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-111', 'Nệm (mattress) KYMDAN Deluxe', 'assets/sanPham11.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® được NASA công nhận,Giúp giảm đau tại các điểm chịu lực,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', 500, '2021-08-11');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-222', 'Nệm (mattress) KYMDAN UltimateCare', 'assets/sanPham12.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® nâng đỡ cơ thể,Công nghệ Dynamic Support tăng khả năng đàn hồi,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', 100, '2021-08-07');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-333', 'Nệm (mattress) KYMDAN Deluxe Premium', 'assets/sanPham15.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Ứng dụng công nghệ hiện đại PuroTex,Tích hợp 3 lớp cao su đặc biệt,Lớp phủ sinh học Nanobiotic', 150, '2021-08-05');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-444', 'Nệm (mattress) KYMDAN Massage', 'assets/sanPham16.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Nâng đỡ 5 vùng cơ thể,Độ thoáng khí tốt,Lõi nệm kháng khuẩn', 250, '2021-08-07');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-555', 'Nệm (mattress) KYMDAN Y Tế', 'assets/sanPham17.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Công nghệ HourGlass Support® độc quyền,Lớp Memory Foam có độ bền cao', 350, '2021-08-05');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-666', 'Nệm (mattress) KYMDAN Premium', 'assets/sanPham1.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Lõi nệm kháng khuẩn,Lớp Memory Foam có độ bền cao', 0, '2021-08-11');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-777', 'Nệm (mattress) KYMDAN Royal', 'assets/sanPham5.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Chống dị ứng,Lớp Memory Foam có độ bền cao', 0, '2021-08-11');

-- Sản phẩm
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-001', '120', '200', '5', '5', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-002', '140', '200', '5', '4', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-003', '160', '200', '5', '2', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-004', '180', '200', '5', '12', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-005', '200', '200', '5', '5', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-006', '120', '200', '10', '2', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-007', '140', '200', '10', '3', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-008', '160', '200', '10', '5', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-009', '180', '200', '10', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-010', '200', '200', '10', '4', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-011', '120', '200', '15', '5', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-012', '140', '200', '15', '1', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-014', '160', '200', '15', '10', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-015', '180', '200', '15', '15', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-016', '200', '200', '15', '1', 'KD-111');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-022', '120', '200', '5', '5', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-023', '140', '200', '5', '4', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-024', '160', '200', '5', '2', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-025', '180', '200', '5', '12', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-026', '120', '200', '10', '2', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-027', '140', '200', '10', '3', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-028', '160', '200', '10', '5', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-029', '180', '200', '10', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-030', '120', '200', '15', '5', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-031', '140', '200', '15', '1', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-032', '160', '200', '15', '10', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-033', '180', '200', '15', '15', 'KD-222');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-038', '120', '200', '5', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-039', '140', '200', '5', '3', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-040', '160', '200', '5', '5', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-041', '200', '200', '5', '16', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-042', '120', '200', '10', '3', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-043', '140', '200', '10', '4', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-044', '160', '200', '10', '6', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-045', '200', '200', '10', '7', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-046', '120', '200', '15', '6', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-047', '140', '200', '15', '4', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-048', '160', '200', '15', '12', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-049', '200', '200', '15', '10', 'KD-333');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-055', '120', '200', '5', '5', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-056', '160', '200', '5', '2', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-057', '180', '200', '5', '12', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-058', '200', '200', '5', '5', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-059', '120', '200', '10', '2', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-060', '160', '200', '10', '5', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-061', '180', '200', '10', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-062', '200', '200', '10', '4', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-063', '120', '200', '15', '5', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-064', '160', '200', '15', '10', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-065', '180', '200', '15', '15', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-066', '200', '200', '15', '1', 'KD-444');

insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-071', '120', '200', '5', '1', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-072', '140', '200', '5', '3', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-073', '160', '200', '5', '5', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-074', '180', '200', '5', '12', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-075', '120', '200', '10', '7', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-076', '140', '200', '10', '9', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-077', '160', '200', '10', '2', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-078', '180', '200', '10', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-079', '120', '200', '15', '4', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-080', '140', '200', '15', '6', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-081', '160', '200', '15', '10', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, so_luong, ma_loai_san_pham) values ('SP-082', '180', '200', '15', '15', 'KD-555');

-- Chi tiết giá
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('15000000', '2021-03-27', 'SP-001', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('15200000', '2021-05-29', 'SP-001', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('16300000', '2021-04-25', 'SP-002', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('16700000', '2021-05-28', 'SP-002', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('17530000', '2021-01-30', 'SP-003', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('17220000', '2021-03-04', 'SP-003', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18200000', '2021-05-30', 'SP-004', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18120000', '2021-06-27', 'SP-004', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18900000', '2020-05-27', 'SP-005', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18860000', '2020-11-28', 'SP-005', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('16860000', '2020-11-28', 'SP-006', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('17860000', '2020-11-28', 'SP-007', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18860000', '2020-11-28', 'SP-008', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('19860000', '2020-11-28', 'SP-009', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('20860000', '2020-11-28', 'SP-010', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('17860000', '2021-05-23', 'SP-011', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18860000', '2020-11-28', 'SP-012', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('19860000', '2020-11-28', 'SP-014', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('20860000', '2020-11-28', 'SP-015', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('21860000', '2020-11-28', 'SP-016', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18560000', '2021-08-12', 'SP-022', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('19460000', '2021-08-12', 'SP-023', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('20560000', '2021-08-12', 'SP-024', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('21060000', '2021-08-12', 'SP-025', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('22040000', '2021-08-12', 'SP-026', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('23160000', '2021-08-12', 'SP-027', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('18460000', '2021-08-12', 'SP-028', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('19510000', '2021-08-12', 'SP-029', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('20860000', '2021-08-12', 'SP-030', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('21690000', '2021-08-12', 'SP-031', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('21950000', '2021-08-12', 'SP-032', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('22430000', '2021-08-12', 'SP-033', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('19860000', '2021-02-25', 'SP-038', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('20860000', '2021-02-25', 'SP-039', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('21860000', '2021-02-25', 'SP-040', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('22860000', '2021-02-25', 'SP-041', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('23860000', '2021-02-25', 'SP-042', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('24860000', '2021-02-25', 'SP-043', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('25860000', '2021-02-25', 'SP-044', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('26860000', '2021-02-25', 'SP-045', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('27860000', '2021-02-25', 'SP-046', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('28860000', '2021-02-25', 'SP-047', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('29860000', '2021-02-25', 'SP-048', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('30860000', '2021-02-25', 'SP-049', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('31860000', '2020-11-28', 'SP-055', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('32860000', '2020-11-28', 'SP-056', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('34860000', '2020-11-28', 'SP-057', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('35860000', '2020-11-28', 'SP-058', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('36860000', '2020-11-28', 'SP-059', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('37860000', '2020-11-28', 'SP-060', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('38860000', '2020-11-28', 'SP-061', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('40860000', '2020-11-28', 'SP-062', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('41860000', '2020-11-28', 'SP-063', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('42860000', '2020-11-28', 'SP-064', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('43860000', '2020-11-28', 'SP-065', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('44860000', '2020-11-28', 'SP-066', 'NV-001');

insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('45860000', '2020-11-28', 'SP-071', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('46860000', '2020-11-28', 'SP-072', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('47760000', '2020-11-28', 'SP-073', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('48860000', '2020-11-28', 'SP-074', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('49860000', '2020-11-28', 'SP-075', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('50860000', '2020-11-28', 'SP-076', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('51860000', '2020-11-28', 'SP-077', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('52860000', '2020-11-28', 'SP-078', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('53860000', '2020-11-28', 'SP-079', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('54660000', '2020-11-28', 'SP-080', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('55560000', '2020-11-28', 'SP-081', 'NV-001');
insert into kymdan.chi_tiet_gia(gia, ngay_thay_doi, ma_san_pham, ma_nhan_vien) values ('56860000', '2020-11-28', 'SP-082', 'NV-001');

-- Khuyến mãi
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-111', 'Khuyến mãi đợt 1', 'Mừng ngày Quốc tế lao động', '2021-05-01', '2021-05-05', 'NV-001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-222', 'Khuyến mãi đợt 2', 'Mừng ngày của Mẹ', '2021-05-08', '2021-05-15', 'NV-001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-333', 'Khuyến mãi đợt 3', 'Mừng ngày Quốc tế Thiếu Nhi', '2021-06-01', '2021-06-08', 'NV-001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-555', 'Khuyến mãi đợt 5', 'Khuyến mãi mùa CoVid', '2021-08-01', '2021-08-28', 'NV-001');
insert into kymdan.khuyen_mai(ma, ten, mo_ta, ngay_bat_dau, ngay_ket_thuc, ma_nhan_vien) values ('KM-666', 'Khuyến mãi đợt 6', 'Mừng ngày Quốc Khánh', '2021-09-01', '2021-09-05', 'NV-001');

-- Chi tiết khuyến mãi
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('5', 'KM-555', 'SP-001');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-002');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-555', 'SP-003');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-005');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-555', 'SP-006');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-041');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-042');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-043');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-044');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('10', 'KM-111', 'SP-045');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-011');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-012');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-014');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-015');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-016');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-055');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-056');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-057');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('15', 'KM-222', 'SP-058');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-022');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-023');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-024');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-025');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-026');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-061');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-062');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-063');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-064');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('9', 'KM-333', 'SP-065');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-027');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-028');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-029');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-030');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-031');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-071');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-072');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-073');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-074');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('25', 'KM-555', 'SP-075');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-007');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-008');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-009');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-010');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-076');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-077');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-078');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-079');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-080');
insert into kymdan.chi_tiet_khuyen_mai(giam_gia, ma_khuyen_mai, ma_san_pham) values ('20', 'KM-666', 'SP-081');

-- Giỏ hàng
insert into kymdan.gio_hang(ma, ma_khach_hang) values (1, 1);
insert into kymdan.chi_tiet_gio_hang(so_luong, trang_thai, ma_gio_hang, ma_san_pham) values ('3', 'Chưa đặt', 1, 'SP-001');
insert into kymdan.chi_tiet_gio_hang(so_luong, trang_thai, ma_gio_hang, ma_san_pham) values ('1', 'Chưa đặt', 1, 'SP-022');
insert into kymdan.chi_tiet_gio_hang(so_luong, trang_thai, ma_gio_hang, ma_san_pham) values ('2', 'Chưa đặt', 1, 'SP-045');