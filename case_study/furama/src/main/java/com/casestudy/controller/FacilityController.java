package com.casestudy.controller;

import com.casestudy.dto.FacilityDto;
import com.casestudy.entity.Facility;
import com.casestudy.service.IFacilityService;
import com.casestudy.service.IFacilityTypeService;
import com.casestudy.service.IRentTypeService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;


    @GetMapping()
    public ModelAndView getFacility(@RequestParam(name = "name", defaultValue = "") String name,
                                    @RequestParam(name = "facilityType", defaultValue = "") String facilityTypeName,
                                    @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/facility/listFacility");
        modelAndView.addObject("facilities", facilityService.findFacilityByNameType(name, facilityTypeName, pageable));
        modelAndView.addObject("name", name);
        modelAndView.addObject("facilityType", facilityTypeName);
        modelAndView.addObject("facilityTypes", facilityTypeService.facilityTypes());
        return modelAndView;
    }

    @GetMapping("/create-facility")
    public String createFacility(Model model) {
        model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
        model.addAttribute("rentTypes", rentTypeService.rentTypes());
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/createFacility";
    }

    @GetMapping("/update-facility/{id}")
    public String updateFacility(@PathVariable(name = "id") int id, Model model) {
        Facility facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
        model.addAttribute("rentTypes", rentTypeService.rentTypes());
        return "/facility/updateFacility";
    }

    @PostMapping("/save-facility/")
    public String saveFacility(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model,
                               RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
            model.addAttribute("rentTypes", rentTypeService.rentTypes());
            return "/facility/createFacility";
        }

//        Create new
        if (facilityDto.getId() == null) {
            if (facilityService.findFacilityIdByName(facilityDto.getName()) != null) {
                model.addAttribute("message", "The facility' name: \" " + facilityDto.getName() + " \" was used");
                model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
                model.addAttribute("rentTypes", rentTypeService.rentTypes());
                return "/facility/createFacility";
            }

            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.saveFacility(facility);
            redirectAttributes.addFlashAttribute("message",
                    "Facility: \" " + facilityDto.getName() + " \" was created successfully!");
            return "redirect:/facilities";
        }
//        Update
        Facility dbFacility = facilityService.findById(facilityDto.getId());
        if (dbFacility == null) {
            model.addAttribute("message", "Facility is not exist.");
            model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
            model.addAttribute("rentTypes", rentTypeService.rentTypes());
            return "/facility/createFacility";
        }

        if (!dbFacility.getName().equals(facilityDto.getName())) {
            Integer existedFacilityID = facilityService.findFacilityIdByName(facilityDto.getName());

            if (existedFacilityID != null) {
                model.addAttribute("message", "The facility' name: \" " + facilityDto.getName() + " \" was used");
                model.addAttribute("facilityTypes", facilityTypeService.facilityTypes());
                model.addAttribute("rentTypes", rentTypeService.rentTypes());
                return "facility/updateFacility";
            }
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("message",
                "Facility: \" " + facilityDto.getName() + " \" was updated successfully!");
        return "redirect:/facilities";
    }

    @GetMapping("/delete-facility/{id}")
    public String deleteFacility(@PathVariable(name = "id") int id, Model model, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        if(facility == null){
            redirectAttributes.addFlashAttribute("message", "Facility is not exist.");
        } else {
            facilityService.deleteFacility(id);
            redirectAttributes.addFlashAttribute("message", "Facility \"" + facility.getName() +" \"was deleted!");
        }
        return "redirect:/facilities";
    }
}

