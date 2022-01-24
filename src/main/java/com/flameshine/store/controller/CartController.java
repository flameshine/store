package com.flameshine.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.flameshine.store.service.CartOperator;
import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.util.Constants;

/**
 * Shopping cart page controller.
 */

@Controller
@RequestMapping(value = Constants.CART_PATH)
public class CartController {

    private final CartOperator cartOperator;
    private final ProductOperator productOperator;

    @Autowired
    public CartController(CartOperator cartOperator, ProductOperator productOperator) {
        this.cartOperator = cartOperator;
        this.productOperator = productOperator;
    }

    @GetMapping
    public ModelAndView cart() {
        return new ModelAndView(Constants.CART_PATH)
            .addObject("products", cartOperator.getProducts())
            .addObject("total", cartOperator.getTotalAmount());
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id) {

        productOperator.findById(id)
            .ifPresent(cartOperator::add);

        return Constants.CART_PATH;
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {

        productOperator.findById(id)
            .ifPresent(cartOperator::remove);

        return Constants.CART_PATH;
    }

    @GetMapping("/checkout")
    public String checkout() {

        cartOperator.checkout();

        return Constants.CART_PATH;
    }
}