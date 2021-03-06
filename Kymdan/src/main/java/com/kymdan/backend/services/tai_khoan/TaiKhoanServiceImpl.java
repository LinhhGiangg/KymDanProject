package com.kymdan.backend.services.tai_khoan;

import com.kymdan.backend.config.TaoMaNgauNhien;
import com.kymdan.backend.entity.TaiKhoan;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.entity.NhanVien;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.TaiKhoanDTO;
import com.kymdan.backend.model.ThongTinDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private QuyenRepository quyenRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienGiaoHangRepository nhanVienGiaoHangRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public ThongBaoDTO taoTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        ThongBaoDTO thongBaoDTO = new ThongBaoDTO();

        try {
            KhachHang khachHangMoi = new KhachHang();
            khachHangMoi.setTen(taiKhoanDTO.getTenDangNhap());
            khachHangMoi.setGioiTinh(taiKhoanDTO.getThongTinDTO().getGioiTinh());
            khachHangMoi.setNgaySinh(taiKhoanDTO.getThongTinDTO().getNgaySinh().plusDays(1));
            khachHangMoi.setDiaChi(taiKhoanDTO.getThongTinDTO().getDiaChi());
            khachHangMoi.setSoDienThoai(taiKhoanDTO.getThongTinDTO().getSoDienThoai());
            khachHangMoi.setEmail(taiKhoanDTO.getThongTinDTO().getEmail());
            this.khachHangRepository.save(khachHangMoi);

            TaiKhoan newAccount = new TaiKhoan();
            newAccount.setQuyen(quyenRepository.findByTen("Kh??ch H??ng"));
            newAccount.setTenDangNhap(taiKhoanDTO.getTenDangNhap());
            newAccount.setMatKhau(bcryptEncoder.encode(taiKhoanDTO.getMatKhau()));
            newAccount.setKhachHang(this.khachHangRepository.findByTen(taiKhoanDTO.getTenDangNhap()));
            this.taiKhoanRepository.save(newAccount);

            thongBaoDTO.setThongBao("????ng k?? t??i kho???n th??nh c??ng !");
            goiEmailChoKhachHang(taiKhoanDTO);
        } catch (Exception e) {
            thongBaoDTO.setThongBao("L???i h??? th???ng ! Vui l??ng th??? l???i sau !");
        }

        return thongBaoDTO;
    }

    private void goiEmailChoKhachHang(TaiKhoanDTO taiKhoanDTO) throws MessagingException {
        MimeMessage noiDung = this.emailSender.createMimeMessage();
        MimeMessageHelper hoTro = new MimeMessageHelper(noiDung, true, "utf-8");
        String tenKhachHang = taiKhoanDTO.getTenDangNhap();

        hoTro.setTo(taiKhoanDTO.getThongTinDTO().getEmail());
        hoTro.setSubject("????ng k?? t??i kho???n th??nh c??ng !");

        String tieuDe = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Mail</title>\n" +
                "  <style>\n" +
                "    * {\n" +
                "      font-family: \"Varela Round\";\n" +
                "    }" +
                "    .bodyMail {\n" +
                "      margin-top: 1%;\n" +
                "    }\n" +
                "\n" +
                "    p {\n" +
                "      margin: 1% 0;\n" +
                "    }\n" +
                "\n" +
                "    span {\n" +
                "      color: blue;\n" +
                "    }\n" +
                "\n" +
                "    .autoMail {\n" +
                "      color: red;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container-fluid\">\n" +
                "  <div class=\"row\">\n" +
                "    <div class=\"col-sm-3\"></div>\n" +
                "    <div class=\"col-sm-6 bodyMail\">\n" +
                "<div>\n" +
                "      <p>K??nh g???i qu?? kh??ch: <span>" + tenKhachHang + "</span></p>\n" +
                "      <p> Qu?? kh??ch ???? ????ng k?? t??i kho???n th??nh c??ng! </p>\n" +
                "      <p> C???m ??n qu?? kh??ch ???? s??? d???ng d???ch v??? c???a ch??ng t??i! </p>\n" +
                "      <p> Tr??n tr???ng! </p>\n" +
                "       <img src=\"https://iweb.tatthanh.com.vn/pic/3/blog/images/logo-cong-ty-nem-2.jpg" +
                "       \" style=\"width: 50%\">\n" +
                "      </div>" +
                "    <div class=\"col-sm-3\"></div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "      <p class=\"autoMail\">P/s : ????y l?? th?? th??ng b??o t??? ?????ng. " +
                "      Qu?? kh??ch vui l??ng kh??ng tr??? l???i th?? n??y!</p>\n" +
                "</body>\n" +
                "</html>\n";
        hoTro.setText(tieuDe, true);
        this.emailSender.send(noiDung);
    }

    @Override
    public TaiKhoan timBangTenDangNhap(String tenDangNhap) {
        List<TaiKhoan> tatCaTaiKhoan = this.taiKhoanRepository.findAll();
        for (TaiKhoan taiKhoan : tatCaTaiKhoan) {
            if (taiKhoan.getTenDangNhap().equals(tenDangNhap)) {
                return taiKhoan;
            }
        }
        return null;
    }

    @Override
    public KhachHang timKhachHangBangTen(String ten) {
        return this.khachHangRepository.findByTen(ten);
    }

    @Override
    public NhanVien timNhanVienBangTen(String ten) {
        return this.nhanVienRepository.findByTen(ten);
    }

    @Override
    public NhanVienGiaoHang timNhanVienGiaoHangBangTen(String ten) {
        return this.nhanVienGiaoHangRepository.findByTen(ten);
    }

    @Override
    public ThongBaoDTO suaThongTin(ThongTinDTO thongTinDTO) {
        ThongBaoDTO thongBaoDTO = new ThongBaoDTO();

        try {
            if (thongTinDTO.getQuyen().equals("Kh??ch H??ng")) {
                KhachHang khachHang = this.khachHangRepository.findByEmail(thongTinDTO.getEmail());
                if (!thongTinDTO.getNgaySinh().equals(khachHang.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("c?? thay ?????i")) {
                    khachHang.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                khachHang.setDiaChi(thongTinDTO.getDiaChi());
                khachHang.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.khachHangRepository.save(khachHang);
            } else if (thongTinDTO.getQuyen().equals("Nh??n Vi??n Giao H??ng")) {
                NhanVienGiaoHang nhanVienGiaoHang = this.nhanVienGiaoHangRepository.findByEmail(thongTinDTO.getEmail());
                if (!thongTinDTO.getNgaySinh().equals(nhanVienGiaoHang.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("c?? thay ?????i")) {
                    nhanVienGiaoHang.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                nhanVienGiaoHang.setDiaChi(thongTinDTO.getDiaChi());
                nhanVienGiaoHang.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.nhanVienGiaoHangRepository.save(nhanVienGiaoHang);
            }
            else {
                NhanVien nhanVien = this.nhanVienRepository.findByEmail(thongTinDTO.getEmail());
                if (!thongTinDTO.getNgaySinh().equals(nhanVien.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("c?? thay ?????i")) {
                    nhanVien.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                nhanVien.setDiaChi(thongTinDTO.getDiaChi());
                nhanVien.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.nhanVienRepository.save(nhanVien);
            }

            thongBaoDTO.setThongBao("S???a th??ng tin t??i kho???n th??nh c??ng !");
        } catch (Exception e) {
            thongBaoDTO.setThongBao("L???i h??? th???ng ! Vui l??ng th??? l???i sau !");
        }

        return thongBaoDTO;
    }

    @Override
    public ThongBaoDTO suaMatKhau (String tenDangNhap, String matKhauCu, String matKhauMoi) {
        ThongBaoDTO thongBaoDTO = new ThongBaoDTO();
        TaiKhoan taiKhoan = timBangTenDangNhap(tenDangNhap);

        if (bcryptEncoder.matches(matKhauCu, taiKhoan.getMatKhau())) {
            taiKhoan.setMatKhau(bcryptEncoder.encode(matKhauMoi));
            this.taiKhoanRepository.save(taiKhoan);
            thongBaoDTO.setThongBao("Thay ?????i m???t kh???u th??nh c??ng !");
        } else {
            thongBaoDTO.setThongBao("Sai m???t kh???u ! Vui l??ng th??? l???i sau !");
        }

        return thongBaoDTO;
    }

    @Override
    public ThongBaoDTO layMatKhau(String mail) throws MessagingException {
        KhachHang khachHang = this.khachHangRepository.findByEmail(mail);

        if (khachHang != null) {
            String matKhauMoi = TaoMaNgauNhien.tao(6);
            TaiKhoan taiKhoan = this.taiKhoanRepository.findByTenDangNhap(khachHang.getTen());
            if (taiKhoan != null) {
                taiKhoan.setMatKhau(bcryptEncoder.encode(matKhauMoi));
                this.taiKhoanRepository.save(taiKhoan);
            }

            MimeMessage noiDung = this.emailSender.createMimeMessage();
            MimeMessageHelper hoTro = new MimeMessageHelper(noiDung, true, "utf-8");
            hoTro.setTo(mail);
            hoTro.setSubject("C???p nh???t m???t kh???u m???i !");
            String tieuDe = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "  <title>Mail</title>\n" +
                    "  <style>\n" +
                    "    * {\n" +
                    "      font-family: \"Varela Round\";\n" +
                    "    }" +
                    "    .bodyMail {\n" +
                    "      margin-top: 1%;\n" +
                    "    }\n" +
                    "\n" +
                    "    p {\n" +
                    "      margin: 1% 0;\n" +
                    "    }\n" +
                    "\n" +
                    "    span {\n" +
                    "      color: blue;\n" +
                    "    }\n" +
                    "\n" +
                    "    .autoMail {\n" +
                    "      color: red;\n" +
                    "    }\n" +
                    "  </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"container-fluid\">\n" +
                    "  <div class=\"row\">\n" +
                    "    <div class=\"col-sm-3\"></div>\n" +
                    "    <div class=\"col-sm-6 bodyMail\">\n" +
                    "<div>\n" +
                    "      <p>K??nh g???i qu?? kh??ch: <span>" + khachHang.getTen() + "</span></p>\n" +
                    "      <p> M???t kh???u m???i c???a qu?? kh??ch l?? : <span>" + matKhauMoi + "</span></p>\n" +
                    "      <p> Qu?? kh??ch vui l??ng ?????i m???t kh???u sau khi ????ng nh???p ????? ?????m b???o t??nh b???o m???t! </p>\n" +
                    "      <p> C???m ??n qu?? kh??ch ???? s??? d???ng d???ch v??? c???a ch??ng t??i! </p>\n" +
                    "      <p> Tr??n tr???ng! </p>\n" +
                    "       <img src=\"https://iweb.tatthanh.com.vn/pic/3/blog/images/logo-cong-ty-nem-2.jpg" +
                    "       \" style=\"width: 50%\">\n" +
                    "      </div>" +
                    "    <div class=\"col-sm-3\"></div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "      <p class=\"autoMail\">P/s : ????y l?? th?? th??ng b??o t??? ?????ng. " +
                    "      Qu?? kh??ch vui l??ng kh??ng tr??? l???i th?? n??y!</p>\n" +
                    "</body>\n" +
                    "</html>\n";
            hoTro.setText(tieuDe, true);
            this.emailSender.send(noiDung);

            return new ThongBaoDTO("M???t kh???u m???i ???? ???????c g???i v??? mail c???a qu?? kh??ch !");
        } else return new ThongBaoDTO("Mail n??y ch??a ???????c ????ng k?? !");
    }
}
