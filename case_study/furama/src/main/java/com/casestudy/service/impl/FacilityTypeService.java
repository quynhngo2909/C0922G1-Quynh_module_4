package com.casestudy.service.impl;

import com.casestudy.entity.FacilityType;
import com.casestudy.repository.IFacilityTypeRepository;
import com.casestudy.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> facilityTypes() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public void saveFacilityType(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void deleteFacilityType(int id) {
        facilityTypeRepository.deleteById(id);
    }

    @Override
    public List<Integer> findFacilityTypeByName(String name) {
        return facilityTypeRepository.findFacilityTypeByName(name);
    }
}
