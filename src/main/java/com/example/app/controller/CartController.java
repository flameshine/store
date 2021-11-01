package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.service.CartService;
import com.example.app.service.ProductService;
import com.example.app.util.Constants;
import com.example.app.exception.NotEnoughProductsInStockException;

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
            .addObject("totalAmount", cartService.getTotalAmount());
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

        try {
            cartService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return cart()
                .addObject("notEnoughProductsInStockException", e.getMessage());
        }

        return cart();
    }
}