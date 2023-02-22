package com.casestudy.service;

import com.casestudy.entity.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> rentTypes();
    void saveRentType(RentType rentType);
    void deleteFRentType(int id);
    List<Integer> findRentTypeByName(String name);
}
