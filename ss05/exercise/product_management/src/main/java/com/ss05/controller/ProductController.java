package com.ss05.controller;

import com.ss05.model.Product;
import com.ss05.service.IProducerService;
import com.ss05.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String list(Model model){
        List<Product> products = productService.findAll();
        if(products.size() == 0) {
            model.addAttribute("message", "Product list is empty!");
        }
        model.addAttribute("products", products);
        return "product/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("producers", producerService.findAll());
        return "product/create";
    }

    @PostMapping("/save")
    public ModelAndView save(Product product){
        Long id = productService.findById(product.getId()).getId();
        if (id == null) {
            ModelAndView modelAndView = new ModelAndView("product/list");
            modelAndView.addObject("products", productService.findAll());
            modelAndView.addObject("message",
                    "New product was created successfully");
            return modelAndView;
        } else {
            if (productService.save(product)) {
                ModelAndView modelAndView = new ModelAndView("product/list");
                modelAndView.addObject("products", productService.findAll());
                modelAndView.addObject("message",
                        "Product" + product.getName() + " , id: " + product.getId() + " was updated.");
                return modelAndView;
            } else {
                return new ModelAndView("product/create", "errorMessage", "Error! Cannot update the product!");
            }
        }
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("producers", producerService.findAll());
        return "product/update";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String name){
        List<Product> products = productService.findByName(name);
        if (products.size() == 0) {
            return new ModelAndView("product/list","errorMessage", "Product" + name + " is not existed");
        }
        return new ModelAndView("product/list","products", productService.findByName(name));
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        productService.delete(id);
        return new ModelAndView("product/list","products", productService.findAll());
    }
}
