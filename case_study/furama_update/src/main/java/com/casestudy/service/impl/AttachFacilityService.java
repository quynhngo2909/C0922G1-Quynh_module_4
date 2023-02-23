package com.casestudy.service.impl;

import com.casestudy.dto.IAttachFacilityDto;
import com.casestudy.entity.AttachFacility;
import com.casestudy.repository.IAttachFacilityRepository;
import com.casestudy.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> getAttachFacilities() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void saveAttachFacility(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }


    @Override
    public List<IAttachFacilityDto> getAttachFacilityDto(int id) {
        return attachFacilityRepository.getAttachFacilityDto(id);
    }
}
