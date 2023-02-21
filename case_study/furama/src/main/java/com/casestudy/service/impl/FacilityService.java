package com.casestudy.service.impl;

import com.casestudy.entity.Facility;
import com.casestudy.repository.IFacilityRepository;
import com.casestudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> findFacilityByNameType(String name, String facilityName, Pageable pageable) {
        return facilityRepository.findFacilityByNameType(name, facilityName, pageable);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }


    @Override
    public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void deleteFacility(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Integer findFacilityIdByName(String name) {
        return facilityRepository.findFacilityIdByName(name);
    }
}
