package com.ss02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentController {
    @GetMapping("")
    public String homePage(){
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam (value = "condiment", required = false, defaultValue = "No condiment") String[] condiments, Model model) {
        model.addAttribute("condiments",condiments);
        return "saveCondiment";
    }
}
