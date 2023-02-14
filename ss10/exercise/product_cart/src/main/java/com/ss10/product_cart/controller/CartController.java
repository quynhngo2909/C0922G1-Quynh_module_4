package com.ss10.product_cart.controller;

import com.ss10.product_cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping-cart")
public class CartController {
    @ModelAttribute("cart")
    private Cart setupCard(){
        return new Cart();
    }
    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute Cart cart){
        return new ModelAndView("cart", "cart", cart);
    }
}
