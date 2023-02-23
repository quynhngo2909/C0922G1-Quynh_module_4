package com.casestudy.service;

import com.casestudy.entity.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> getContractDetail();
    void saveContractDetail(ContractDetail contractDetail);
    ContractDetail findContractDetail(int id);
}
