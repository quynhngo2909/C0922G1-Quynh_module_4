package com.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 45, nullable = false, unique = true)
    private String name;
    @Column(name = "cost", nullable = false)
    private double cost;
    @Column(name = "unit", length = 10, nullable = false)
    private String unit;
    @Column(name = "status", length = 45, nullable = false)
    private String status;
    @Column(name = "is_Expired", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExpired = false;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, double cost, String unit, String status, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}

