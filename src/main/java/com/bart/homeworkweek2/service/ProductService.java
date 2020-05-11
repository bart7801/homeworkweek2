package com.bart.homeworkweek2.service;

import com.bart.homeworkweek2.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private final static int MINIMUM_PRICE = 50;
    private final static int MAXIMUM_PRICE = 300;
    private static final int SCALE = 2;

    private List<Product> productsBasket;

    public ProductService() {
        productsBasket = new ArrayList<>();
        productsBasket.add(new Product("ONION", generatePrice()));
        productsBasket.add(new Product("TOMATOES", generatePrice()));
        productsBasket.add(new Product("POTATOES", generatePrice()));
        productsBasket.add(new Product("MUSHROOMS", generatePrice()));
        productsBasket.add(new Product("GARLIC", generatePrice()));

    }

    public BigDecimal generatePrice() {
        Random random = new Random();
        int randomInt = random.nextInt((MAXIMUM_PRICE - MINIMUM_PRICE) * 100) + MINIMUM_PRICE;
        return new BigDecimal(BigInteger.valueOf(randomInt), SCALE);
    }

    public List<Product> getProductsBasket() {
        return productsBasket;
    }

}
