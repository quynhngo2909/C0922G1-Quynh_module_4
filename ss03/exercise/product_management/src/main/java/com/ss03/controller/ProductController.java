package com.ss03.controller;

import com.ss03.model.Product;
import com.ss03.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String home(Model model) {
        List<Product> products = productService.getProducts();
        if (products.size() == 0) {
            model.addAttribute("'message", "Empty product list");
        } else {
            model.addAttribute("products", products);
        }
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("producers", productService.getProducers());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView save(Product product, RedirectAttributes redirect) {
        if (productService.save(product)) {
            return new ModelAndView("list", "products", productService.getProducts());
        } else {
            return new ModelAndView("create", "errorMessage", "Error! Cannot create new product!");
        }
    }

    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("producers", productService.getProducers());
        return "update";
    }

    @PostMapping("update")
    public ModelAndView update(Product product) {
        productService.update(product.getId(), product);
        return new ModelAndView("list", "products", productService.getProducts());
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam int id) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String name){
        List<Product> products = productService.findByName(name);
        if (products.size() == 0) {
            return new ModelAndView("list","errorMessage", "Product" + name + " is not existed");
        }
        return new ModelAndView("list","products", productService.findByName(name));
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        productService.delete(id);
        return new ModelAndView("list","products", productService.getProducts());
    }
}
