package com.kymdan.backend.controllers;

import com.kymdan.backend.model.AccountDTO;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.services.account.AppAccountService;
import com.kymdan.backend.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AppAccountService appAccountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewCustomer(@RequestBody AccountDTO accountDTO) {
        if (appAccountService.findByUsername(accountDTO.getUsername()) != null) {
            return ResponseEntity.ok(new MessageDTO("Tên đăng nhập này đã được đăng kí ! Vui lòng điền tên đăng nhập khác !"));
        } else if (customerService.findByEmail(accountDTO.getAppUser().getEmail()) != null) {
            return ResponseEntity.ok(new MessageDTO("Email này đã được đăng kí ! Vui lòng nhập email khác !"));
        } else {
            return ResponseEntity.ok(appAccountService.save(accountDTO));
        }
    }
}
