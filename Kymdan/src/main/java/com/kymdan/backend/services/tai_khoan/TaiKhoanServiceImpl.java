package com.kymdan.backend.services.tai_khoan;

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
            newAccount.setQuyen(quyenRepository.findByTen("Khách Hàng"));
            newAccount.setTenDangNhap(taiKhoanDTO.getTenDangNhap());
            newAccount.setMatKhau(bcryptEncoder.encode(taiKhoanDTO.getMatKhau()));
            newAccount.setKhachHang(this.khachHangRepository.findByTen(taiKhoanDTO.getTenDangNhap()));
            this.taiKhoanRepository.save(newAccount);

            thongBaoDTO.setThongBao("Đăng ký tài khoản thành công !");
            goiEmailChoKhachHang(taiKhoanDTO);
        } catch (Exception e) {
            thongBaoDTO.setThongBao("Lỗi hệ thống ! Vui lòng thử lại sau !");
        }

        return thongBaoDTO;
    }

    private void goiEmailChoKhachHang(TaiKhoanDTO taiKhoanDTO) throws MessagingException {
        MimeMessage noiDung = this.emailSender.createMimeMessage();
        MimeMessageHelper hoTro = new MimeMessageHelper(noiDung, true, "utf-8");
        String tenKhachHang = taiKhoanDTO.getTenDangNhap();

        hoTro.setTo(taiKhoanDTO.getThongTinDTO().getEmail());
        hoTro.setSubject("Đăng kí tài khoản thành công !");

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
                "      <p>Kính gửi quý khách: <span>" + tenKhachHang + "</span></p>\n" +
                "      <p> Quý khách đã đăng kí tài khoản thành công! </p>\n" +
                "      <p> Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! </p>\n" +
                "      <p> Trân trọng! </p>\n" +
                "       <img src=\"https://iweb.tatthanh.com.vn/pic/3/blog/images/logo-cong-ty-nem-2.jpg" +
                "       \" style=\"width: 50%\">\n" +
                "      </div>" +
                "    <div class=\"col-sm-3\"></div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "      <p class=\"autoMail\">P/s : Đây là thư thông báo tự động. " +
                "      Quý khách vui lòng không trả lời thư này!</p>\n" +
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
            if (thongTinDTO.getQuyen().equals("Khách Hàng")) {
                KhachHang khachHang = this.khachHangRepository.findByEmail(thongTinDTO.getEmail());
                if (!thongTinDTO.getNgaySinh().equals(khachHang.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("có thay đổi")) {
                    khachHang.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                khachHang.setDiaChi(thongTinDTO.getDiaChi());
                khachHang.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.khachHangRepository.save(khachHang);
            } else if (thongTinDTO.getQuyen().equals("Nhân Viên Giao Hàng")) {
                NhanVienGiaoHang nhanVienGiaoHang = this.nhanVienGiaoHangRepository.findByEmail(thongTinDTO.getEmail());
                if (!thongTinDTO.getNgaySinh().equals(nhanVienGiaoHang.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("có thay đổi")) {
                    nhanVienGiaoHang.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                nhanVienGiaoHang.setDiaChi(thongTinDTO.getDiaChi());
                nhanVienGiaoHang.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.nhanVienGiaoHangRepository.save(nhanVienGiaoHang);
            }
            else {
                NhanVien nhanVien = this.nhanVienRepository.findByEmail(thongTinDTO.getEmail());
                System.out.println(thongTinDTO.getNgaySinh());
                if (!thongTinDTO.getNgaySinh().equals(nhanVien.getNgaySinh())
                        || thongTinDTO.getGioiTinh().equals("có thay đổi")) {
                    nhanVien.setNgaySinh(thongTinDTO.getNgaySinh().plusDays(1));
                }
                nhanVien.setDiaChi(thongTinDTO.getDiaChi());
                nhanVien.setSoDienThoai(thongTinDTO.getSoDienThoai());
                this.nhanVienRepository.save(nhanVien);
            }

            thongBaoDTO.setThongBao("Sửa thông tin tài khoản thành công !");
        } catch (Exception e) {
            thongBaoDTO.setThongBao("Lỗi hệ thống ! Vui lòng thử lại sau !");
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
            thongBaoDTO.setThongBao("Thay đổi mật khẩu thành công !");
        } else {
            thongBaoDTO.setThongBao("Sai mật khẩu ! Vui lòng thử lại sau !");
        }

        return thongBaoDTO;
    }
}
