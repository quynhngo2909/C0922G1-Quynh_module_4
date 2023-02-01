package com.ss02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String homePage(){
        return "index";
    }
    @PostMapping("/calculate")
    public String addition(@RequestParam (required = false, defaultValue = "null") Double value1,
                      @RequestParam (required = false, defaultValue = "null") Double value2,
                           @RequestParam String cal, Model model){
        switch (cal){
            case "add":
                model.addAttribute("result", value1 + value2);
                model.addAttribute("math", "Addition");
                model.addAttribute("value1", value1);
                model.addAttribute("value2", value2);
                break;
            case "subtract":
                model.addAttribute("result", value1 - value2);
                model.addAttribute("math", "Subtraction");
                model.addAttribute("value1", value1);
                model.addAttribute("value2", value2);
                break;
            case "multiply":
                model.addAttribute("result", value1 * value2);
                model.addAttribute("math", "multiply");
                model.addAttribute("value1", value1);
                model.addAttribute("value2", value2);
                break;
            case "divide":
                if (value2 == 0) {
                    model.addAttribute("result", "Error! Divided by 0!");
                    model.addAttribute("math", "Division");
                    model.addAttribute("value1", value1);
                    model.addAttribute("value2", value2);
                } else {
                    model.addAttribute("result", value1 - value2);
                    model.addAttribute("math", "Division");
                    model.addAttribute("value1", value1);
                    model.addAttribute("value2", value2);
                }
                break;
        }
        return "index";
    }
}
