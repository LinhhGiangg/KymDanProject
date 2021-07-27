package com.kymdan.backend.services.customer;

import com.kymdan.backend.entity.Customer;

public interface CustomerService {
    Customer findByEmail(String email);
}
