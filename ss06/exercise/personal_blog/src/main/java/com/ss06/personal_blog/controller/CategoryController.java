package com.ss06.personal_blog.controller;

import com.ss06.personal_blog.model.Category;
import com.ss06.personal_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String listCategories(Model model){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if(categories.size() == 0) {
            model.addAttribute("message", "The category list is empty!");
        }
        model.addAttribute("categories", categories);
        return "/category/listCategory";
    }

    @GetMapping("/create-category")
    public ModelAndView createCategory(){
        return new ModelAndView("/category/createCategory", "category", new Category());
    }

    @PostMapping("/save-category")
    public ModelAndView save(Category category){
        Category category1 = categoryService.findById(category.getId()).get();
        if(category1 == null) {
            categoryService.save(category);
            return  new ModelAndView("/category/createCategory",
                    "message", " New category was created successfully!");
        }

        category1.setName(category.getName());
        categoryService.save(category1);
        return  new ModelAndView("/category/updateCategory",
                "message", " The category was updated successfully!");
    }
    @GetMapping("/detail-category")
    public ModelAndView detail(@RequestParam String id){
        return new ModelAndView("/category/detailCategory", "category", categoryService.findById(id).get());
    }

    @GetMapping("/update-category/{id}")
    public ModelAndView update(@PathVariable String id){
        return  new ModelAndView("/category/updateCategory",
                "category", categoryService.findById(id).get());
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView save(@PathVariable String id){
        Category category = categoryService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/category/listCategory");
        categoryService.remove(category);
        modelAndView.addObject("message", category.getName() + " was deleted!");
        List<Category> categories = (List<Category>) categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}
