package com.casestudy.dto;

import com.casestudy.entity.Customer;
import com.casestudy.entity.Employee;
import com.casestudy.entity.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class ContractDto implements Validator {
    private int id;


    private double deposit;


    private String startDate;

    private String endDate;


    private Customer customer;

    private Employee employee;

    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(int id, double deposit, String startDate, String endDate, Customer customer, Employee employee, Facility facility) {
        this.id = id;
        this.deposit = deposit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}



