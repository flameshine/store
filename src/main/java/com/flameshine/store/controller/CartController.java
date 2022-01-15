package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flameshine.store.service.CartService;
import com.flameshine.store.service.ProductService;
import com.flameshine.store.util.CurrencyConverter;
import com.flameshine.store.util.Constants;
import com.flameshine.store.model.Currency;

/**
 * Controller for the user shopping cart page.
 */

@Controller
@RequestMapping(value = Constants.CART_PATH)
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final CurrencyConverter converter;

    @Autowired
    public CartController(CartService cartService, ProductService productService, CurrencyConverter converter) {
        this.cartService = cartService;
        this.productService = productService;
        this.converter = converter;
    }

    @GetMapping
    public ModelAndView cart(@RequestParam("currency") Optional<Currency> currency) {

        // TODO: fix multiplicator issue

        var products = cartService.getProducts();

        products.forEach((product, quantity) -> product.setPrice(
            converter.convert(
                product.getPrice(), Constants.DEFAULT_CURRENCY, currency.orElse(Constants.DEFAULT_CURRENCY)
            ))
        );

        return new ModelAndView(Constants.CART_PATH)
            .addObject("products", products)
            .addObject("total", cartService.getTotalAmount());
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id) {

        productService.findById(id)
            .ifPresent(cartService::add);

        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {

        productService.findById(id)
            .ifPresent(cartService::remove);

        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {

        cartService.checkout();

        return "redirect:/cart";
    }
}