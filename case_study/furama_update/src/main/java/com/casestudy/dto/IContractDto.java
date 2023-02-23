package com.casestudy.dto;

import com.casestudy.entity.Customer;
import com.casestudy.entity.Employee;
import com.casestudy.entity.Facility;

public interface IContractDto {

    int getId();

    String getStartDate();

    String getEndDate();

    double getDeposit();

    double getTotalCost();

    String getEmployee();

    String getCustomer();

    String getFacility();
}
