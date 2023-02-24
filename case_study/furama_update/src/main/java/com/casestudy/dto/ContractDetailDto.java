package com.casestudy.dto;

import com.casestudy.entity.AttachFacility;
import com.casestudy.entity.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class ContractDetailDto implements Validator {

    private int id;
    private int quantity = 1;
    private Contract contract;
    private AttachFacility attachFacility;

    public ContractDetailDto(int id, int quantity, Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public ContractDetailDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        int quantity = contractDetailDto.quantity;
        if(contractDetailDto.getAttachFacility().getId() == null){
            errors.rejectValue("id", "ctrDetail.qty", "Please select attach facility.");
        }
        if(quantity < 1) {
            errors.rejectValue("quantity","ctrDetail.qty","Quantity must be equal or bigger than 1.");
        }
    }
}

