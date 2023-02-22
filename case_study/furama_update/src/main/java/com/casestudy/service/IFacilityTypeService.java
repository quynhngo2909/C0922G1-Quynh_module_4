package com.casestudy.service;

import com.casestudy.entity.Facility;
import com.casestudy.entity.FacilityType;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> facilityTypes();
    void saveFacilityType(FacilityType facilityType);
    void deleteFacilityType(int id);
    List<Integer> findFacilityTypeByName(String name);
}
