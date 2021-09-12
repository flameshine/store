package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.CartService;
import com.example.app.service.ProductService;
import com.example.app.exception.NotEnoughProductsInStockException;

/**
 * Controller for the user shopping cart page.
 */

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    // TODO: add logging

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView cart() {
        return new ModelAndView("/cart")
            .addObject("products", cartService.getProducts())
            .addObject("totalAmount", cartService.getTotalAmount());
    }

    @GetMapping("/add/{id}")
    public ModelAndView add(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::add);
        return cart();
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::remove);
        return cart();
    }

    @GetMapping("/checkout")
    public ModelAndView checkout() {

        // TODO: review this. Perhaps we can somehow re-design everything in order to replace this ugly exception handling with some functional programming solution

        try {
            cartService.checkout();
        } catch (NotEnoughProductsInStockException exception) {
            return cart()
                .addObject("notEnoughProductsInStockException", exception.getMessage());
        }

        return cart();
    }
}