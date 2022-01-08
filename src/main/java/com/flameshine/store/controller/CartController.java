package com.flameshine.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.flameshine.store.service.CartService;
import com.flameshine.store.service.ProductService;
import com.flameshine.store.util.Constants;

/**
 * Controller for the user shopping cart page.
 */

@Controller
@RequestMapping(value = Constants.CART_PATH)
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView cart() {
        return new ModelAndView(Constants.CART_PATH)
            .addObject("products", cartService.getProducts())
            .addObject("total", cartService.getTotalAmount());
    }

    @GetMapping("/add/{id}")
    public ModelAndView add(@PathVariable("id") Long id) {

        productService.findById(id)
            .ifPresent(cartService::add);

        return cart();
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {

        productService.findById(id)
            .ifPresent(cartService::remove);

        return cart();
    }

    @GetMapping("/checkout")
    public ModelAndView checkout() {

        cartService.checkout();

        return cart();
    }
}