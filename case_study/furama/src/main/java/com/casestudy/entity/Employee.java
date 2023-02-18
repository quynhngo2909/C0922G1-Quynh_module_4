package com.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "birthday", length = 10, nullable = false)
    private String birthday;
    @Column(name = "id_card", length = 45, nullable = false)
    private String idCard;
    @Column(name = "salary", nullable = false)
    private double salary;
    @Column(name = "phone_number", length = 45, nullable = false)
    private String phoneNumber;
    @Column(name = "email", length = 45, nullable = false)
    private String email;
    @Column(name = "address", length = 45, nullable = false)
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private PositionEmployee positionEmployee;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id", nullable = false)
    private Division division;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "id", nullable = false)
    private AppUser user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String phoneNumber, String email, String address, PositionEmployee positionEmployee, EducationDegree educationDegree, Division division, AppUser user) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.positionEmployee = positionEmployee;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public PositionEmployee getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(PositionEmployee positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}

