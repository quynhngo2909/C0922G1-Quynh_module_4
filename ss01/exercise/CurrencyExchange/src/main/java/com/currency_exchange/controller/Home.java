package com.currency_exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @PostMapping("/")
    public String exchangeUSDtoVND(@RequestParam Double exchangeRate, @RequestParam Double usdAmount, Model model) {
        double vnd = usdAmount * exchangeRate;
        model.addAttribute("exchangeRate", exchangeRate);
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
