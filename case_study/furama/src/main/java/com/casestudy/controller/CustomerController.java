package com.casestudy.controller;

import com.casestudy.entity.Customer;
import com.casestudy.service.ICustomerService;
import com.casestudy.service.ICustomerTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin("*")
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;
    @GetMapping()
    public String getCustomers(Model model) {
        model.addAttribute("customerType", customerTypeService.customerTypes());
        return "customer/listCustomers";
    }

}
