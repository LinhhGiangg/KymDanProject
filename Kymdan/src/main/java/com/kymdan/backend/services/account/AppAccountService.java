package com.kymdan.backend.services.account;

import com.kymdan.backend.entity.AppAccount;
import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.entity.Employee;
import com.kymdan.backend.model.AccountDTO;
import com.kymdan.backend.model.AppUserDTO;
import com.kymdan.backend.model.MessageDTO;

public interface AppAccountService {
    MessageDTO save(AccountDTO accountDTO);

    AppAccount findByUsername(String username);

    Customer findCustomerByName(String name);

    Employee findEmployeeByName(String name);

    MessageDTO editInformation(AppUserDTO appUserDTO);

    MessageDTO editPassword(String username, String oldPassword, String newPassword);
}
