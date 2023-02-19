package com.casestudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class AppUser {
    @Id
    @Column(name = "username", length = 255, nullable = false)
    private String username;
    @Column(name = "password", length = 255, nullable = false)
    @JsonIgnore
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(mappedBy = "appUser")
    private Set<UserRole> userRoles;

    public AppUser() {
    }

    public AppUser(String username, String password, Employee employee, Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}