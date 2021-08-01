package com.kymdan.backend.controllers;

import com.kymdan.backend.config.JwtTokenUtil;
import com.kymdan.backend.entity.AppAccount;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.CurrentAccountDTO;
import com.kymdan.backend.model.LoginDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.services.account.AppAccountService;
import com.kymdan.backend.services.account.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AppAccountService appAccountService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginRequest) throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        AppAccount account = appAccountService.findByUsername(username);

        // check account
        if (account == null || !bcryptEncoder.matches(password, account.getPassword())) {
            return ResponseEntity.ok(new MessageDTO("Thông tin đăng nhập không hợp lệ !"));
        }

        authenticate(username, password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        Long id = account.getId();
        String role = account.getAppRole().getRoleName();
        String fullName;

        switch (role) {
            case "Employee":
                fullName = account.getEmployee().getFullName();
                break;
            case "Shipper":
                fullName = account.getShipper().getFullName();
                break;
            default:
                fullName = account.getCustomer().getFullName();
        }

        return ResponseEntity.ok(new CurrentAccountDTO(id, username, token, fullName, role));
    }

    // method that do the authentication process
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/information/{name}/{role}")
    public ResponseEntity<?> getInformationByName(@PathVariable String name, @PathVariable String role) {
        switch (role) {
            case "Employee":
                return new ResponseEntity<>(this.appAccountService.findEmployeeByName(name), HttpStatus.OK);
            case "Shipper":
                return new ResponseEntity<>(this.appAccountService.findShipperByName(name), HttpStatus.OK);
            default:
                return new ResponseEntity<>(this.appAccountService.findCustomerByName(name), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/edit-information")
    public ResponseEntity<?> editInformation(@RequestBody AppUserDTO appUserDTO) {
        return ResponseEntity.ok(appAccountService.editInformation(appUserDTO));
    }

    @GetMapping("/edit-password/{username}/{oldPassword}/{newPassword}")
    public ResponseEntity<?> editPassword(@PathVariable String username, @PathVariable String oldPassword,
                                          @PathVariable String newPassword) {
        return ResponseEntity.ok(appAccountService.editPassword(username, oldPassword, newPassword));
    }
}
