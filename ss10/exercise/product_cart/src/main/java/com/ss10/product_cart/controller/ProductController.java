package com.ss10.product_cart.controller;

import com.ss10.product_cart.model.Cart;
import com.ss10.product_cart.model.Product;
import com.ss10.product_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    private Cart setupCart(){
        return new Cart();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showShop(Model model){
        model.addAttribute("products", productService.findAll());
        return "/shop";
    }

    @GetMapping("/product-add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        if(product == null){
            return "/error.404";
        }
        cart.addProduct(product);
        return "redirect:/shopping-cart";
    }
    @GetMapping("/product-decrease/{id}")
    public String decreaseFromCart(@PathVariable Integer id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        if(product == null){
            return "/error.404";
        }
        cart.decreaseProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/product-detail/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
    @GetMapping("/product-delete/{id}")
    public String removeFromCart(@PathVariable Integer id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        if(product == null){
            return "/error.404";
        }
        cart.removeProduct(product);
        return "redirect:/shopping-cart";
    }
}
