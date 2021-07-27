package com.kymdan.backend.services.customer;

import com.kymdan.backend.entity.Customer;
import com.kymdan.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }
}
