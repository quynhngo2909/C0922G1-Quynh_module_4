package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.dto.FacilityDto;
import com.casestudy.entity.Customer;
import com.casestudy.entity.Facility;
import com.casestudy.service.ICustomerService;
import com.casestudy.service.ICustomerTypeService;
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

@CrossOrigin("*")
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping()
    public String getCustomers(Model model, @RequestParam(name = "name", defaultValue = "") String name,
                               @RequestParam(name = "email", defaultValue = "") String email,
                               @RequestParam(name = "customerTypeName", defaultValue = "") String customerTypeName,
                               @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customerPage = customerService.findCustomerByNameEmail(name, email, customerTypeName, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeName", customerTypeName);
        model.addAttribute("customerTypes", customerTypeService.customerTypes());
        return "/customer/listCustomer";
    }

    @GetMapping("/update-customer/{id}")
    public String updateCustomer(Model model, @PathVariable int id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null) {
            model.addAttribute("message", "Customer with ID : \"" + id + "\" is not existed!");
            return "customer/listCustomer";
        } else {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", customerTypeService.customerTypes());
            return "/customer/updateCustomer";
        }
    }

    @GetMapping("/create-customer")
    public String createCustomer(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypes", customerTypeService.customerTypes());
        return "/customer/createCustomer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model,
                               RedirectAttributes redirectAttributes) {
        String customerDtoID = String.valueOf(customerDto.getId());
        Customer customer = new Customer();
        new CustomerDto().validate(customerDto, bindingResult);
        Integer dbId = customerService.getCustomerIDByIdCardEmailPhoneNumber(customerDto.getIdCard(), customerDto.getEmail(), customerDto.getPhoneNumber());

        switch (customerDtoID) {
            case "null":
                //        Customer customer = new Customer();
//        new CustomerDto().validate(customerDto, bindingResult);
                if (bindingResult.hasErrors()) {
                    model.addAttribute("customerDto", customerDto);
                    model.addAttribute("customerTypes", customerTypeService.customerTypes());
                    return "/customer/updateCustomer";
                }
//                Integer dbId = customerService.getCustomerIDByIdCardEmailPhoneNumber(customerDto.getIdCard(), customerDto.getEmail(), customerDto.getPhoneNumber());
                if (dbId != customerDto.getId()) {
                    model.addAttribute("message", "The ID Card / Email / Phone number was used by other customer!");
                    model.addAttribute("customerTypes", customerTypeService.customerTypes());
                    model.addAttribute("customerDto", customerDto);
                    return "customer/updateCustomer";
                } else {
                    BeanUtils.copyProperties(customerDto, customer);
                    customerService.saveCustomer(customer);
                    redirectAttributes.addFlashAttribute("message",
                            "Customer: \" " + customer.getName() + " \" was updated successfully!");
                    return "redirect:/customers";
                }
            default:
                if (bindingResult.hasErrors()) {
                    model.addAttribute("customerDto", customerDto);
                    model.addAttribute("customerTypes", customerTypeService.customerTypes());
                    return "/customer/createCustomer";
                }
//                Integer dbId = customerService.getCustomerIDByIdCardEmailPhoneNumber(customerDto.getIdCard(), customerDto.getEmail(), customerDto.getPhoneNumber());
                if (dbId != null) {
                    model.addAttribute("message", "The ID Card / Email / Phone number was used by other customer!");
                    model.addAttribute("customerTypes", customerTypeService.customerTypes());
                    model.addAttribute("customerDto", customerDto);
                    return "customer/createCustomer";
                } else {
                    BeanUtils.copyProperties(customerDto, customer);
                    customerService.saveCustomer(customer);
                    redirectAttributes.addFlashAttribute("message",
                            "Customer: \" " + customer.getName() + " \" was updated successfully!");
                    return "redirect:/customers";
                }
        }

    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("message", "Customer with ID: \" " + id + " is not existed.");
        } else {
            customerService.setExpiredCustomer(id);
            redirectAttributes.addFlashAttribute("message", "Customer with ID: \" " + id + " was deleted.");
        }
        return "redirect:/customers";
    }
}
