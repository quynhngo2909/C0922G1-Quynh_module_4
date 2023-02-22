package com.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private int id;
    @Column(name = "role_name", length = 255, nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "appRole")
    private Set<UserRole> userRoles;

    public AppRole() {
    }

    public AppRole(int id, String name, Set<UserRole> userRoles) {
        this.id = id;
        this.name = name;
        this.userRoles = userRoles;
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
