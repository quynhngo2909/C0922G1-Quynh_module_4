package com.casestudy.service;

import com.casestudy.dto.IAttachFacilityDto;
import com.casestudy.entity.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> getAttachFacilities();
    void saveAttachFacility(AttachFacility attachFacility);

    List<IAttachFacilityDto> getAttachFacilityDto(int id);
}
