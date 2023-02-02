package com.ss04.controller;

import com.ss04.dao.EmailBoxSettingDao;
import com.ss04.model.EmailBoxSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailBoxController {
    @ModelAttribute("languages")
    public List<String> languages(){
        return EmailBoxSettingDao.getLanguages();
    }

    @ModelAttribute("pageSizes")
    public List<Integer> pageSizes(){
        return EmailBoxSettingDao.getPageSizes();
    }
    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "emailBoxSetting", new EmailBoxSetting());
    }

    @PostMapping("/setting")
    public ModelAndView setting(@ModelAttribute EmailBoxSetting emailBoxSetting){
        ModelAndView modelAndView;
        if(emailBoxSetting == null) {
            modelAndView = new ModelAndView("home");
            modelAndView.addObject("message", "Setting error!");
        } else {
            modelAndView = new ModelAndView("save");
            modelAndView.addObject("emailBoxSetting", emailBoxSetting);
            modelAndView.addObject("message", " Setting successfully!");
        }

        return modelAndView;
    }
}
