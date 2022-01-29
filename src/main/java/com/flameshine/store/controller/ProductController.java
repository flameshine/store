package com.flameshine.store.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;
import lombok.RequiredArgsConstructor;

import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.service.CurrencyExchanger;
import com.flameshine.store.util.ResourceUtils;
import com.flameshine.store.util.Constants;
import com.flameshine.store.entity.Product;

/**
 * Products page controller.
 */

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductOperator operator;
    private final CurrencyExchanger exchanger;

    @GetMapping(Constants.PRODUCTS_PATH)
    public ModelAndView home(
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("currency") Optional<String> currency
    ) {

        var products = operator.findAllPageable(
            PageRequest.of(
                page.map(i -> i - 1).orElse(0), 5
            )
        );

        products.forEach(
            product -> exchange(product, currency.orElseGet(product::getCurrency))
        );

        return new ModelAndView(Constants.PRODUCTS_PATH)
            .addObject("products", products)
            .addObject("currencies", ResourceUtils.loadCurrencies());
    }

    private void exchange(Product product, String currency) {

        product.setPrice(
            exchanger.exchange(
                product.getPrice(), product.getCurrency(), currency
            )
        );

        product.setCurrency(currency);
    }
}