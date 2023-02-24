package com.casestudy.dto;

import com.casestudy.entity.AttachFacility;
import com.casestudy.entity.Customer;
import com.casestudy.entity.Employee;
import com.casestudy.entity.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import java.time.LocalDate;


public class ContractDto implements Validator {
    private int id;

    private double deposit;
    private String startDate;
    private String endDate;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private AttachFacility attachFacility;
    private int attFacilityQty;

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

    public ContractDto(int id, double deposit, String startDate, String endDate, Customer customer, Employee employee, Facility facility, AttachFacility attachFacility, int attFacilityQty) {
        this.id = id;
        this.deposit = deposit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.attachFacility = attachFacility;
        this.attFacilityQty = attFacilityQty;
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

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getAttFacilityQty() {
        return attFacilityQty;
    }

    public void setAttFacilityQty(int attFacilityQty) {
        this.attFacilityQty = attFacilityQty;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ContractDto contractDto = new ContractDto();
//        LocalDate startDate = LocalDate.parse(contractDto.startDate);
//        LocalDate endDate = LocalDate.parse(contractDto.endDate);
//        LocalDate today = LocalDate.now();
//
//        if(startDate.isBefore(today)){
//            errors.rejectValue("startDate","contract.startDate","Start date must be after current date and before end date");
//        }
//        if(endDate.isBefore(startDate)){
//            errors.rejectValue("endDate", "contract.endDate", "End date must be after start date");
//        }
    }
}



