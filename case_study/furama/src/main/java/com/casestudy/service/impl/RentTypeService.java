package com.casestudy.service.impl;

import com.casestudy.entity.FacilityType;
import com.casestudy.entity.RentType;
import com.casestudy.repository.IFacilityTypeRepository;
import com.casestudy.repository.IRentTypeRepository;
import com.casestudy.service.IFacilityTypeService;
import com.casestudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> rentTypes() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void saveRentType(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void deleteFRentType(int id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public List<Integer> findRentTypeByName(String name) {
        return null;
    }
}
