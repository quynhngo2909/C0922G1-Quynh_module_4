package com.casestudy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "birthday", length = 10, nullable = false)
    private String birthday;
    @Column(name = "gender", length = 1, nullable = false)
    private Boolean gender;
    @Column(name = "id_card", length = 45, nullable = false, unique = true)
    private String idCard;
    @Column(name = "phone_number", length = 45, nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "email", length = 45, nullable = false, unique = true)
    private String email;
    @Column(name = "address", length = 45, nullable = false)
    private String address;

    @ManyToOne()
    @JoinColumn(name = "customer_type", referencedColumnName = "id", nullable = false)
    private CustomerType customerType;

    @Column(name = "is_Expired", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExpired = false;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }

    public Customer(int id, String name, String birthday, Boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
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
}
