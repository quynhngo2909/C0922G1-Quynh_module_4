package com.ss08.validation_registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;
    @NotNull(message = "FirstName must be filled in")
    @Size(min = 5, max = 45,message = "FirstName must be from 5 to 45 alphanumeric characters")
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDto() {
    }


    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Min(18)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String lastName = userDto.getLastName();
        if(lastName.length() < 5 || lastName.length() > 45) {
            errors.rejectValue("lastName", "lastName.length", "Last name must be from 5 to 45 alphanumeric characters.");
        } else if(!lastName.matches("^([A-Z]+[a-z]*)(\\s[A-Z]+[a-z]*)*$")){
            errors.rejectValue("lastName", "lastName.matches", "Last name must be from 5 to 45 alphanumeric characters.");
        }

        String phoneNumber = userDto.getPhoneNumber();
        if(!phoneNumber.matches("^(090)[0-9]{7}$")){
            errors.rejectValue("phoneNumber","phoneNumber.matches","Phone number must be in format: 090xxxxxxx");
        }
        String email = userDto.getEmail();
        if(!email.matches("^[a-zA-Z0-9]+@[a-z]+(.[a-z]+)+$")){
            errors.rejectValue("email","email.matches","Invalid email");
        }
    }
}
