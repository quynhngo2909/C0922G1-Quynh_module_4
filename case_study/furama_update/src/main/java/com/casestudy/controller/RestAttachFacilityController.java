package com.casestudy.controller;

import com.casestudy.dto.IAttachFacilityDto;
import com.casestudy.entity.AttachFacility;
import com.casestudy.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attachFacility")
public class RestAttachFacilityController {

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public List<IAttachFacilityDto> getAttachFacilityByContractId(@RequestParam(name = "contractId") String contractId) throws Exception {
        if (contractId == null) throw new Exception("Invalid contractId");

        return attachFacilityService.getAttachFacilityDto(Integer.parseInt(contractId));
    }
}
