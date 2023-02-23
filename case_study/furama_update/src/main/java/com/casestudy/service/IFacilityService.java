package com.casestudy.service;

import com.casestudy.entity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findFacilityByNameType(String name, String facilityName, Pageable pageable);
    Facility findById(int id);
    void saveFacility(Facility facility);
    void deleteFacility(int id);
    Integer findFacilityIdByName(String name);
    void setExpired( int id);
    List<Facility> facilities();
}

