package com.casestudy.service;

import com.casestudy.dto.ContractDto;
import com.casestudy.dto.IContractDto;
import com.casestudy.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService {
    public Page<Contract> findContractByCustomerEmployeeFacility(String customerName, String employeeName,
                                                                 String facilityName, Pageable pageable);
    void saveContract(Contract contract);
    Page<Contract> findContractByCustomer(String customerName,
                                          Pageable pageable);
    Page<Contract> findContract(Pageable pageable);

    Contract findContractById(int id);
    Page<IContractDto> getContractDtos(String customerName, String employeeName, String facilityName, Pageable pageable);
}
