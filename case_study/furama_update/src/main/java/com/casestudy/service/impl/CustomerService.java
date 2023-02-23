package com.casestudy.service.impl;

import com.casestudy.entity.Customer;
import com.casestudy.repository.ICustomerRepository;
import com.casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomerByNameEmail(String name, String email, String customerTypename, Pageable pageable) {
        return customerRepository.findCustomerByNameEmail(name, email, customerTypename, pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void setExpiredCustomer(int id) {
        customerRepository.setExpiredCustomer(id);
    }

    @Override
    public Integer getCustomerIDByIdCardEmailPhoneNumber(String idCard, String email, String phoneNumber) {
        return customerRepository.getCustomerIDByIdCardEmailPhoneNumber(idCard, email, phoneNumber);
    }

    @Override
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}
