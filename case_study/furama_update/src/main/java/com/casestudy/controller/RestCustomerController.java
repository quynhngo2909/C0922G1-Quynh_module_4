package com.casestudy.controller;

import com.casestudy.entity.Customer;
import com.casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/customers")
public class RestCustomerController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping()
    public ResponseEntity<Page<Customer>> getCustomers(@RequestParam(name = "name", defaultValue = "", required = false) String name,
                                     @RequestParam(name = "email", defaultValue = "", required = false) String email,
                                     @RequestParam(name = "customerTypename", defaultValue = "", required = false) String customerTypename,
                                     @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customerPage = customerService.findCustomerByNameEmail(name, email, customerTypename , pageable);
       if(customerPage.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
