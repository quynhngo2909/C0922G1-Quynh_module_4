package com.casestudy.service;

import com.casestudy.entity.Contract;
import com.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    Page<Customer> findCustomerByNameEmail(String name, String email, String customerTypename, Pageable pageable);
    void saveCustomer(Customer customer);
    Customer findCustomerById(int id);
    void deleteCustomer(int id);

    void setExpiredCustomer(int id);
    Integer getCustomerIDByIdCardEmailPhoneNumber(String idCard, String email, String phoneNumber);


}

