package com.ss01.simpleDictionary.controller;

import com.ss01.simpleDictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/")
    public String homePage() {
        return  "index";
    }

    @PostMapping("/")
    public String translate(@RequestParam String lookUpWord, Model model) {
        model.addAttribute("translateWord", dictionaryService.findByWord(lookUpWord));
        return  "index";
    }
}
