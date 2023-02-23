package com.casestudy.service.impl;

import com.casestudy.entity.ContractDetail;
import com.casestudy.repository.IContractDetailRepository;
import com.casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> getContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);

    }
    @Override
    public ContractDetail findContractDetail(int id) {
        return contractDetailRepository.findById(id).get();
    }

}
