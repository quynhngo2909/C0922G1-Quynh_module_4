package com.casestudy.controller;

import com.casestudy.entity.Contract;
import com.casestudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping()
    public String getContracts(@RequestParam(name = "customerName", defaultValue = "") String customerName,
                               @RequestParam(name = "employeeName", defaultValue = "") String employeeName,
                               @RequestParam(name = "facilityName", defaultValue = "") String facilityName,
                               @PageableDefault(size = 5, sort = "start_date", direction = Sort.Direction.DESC) Pageable pageable,
                               Model model) {
//        Page<Contract> contracts = contractService.findContractByCustomerEmployeeFacility(customerName,employeeName ,facilityName, pageable);
//        Page<Contract> contracts = contractService.findContractByCustomer(customerName, pageable);
        Page<Contract> contracts = contractService.findContract( pageable);

        model.addAttribute("contracts", contracts);
        model.addAttribute("customerName", customerName);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("facilityName", facilityName);
        return "/contract/listContract";
    }
}