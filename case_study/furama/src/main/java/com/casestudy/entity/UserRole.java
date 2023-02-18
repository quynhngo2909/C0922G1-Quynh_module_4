package com.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private AppUser appUser;

    public UserRole() {
    }

    public UserRole(int id, AppRole appRole, AppUser appUser) {
        this.id = id;
        this.appRole = appRole;
        this.appUser = appUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
