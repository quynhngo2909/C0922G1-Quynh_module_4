package com.casestudy.service.impl;

import com.casestudy.entity.CustomerType;
import com.casestudy.repository.ICustomerTypeRepository;
import com.casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> customerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void saveCusType(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void deleteCusType(int id) {
        customerTypeRepository.deleteById(id);
    }
}
