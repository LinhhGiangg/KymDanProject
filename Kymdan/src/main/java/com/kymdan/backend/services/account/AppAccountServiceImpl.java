package com.kymdan.backend.services.account;

import com.kymdan.backend.entity.AppAccount;
import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.entity.Employee;
import com.kymdan.backend.entity.Shipper;
import com.kymdan.backend.model.AccountDTO;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class AppAccountServiceImpl implements AppAccountService {

    @Autowired
    private AppAccountRepository appAccountRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public MessageDTO save(AccountDTO accountDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Customer newCustomer = new Customer();
            newCustomer.setFullName(accountDTO.getUsername());
            newCustomer.setGender(accountDTO.getAppUser().getGender());
            newCustomer.setBirthday(accountDTO.getAppUser().getBirthday().plusDays(1));
            newCustomer.setAddress(accountDTO.getAppUser().getAddress());
            newCustomer.setPhone(accountDTO.getAppUser().getPhone());
            newCustomer.setEmail(accountDTO.getAppUser().getEmail());
            this.customerRepository.save(newCustomer);

            AppAccount newAccount = new AppAccount();
            newAccount.setAppRole(appRoleRepository.findByRoleName("Customer"));
            newAccount.setUsername(accountDTO.getUsername());
            newAccount.setPassword(bcryptEncoder.encode(accountDTO.getPassword()));
            newAccount.setCustomer(this.customerRepository.findByFullName(accountDTO.getUsername()));
            this.appAccountRepository.save(newAccount);

            messageDTO.setMessage("Đăng ký tài khoản thành công !");
            sendEmailForCustomer(accountDTO);
        } catch (Exception e) {
            messageDTO.setMessage("Lỗi hệ thống ! Vui lòng thử lại sau !");
        }

        return messageDTO;
    }

    private void sendEmailForCustomer(AccountDTO accountDTO) throws MessagingException {
        MimeMessage message = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String nameCustomer = accountDTO.getUsername();

        helper.setTo(accountDTO.getAppUser().getEmail());
        helper.setSubject("Đăng kí tài khoản thành công !");

        String mailContent = "<!DOCTYPE html>\n" +
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
                "      <p>Kính gửi quý khách: <span>" + nameCustomer + "</span></p>\n" +
                "      <p> Quý khách đã đăng kí tài khoản thành công! </p>\n" +
                "      <p> Cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! </p>\n" +
                "      <p> Trân trọng! </p>\n" +
                "       <img src=\"https://iweb.tatthanh.com.vn/pic/3/blog/images/logo-cong-ty-nem-2.jpg" +
                "       \" style=\"width: 100%\">\n" +
                "      </div>" +
                "    <div class=\"col-sm-3\"></div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "      <p class=\"autoMail\">P/s : Đây là thư thông báo tự động. " +
                "      Quý khách vui lòng không trả lời thư này!</p>\n" +
                "</body>\n" +
                "</html>\n";
        helper.setText(mailContent, true);
        this.emailSender.send(message);
    }

    @Override
    public AppAccount findByUsername(String username) {
        return this.appAccountRepository.findByUsername(username);
    }

    @Override
    public Customer findCustomerByName(String name) {
        return this.customerRepository.findByFullName(name);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return this.employeeRepository.findByFullName(name);
    }

    @Override
    public Shipper findShipperByName(String name) {
        return this.shipperRepository.findByFullName(name);
    }

    @Override
    public MessageDTO editInformation(AppUserDTO appUserDTO) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            if (appUserDTO.getRole().equals("Customer")) {
                Customer customer = this.customerRepository.findByEmail(appUserDTO.getEmail());
                if (!appUserDTO.getBirthday().equals(customer.getBirthday())) {
                    customer.setBirthday(appUserDTO.getBirthday().plusDays(1));
                }
                customer.setAddress(appUserDTO.getAddress());
                customer.setPhone(appUserDTO.getPhone());
                this.customerRepository.save(customer);
            } else if (appUserDTO.getRole().equals("Shipper")) {
                Shipper shipper = this.shipperRepository.findByEmail(appUserDTO.getEmail());
                if (!appUserDTO.getBirthday().equals(shipper.getBirthday())) {
                    shipper.setBirthday(appUserDTO.getBirthday().plusDays(1));
                }
                shipper.setAddress(appUserDTO.getAddress());
                shipper.setPhone(appUserDTO.getPhone());
                this.shipperRepository.save(shipper);
            }
            else {
                Employee employee = this.employeeRepository.findByEmail(appUserDTO.getEmail());
                if (!appUserDTO.getBirthday().equals(employee.getBirthday())) {
                    employee.setBirthday(appUserDTO.getBirthday().plusDays(1));
                }
                employee.setAddress(appUserDTO.getAddress());
                employee.setPhone(appUserDTO.getPhone());
                this.employeeRepository.save(employee);
            }

            messageDTO.setMessage("Sửa thông tin tài khoản thành công !");
        } catch (Exception e) {
            messageDTO.setMessage("Lỗi hệ thống ! Vui lòng thử lại sau !");
        }

        return messageDTO;
    }

    @Override
    public MessageDTO editPassword(String username, String oldPassword, String newPassword) {
        MessageDTO messageDTO = new MessageDTO();
        AppAccount account = findByUsername(username);

        if (bcryptEncoder.matches(oldPassword, account.getPassword())) {
            account.setPassword(bcryptEncoder.encode(newPassword));
            this.appAccountRepository.save(account);
            messageDTO.setMessage("Thay đổi mật khẩu thành công !");
        } else {
            messageDTO.setMessage("Sai mật khẩu ! Vui lòng thử lại sau !");
        }

        return messageDTO;
    }
}
