package com.ss08.validation_registration_form.controller;

import com.ss08.validation_registration_form.dto.UserDto;
import com.ss08.validation_registration_form.model.User;
import com.ss08.validation_registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String list(Model model, @RequestParam(required = false, defaultValue = "") String firstName,
                       @PageableDefault(size = 2,sort = "firstName", direction = Sort.Direction.ASC) Pageable pageable){
     model.addAttribute("firstName", firstName);
     model.addAttribute("users", userService.findUserByFirstNameIsContaining(firstName, pageable));
     return "/user/list";
    }

    @GetMapping("/create-user")
    public ModelAndView create(){
        return new ModelAndView("/user/create", "userDto", new UserDto());
    }
    @PostMapping("/save-user")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult result, Model model ,@RequestParam(required = false, defaultValue = "") String firstName,
                       @PageableDefault(size = 2,sort = "firstName", direction = Sort.Direction.ASC) Pageable pageable){

        new UserDto().validate(userDto, result);
        if(result.hasErrors()){
            model.addAttribute("userDto", userDto);
            return  "/user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        model.addAttribute("message", "New users was created successfully!");
        model.addAttribute("users", userService.findUserByFirstNameIsContaining(firstName, pageable));
        return "/user/list";
    }
}
