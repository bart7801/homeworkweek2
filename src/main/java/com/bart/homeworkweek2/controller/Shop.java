package com.bart.homeworkweek2.controller;

import com.bart.homeworkweek2.model.Product;
import com.bart.homeworkweek2.service.ProductService;

import java.math.BigDecimal;

public interface Shop {

    BigDecimal getSumPrice();

    void showProductBasket();

    default BigDecimal getTotalPrice(ProductService productService) {
        BigDecimal sumPrice = new BigDecimal(0);
        for (Product p : productService.getProductsBasket()) {
            sumPrice = sumPrice.add(p.getPrice());
        }
        return sumPrice;
    }

}
