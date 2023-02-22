package com.casestudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 45, nullable = false, unique = true)
    private String name;
    @Column(name = "area",nullable = false)
    private Integer area;
    @Column(name = "cost",nullable = false)
    private Double cost;
    @Column(name = "max_people",nullable = false)
    private Integer maxPeople;
    @Column(name = "standard_room", length = 45, nullable = false)
    private String standardRoom;
    @Column(name = "description_other_convenience", length = 45, nullable = false)
    private String descriptionOtherConvenience;
    @Column(name = "pool_are")
    private Double poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloor;
    @Column(name = "facility_free")
    private String facilityFree;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "id", nullable = false)
    private FacilityType facilityType;

    @Column(name = "is_Expired", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExpired = false;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public Facility() {
    }

    public Facility(Integer id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloor, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
