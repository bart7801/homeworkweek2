package com.bart.homeworkweek2.controller;

import com.bart.homeworkweek2.model.Product;
import com.bart.homeworkweek2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("START")
public class ShopStart extends ProductService {

    @Value(value = "${value.variant}")
    private String variant;

    private ProductService productService;

    @Autowired
    public ShopStart(ProductService productService) {
        this.productService = productService;
    }

    public BigDecimal getSumPrice() { return getTotalPrice(productService); }

    @EventListener(ApplicationReadyEvent.class)
    public void showProductBasket() {
        System.out.println("Variant: " + variant);
        System.out.println("Your shopping basket contain: ");
        for (Product product : productService.getProductsBasket()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " GBP");
        }
        System.out.println("Total price is: " + getSumPrice() + " GBP");
    }
}
