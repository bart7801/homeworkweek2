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
import java.math.RoundingMode;

@Component
@Profile("PRO")
public class ShopPro implements Shop {

    @Value(value = "${value.variant}")
    private String variant;

    @Value("${value.VAT}")
    private BigDecimal vat;

    @Value("${value.discount}")
    private BigDecimal discount;

    private ProductService productService;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public BigDecimal getSumPrice() {
        return getTotalPrice(productService);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showProductBasket() {
        System.out.println("Variant: " + variant);
        System.out.println("Your shopping basket contain: ");
        for (Product product : productService.getProductsBasket()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " GBP");
        }
        System.out.println("PRO variant discount: " + discount + "%");
        System.out.println("Base price: " + getSumPrice() + " GBP");
        System.out.println("Price after discount: " + getSumPrice().subtract(getSumPrice().multiply(discount.divide(BigDecimal.valueOf(100))))
                .setScale(2, RoundingMode.CEILING) + " BGP");
        System.out.println("VAT: " + getSumPrice().multiply(vat).setScale(2, RoundingMode.CEILING) + " BGP");

    }
}
