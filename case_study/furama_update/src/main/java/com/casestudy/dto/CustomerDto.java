package com.casestudy.dto;

import com.casestudy.entity.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerDto  implements Validator {
    private int id;
    private String name;
    private String birthday;
    private Boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String birthday, Boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String name = customerDto.getName();
        if (!name.matches("^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*)*$")) {
            errors.rejectValue("name", "customerName.Format",
                    "First character of each word must be capitalized. And no number included");
        }

        String phoneNumber = customerDto.phoneNumber;
        if(!phoneNumber.matches("^090[0-9]{7}|091[0-9]{7}|\\(84\\)\\+90[0-9]{7}|\\(84\\)\\+91[0-9]{7}$")){
            errors.rejectValue("phoneNumber", "cusPhoneNumber.format",
                    "090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx.");
        }

        String idCard = customerDto.idCard;
        if(!idCard.matches("^[0-9]{9}|[0-9]{12}$")){
            errors.rejectValue("idCard", "cusIdCard.format",
                    "XXXXXXXXX or XXXXXXXXXXXX (X is a number: 0-9).");
        }

        String email  = customerDto.email;
        if(!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)+$")){
            errors.rejectValue("email", "cusEmail.format");
        }
    }
}
