package com.casestudy.controller;

import com.casestudy.dto.ContractDetailDto;
import com.casestudy.dto.ContractDto;
import com.casestudy.dto.IContractDto;
import com.casestudy.entity.Contract;
import com.casestudy.entity.ContractDetail;
import com.casestudy.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping()
    public String getContracts(@RequestParam(name = "customerName", defaultValue = "") String customerName,
                               @RequestParam(name = "employeeName", defaultValue = "") String employeeName,
                               @RequestParam(name = "facilityName", defaultValue = "") String facilityName,
                               @PageableDefault(size = 5, sort = {"customer","startDate"}, direction = Sort.Direction.DESC) Pageable pageable,
                               Model model) {
        Page<IContractDto> contracts = contractService.getContractDtos(customerName, employeeName, facilityName, pageable);
        model.addAttribute("contracts", contracts);
        model.addAttribute("customerName", customerName);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("facilityName", facilityName);
        model.addAttribute("attFacilities", attachFacilityService.getAttachFacilities());
        model.addAttribute("contractDetailDto", new ContractDetailDto());

        return "/contract/listContract";
    }

    @GetMapping("/create-contract")
    public String createContract(Model model) {
        model.addAttribute("attachFacilities", attachFacilityService.getAttachFacilities());
        model.addAttribute("customers", customerService.customers());
        model.addAttribute("employees", employeeService.employees());
        model.addAttribute("facilities", facilityService.facilities());
        model.addAttribute("attFalSer", attachFacilityService.getAttachFacilities());
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/createContract";
    }

    @PostMapping("/save-contract")
    public String saveContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model,
                               RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();
        new ContractDto().validate(contractDto, bindingResult);

        if (contractDto.getId() == 0) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("contractDto", contractDto);
                model.addAttribute("attachFacilities", attachFacilityService.getAttachFacilities());
                model.addAttribute("customers", customerService.customers());
                model.addAttribute("employees", employeeService.employees());
                model.addAttribute("facilities", facilityService.facilities());
                return "/contract/createContract";
            } else {
                BeanUtils.copyProperties(contractDto, contract);
                contractService.saveContract(contract);
                redirectAttributes.addFlashAttribute("message",
                        "Contract: \" " + contract.getId() + " \" was created successfully!");
                return "redirect:/contracts";
            }
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
            model.addAttribute("attachFacilities", attachFacilityService.getAttachFacilities());
            model.addAttribute("customers", customerService.customers());
            model.addAttribute("employees", employeeService.employees());
            model.addAttribute("facilities", facilityService.facilities());
            return "/customer/updateCustomer";
        } else {
            BeanUtils.copyProperties(contractDto, contract);
            contractService.saveContract(contract);
            redirectAttributes.addFlashAttribute("message",
                    "Contract: \" " + contract.getId() + " \" was updated successfully!");
            return "redirect:/contracts";
        }
    }

    @PostMapping("/create-contractDetail")
    public String saveContractDetail(@Validated @ModelAttribute(name = "contractDetailDto") ContractDetailDto contractDetailDto,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        ContractDetail contractDetail = new ContractDetail();
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if(contractDetailDto.getId() == null){
            redirectAttributes.addFlashAttribute("message", "Can not add new attach facility.");
            return "redirect:/contracts";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            redirectAttributes.addFlashAttribute("message", "Can not add new attach facility.");
            return "redirect:/contracts";
        }

        if (contractService.findContractById(contractDetailDto.getContract().getId()) == null) {
            redirectAttributes.addFlashAttribute("message", "Can not add new attach facility.");
        } else {
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.saveContractDetail(contractDetail);
            redirectAttributes.addFlashAttribute("message", "New attach facility : " + contractDetailDto.getAttachFacility().getName() + " was added in contract:" + contractDetailDto.getContract().getId());
        }
        return "redirect:/contracts";
    }

    @GetMapping("/delete-contractDetail/{id}")
    public String deleteContractDetail(@PathVariable(name = "id") int id, Model model) {
        ContractDetail dbCtrDetail = contractDetailService.findContractDetail(id);
        if(dbCtrDetail == null){
            model.addAttribute("message", "Contract detail  is not existed.");
            return "redirect:/contracts";
        } else {
            contractDetailService.deleteContractDetail(id);
            model.addAttribute("message", "Attach facility was deleted!");
            return "redirect:/contracts";
        }
    }
}