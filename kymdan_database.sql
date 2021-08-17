use kymdan;

insert into kymdan.quyen (ma, ten) values (1, 'Nhân Viên');
insert into kymdan.quyen (ma, ten) values (2, 'Nhân Viên Giao Hàng');
insert into kymdan.quyen (ma, ten) values (3, 'Khách Hàng');

insert into kymdan.nhan_vien (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (1, 'HLG', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'linhgiang58999@gmail.com');
insert into kymdan.nhan_vien_giao_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (1, 'Shipper', 'Nam', '1999-05-30', 'Sài Gòn', '0905111111', 'shipper@gmail.com');
insert into kymdan.khach_hang (ma, ten, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, email) values (1, 'SPJ', 'Nam', '1995-05-27', 'Quảng Nam', '0905999999', 'supea@gmail.com');

insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien) values (1, 'HLG', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 1, 1);
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_nhan_vien_giao_hang) values (2, 'Shipper', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 2, 1);
insert into kymdan.tai_khoan (ma, ten_dang_nhap, mat_khau, ma_quyen, ma_khach_hang) values (3, 'SPJ', '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 3, 1);

insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-111', 'Nệm (mattress) KYMDAN Deluxe', 'assets/sanPham11.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® được NASA công nhận,Giúp giảm đau tại các điểm chịu lực,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', 500, '2021-08-11');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-222', 'Nệm (mattress) KYMDAN UltimateCare', 'assets/sanPham12.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Chất liệu TEMPUR® nâng đỡ cơ thể,Công nghệ Dynamic Support tăng khả năng đàn hồi,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', 100, '2021-08-07');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-333', 'Nệm (mattress) KYMDAN Deluxe Premium', 'assets/sanPham15.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Ứng dụng công nghệ hiện đại PuroTex,Tích hợp 3 lớp cao su đặc biệt,Lớp phủ sinh học Nanobiotic', 150, '2021-08-05');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-444', 'Nệm (mattress) KYMDAN Massage', 'assets/sanPham16.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Nâng đỡ 5 vùng cơ thể,Độ thoáng khí tốt,Lõi nệm kháng khuẩn', 250, '2021-08-07');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-555', 'Nệm (mattress) KYMDAN Y Tế', 'assets/sanPham17.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Công nghệ HourGlass Support® độc quyền,Lớp Memory Foam có độ bền cao', 350, '2021-08-05');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-666', 'Nệm (mattress) KYMDAN Premium', 'assets/sanPham1.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Lõi nệm kháng khuẩn,Lớp Memory Foam có độ bền cao', 0, '2021-08-11');
insert into kymdan.loai_san_pham (ma, ten, hinh1, hinh2, hinh3, mo_ta, luot_xem, ngay_tao) values ('KD-777', 'Nệm (mattress) KYMDAN Royal', 'assets/sanPham5.jpg', 'assets/sanPham6.jpg', 'assets/sanPham7.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Chống dị ứng,Lớp Memory Foam có độ bền cao', 0, '2021-08-11');

insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-001', '120', '200', '5', '15000000', '5', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-002', '140', '200', '5', '16460000', '4', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-003', '160', '200', '5', '17140000', '2', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-004', '180', '200', '5', '18300000', '12', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-005', '200', '200', '5', '19120000', '5', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-006', '120', '200', '10', '15820000', '2', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-007', '140', '200', '10', '16925000', '3', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-008', '160', '200', '10', '17650000', '5', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-009', '180', '200', '10', '18760000', '8', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-010', '200', '200', '10', '19450000', '4', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-011', '120', '200', '15', '16420000', '5', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-012', '140', '200', '15', '1726000', '1', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-014', '160', '200', '15', '18730000', '10', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-015', '180', '200', '15', '19350000', '15', '8', 'KD-111');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-016', '200', '200', '15', '21080000', '1', '8', 'KD-111');

insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-022', '120', '200', '5', '25000000', '5', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-023', '140', '200', '5', '26460000', '4', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-024', '160', '200', '5', '27140000', '2', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-025', '180', '200', '5', '28300000', '12', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-026', '120', '200', '10', '25820000', '2', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-027', '140', '200', '10', '26925000', '3', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-028', '160', '200', '10', '27650000', '5', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-029', '180', '200', '10', '28760000', '8', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-030', '120', '200', '15', '26420000', '5', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-031', '140', '200', '15', '2726000', '1', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-032', '160', '200', '15', '28730000', '10', '8', 'KD-222');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-033', '180', '200', '15', '29350000', '15', '8', 'KD-222');

insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-038', '120', '200', '5', '35000000', '8', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-039', '140', '200', '5', '37140000', '3', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-040', '160', '200', '5', '38300000', '5', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-041', '200', '200', '5', '39120000', '16', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-042', '120', '200', '10', '36925000', '3', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-043', '140', '200', '10', '37650000', '4', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-044', '160', '200', '10', '38760000', '6', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-045', '200', '200', '10', '39450000', '7', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-046', '120', '200', '15', '3726000', '6', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-047', '140', '200', '15', '38730000', '4', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-048', '160', '200', '15', '39350000', '12', '8', 'KD-333');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-049', '200', '200', '15', '41080000', '10', '8', 'KD-333');

insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-055', '120', '200', '5', '45000000', '5', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-056', '160', '200', '5', '47140000', '2', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-057', '180', '200', '5', '48300000', '12', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-058', '200', '200', '5', '49120000', '5', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-059', '120', '200', '10', '45820000', '2', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-060', '160', '200', '10', '47650000', '5', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-061', '180', '200', '10', '48760000', '8', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-062', '200', '200', '10', '49450000', '4', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-063', '120', '200', '15', '46420000', '5', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-064', '160', '200', '15', '48730000', '10', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-065', '180', '200', '15', '49350000', '15', '8', 'KD-444');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-066', '200', '200', '15', '51080000', '1', '8', 'KD-444');

insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-071', '120', '200', '5', '55000000', '1', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-072', '140', '200', '5', '56460000', '3', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-073', '160', '200', '5', '57140000', '5', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-074', '180', '200', '5', '58300000', '12', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-075', '120', '200', '10', '55820000', '7', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-076', '140', '200', '10', '56925000', '9', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-077', '160', '200', '10', '57650000', '2', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-078', '180', '200', '10', '58760000', '8', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-079', '120', '200', '15', '56420000', '4', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-080', '140', '200', '15', '5726000', '6', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-081', '160', '200', '15', '58730000', '10', '8', 'KD-555');
insert into kymdan.san_pham(ma, rong, dai, cao, gia, so_luong, giam_gia, ma_loai_san_pham) values ('SP-082', '180', '200', '15', '59350000', '15', '8', 'KD-555');
