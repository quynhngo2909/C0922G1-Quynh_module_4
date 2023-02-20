package com.casestudy.service;

import com.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findCustomerByNameEmail(String name, String email, Pageable pageable);
    void saveCustomer(Customer customer);
    void deleteCustomer(int id);

//    Page<Customer> findCustomerByNameContaining(String name, Pageable pageable);
}

