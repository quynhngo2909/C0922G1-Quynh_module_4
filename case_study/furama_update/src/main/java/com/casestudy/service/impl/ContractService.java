package com.casestudy.service.impl;

import com.casestudy.entity.Contract;
import com.casestudy.repository.IContractRepository;
import com.casestudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<Contract> findContractByCustomerEmployeeFacility(String customerName, String employeeName,String facilityName, Pageable pageable) {
        return contractRepository.findContractByCustomerEmployeeFacility(customerName, employeeName, facilityName, pageable);
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findContractByCustomer(String customerName, Pageable pageable) {
        return contractRepository.findContractByCustomer(customerName, pageable);
    }

    @Override
    public Page<Contract> findContract(Pageable pageable) {
        return contractRepository.findContract(pageable);
    }
}
