package com.casestudy.service.impl;

import com.casestudy.entity.Customer;
import com.casestudy.repository.ICustomerRepository;
import com.casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerByNameEmail(String name, String email, Pageable pageable) {
        return customerRepository.findCustomerByNameEmail(name, email, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

//    @Override
//    public Page<Customer> findCustomerByNameContaining(String name, Pageable pageable) {
//        return customerRepository.findCustomerByNameContaining(name, pageable);
//    }
}
