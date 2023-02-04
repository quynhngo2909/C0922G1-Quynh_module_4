package com.ss03.controller;

import com.ss03.model.Product;
import com.ss03.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String home(Model model){
        List<Product> products = productService.products();
        if(products.size() == 0) {
            model.addAttribute("'message", "Empty product list");
        } else {
            model.addAttribute("products", products);
        }
        return "list";
    }
}
