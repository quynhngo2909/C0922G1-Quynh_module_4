package com.casestudy.service;

import com.casestudy.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService{
    List<CustomerType> customerTypes();
    void saveCusType(CustomerType customerType);
    void deleteCusType(int id);
}
