use kymdan;

# role
insert into kymdan.app_role (id, role_name) values (1, 'Employee');
insert into kymdan.app_role (id, role_name) values (2, 'Shipper');
insert into kymdan.app_role (id, role_name) values (3, 'Customer');

# employee, customer
insert into kymdan.employee (id, full_name, gender, birthday, address, phone, email) values (1, 'HLG', 'Nữ', '1999-08-05', 'Đăk Lăk', '0769555555', 'linhgiang05081999@gmail.com');
insert into kymdan.shipper (id, full_name, gender, birthday, address, phone, email) values (1, 'Shipper', 'Nam', '1999-05-30', 'Sài Gòn', '0905111111', 'shipper@gmail.com');
insert into kymdan.customer (id, full_name, gender, birthday, address, phone, email) values (1, 'SPJ', 'Nam', '1995-05-27', 'Quảng Nam', '0905999999', 'supea@gmail.com');

# account
insert into kymdan.app_account (id, `password`, username, app_role_id, employee_id) values (1, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'HLG', 1, 1);
insert into kymdan.app_account (id, `password`, username, app_role_id, shipper_id) values (2, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'Shipper', 2, 1);
insert into kymdan.app_account (id, `password`, username, app_role_id, customer_id) values (3, '$2a$10$9JSTCvzf.qJkKZui25Nj8uHSp.x3LxcyN9MfWqo8ilU7g8VLn2Fkq', 'SPJ', 3, 1);

# product type
insert into kymdan.product_type (id, type_name, image1, image2, image3, `description`, price) values (1, 'Nệm (mattress) KYMDAN Deluxe', 'https://vuanem.com/image/products/1264/280/QFwfaB9Uz9pK6RyO41cmcIUk7Gy8YCP7GBZGgT65.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg', 'Chất liệu TEMPUR® được NASA công nhận,Giúp giảm đau tại các điểm chịu lực,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', '15000000');
insert into kymdan.product_type (id, type_name, image1, image2, image3, `description`, price) values (2, 'Nệm (mattress) KYMDAN UltimateCare', 'https://vuanem.com/image/products/1189/280/EZImH32ZfdxEimGSojOS2k3ZoL9wFGeD4SRl9u9E.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg', 'Chất liệu TEMPUR® nâng đỡ cơ thể,Công nghệ Dynamic Support tăng khả năng đàn hồi,Công nghệ CoolTouch™ giúp vỏ nệm luôn mát mẻ', '25000000');
insert into kymdan.product_type (id, type_name, image1, image2, image3, `description`, price) values (3, 'Nệm (mattress) KYMDAN Deluxe Premium', 'https://vuanem.com/image/products/1081/280/qxuJhNv9yIdCPA7XsM71a1mXtGRPnqmRfFX6l8qQ.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg', 'Ứng dụng công nghệ hiện đại PuroTex,Tích hợp 3 lớp cao su đặc biệt,Lớp phủ sinh học Nanobiotic', '35000000');
insert into kymdan.product_type (id, type_name, image1, image2, image3, `description`, price) values (4, 'Nệm (mattress) KYMDAN Massage', 'https://vuanem.com/image/products/1138/280/N1yTNI98S8FDkk9fWqV3IXmufvGylTXvqnzRmTzP.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg', 'Nâng đỡ 5 vùng cơ thể,Độ thoáng khí tốt,Lõi nệm kháng khuẩn, chống dị ứng', '45000000');
insert into kymdan.product_type (id, type_name, image1, image2, image3, `description`, price) values (5, 'Nệm (mattress) KYMDAN Y Tế', 'https://vuanem.com/image/products/1015/280/NJ2hYIuRk0UkQNeNvThfsguwUst6EYOdnHd4jj6x.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6542/nem_kymdan_deluxe_02.jpg', 'https://www.kymdan.com/attachment.do?file=attachment/6140/nem%20kymdan%20deluxe.jpg', 'Hỗ trợ thêm 3 vùng trọng điểm của cơ thể,Công nghệ HourGlass Support® độc quyền,Lớp Memory Foam có độ bền cao', '55000000');

# product
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (1, '120', '200', '5', '15000000', '5', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (2, '140', '200', '5', '16460000', '4', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (3, '160', '200', '5', '17140000', '2', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (4, '180', '200', '5', '18300000', '12', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (5, '200', '200', '5', '19120000', '5', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (6, '120', '200', '10', '15820000', '2', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (7, '140', '200', '10', '16925000', '3', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (8, '160', '200', '10', '17650000', '5', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (9, '180', '200', '10', '18760000', '8', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (10, '200', '200', '10', '19450000', '4', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (11, '120', '200', '15', '16420000', '5', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (12, '140', '200', '15', '1726000', '1', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (13, '160', '200', '15', '18730000', '10', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (14, '180', '200', '15', '19350000', '15', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (15, '200', '200', '15', '21080000', '1', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (16, '120', '200', '20', '17360000', '6', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (17, '140', '200', '20', '19250000', '7', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (18, '160', '200', '20', '20290000', '5', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (19, '180', '200', '20', '22670000', '3', '8', 1);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (20, '200', '200', '20', '24560000', '1', '8', 1);

insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (21, '120', '200', '5', '25000000', '5', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (22, '140', '200', '5', '26460000', '4', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (23, '160', '200', '5', '27140000', '2', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (24, '180', '200', '5', '28300000', '12', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (25, '120', '200', '10', '25820000', '2', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (26, '140', '200', '10', '26925000', '3', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (27, '160', '200', '10', '27650000', '5', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (28, '180', '200', '10', '28760000', '8', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (29, '120', '200', '15', '26420000', '5', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (30, '140', '200', '15', '2726000', '1', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (31, '160', '200', '15', '28730000', '10', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (32, '180', '200', '15', '29350000', '15', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (33, '120', '200', '20', '27360000', '6', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (34, '140', '200', '20', '29250000', '7', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (35, '160', '200', '20', '30290000', '5', '8', 2);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (36, '180', '200', '20', '32670000', '3', '8', 2);

insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (37, '120', '200', '5', '35000000', '8', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (38, '140', '200', '5', '37140000', '3', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (39, '160', '200', '5', '38300000', '5', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (40, '200', '200', '5', '39120000', '16', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (41, '120', '200', '10', '36925000', '3', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (42, '140', '200', '10', '37650000', '4', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (43, '160', '200', '10', '38760000', '6', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (44, '200', '200', '10', '39450000', '7', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (45, '120', '200', '15', '3726000', '6', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (46, '140', '200', '15', '38730000', '4', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (47, '160', '200', '15', '39350000', '12', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (48, '200', '200', '15', '41080000', '10', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (49, '120', '200', '20', '39250000', '4', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (50, '140', '200', '20', '40290000', '5', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (51, '160','200', '20', '42670000', '8', '8', 3);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (52, '200', '200', '20', '44560000', '1', '8', 3);

insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (53, '120', '200', '5', '45000000', '5', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (54, '160', '200', '5', '47140000', '2', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (55, '180', '200', '5', '48300000', '12', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (56, '200', '200', '5', '49120000', '5', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (57, '120', '200', '10', '45820000', '2', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (58, '160', '200', '10', '47650000', '5', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (59, '180', '200', '10', '48760000', '8', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (60, '200', '200', '10', '49450000', '4', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (61, '120', '200', '15', '46420000', '5', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (62, '160', '200', '15', '48730000', '10', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (63, '180', '200', '15', '49350000', '15', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (64, '200', '200', '15', '51080000', '1', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (65, '120', '200', '20', '47360000', '6', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (66, '160', '200', '20', '50290000', '5', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (67, '180', '200', '20', '52670000', '3', '8', 4);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (68, '200', '200', '20', '54560000', '1', '8', 4);

insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (69, '120', '200', '5', '55000000', '1', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (70, '140', '200', '5', '56460000', '3', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (71, '160', '200', '5', '57140000', '5', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (72, '180', '200', '5', '58300000', '12', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (73, '120', '200', '10', '55820000', '7', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (74, '140', '200', '10', '56925000', '9', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (75, '160', '200', '10', '57650000', '2', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (76, '180', '200', '10', '58760000', '8', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (77, '120', '200', '15', '56420000', '4', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (78, '140', '200', '15', '5726000', '6', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (79, '160', '200', '15', '58730000', '10', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (80, '180', '200', '15', '59350000', '15', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (81, '120', '200', '20', '57360000', '5', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (82, '140', '200', '20', '59250000', '8', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (83, '160', '200', '20', '60290000', '5', '8', 5);
insert into kymdan.product(id, `length`, width, thick, price, amount, discount, product_type_id) values (84, '180', '200', '20', '62670000', '3', '8', 5);
