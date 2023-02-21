package com.casestudy.dto;

import com.casestudy.entity.FacilityType;
import com.casestudy.entity.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Size;


public class FacilityDto implements Validator {
    private Integer id;

    @Size(max = 45, message = "Facility's name must be not over 45 alphanumeric characters")
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    @Size(max = 45, message = "Description must not over 45 alphanumeric characters")
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, RentType rentType, FacilityType facilityType) {
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

    public void setId(Integer id) {
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

    public void setCost(Double cost) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        String name = facilityDto.getName();
        if (!name.matches("^[A-Z][A-Za-z0-9]*(\\s[A-Z][A-Za-z0-9]*)*$")) {
            errors.rejectValue("name", "facilityName.Format",
                    "First character of each word must be capitalized!");
        }
        Integer area = facilityDto.getArea();
        if(area < 0) {
            errors.rejectValue("area", "facilityArea.NegativeValue",
                    "Must be a positive number");
        }
        Double  cost = facilityDto.getCost();
        if(cost < 0) {
            errors.rejectValue("cost", "facilityCost.NegativeValue",
                    "Must be a positive number");
        }
        Integer maxPeople = facilityDto.getMaxPeople();
        if(maxPeople < 0) {
            errors.rejectValue("maxPeople", "maxPeople.NegativeValue",
                    "Must be a positive number");
        }
        Double  poolArea = facilityDto.getPoolArea();
        if(poolArea < 0) {
            errors.rejectValue("poolArea", "facilityPoolArea.NegativeValue",
                    "Must be a positive number");
        }
        Integer numberOfFloor = facilityDto.getNumberOfFloor();
        if(numberOfFloor < 0) {
            errors.rejectValue("numberOfFloor", "facilityNumberOfFloor.NegativeValue",
                    "Must be a positive number");
        }
    }
}
