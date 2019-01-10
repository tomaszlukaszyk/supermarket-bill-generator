package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    private Product product;

    @BeforeEach
    void init() {
        product = new Product("beer");
        product.addPrice(new AmountPrice(1, 1.2f));
        product.addPrice(new AmountPrice(2, 2.0f));
//        product.addPrice(new AmountPrice(1, 1.2f));
    }

    @Test
    void testReturnsCorrectPriceForAmountBelowDiscount() {
        float actual = product.getPriceForAmount(1);
        float expected = 1.2f;

        assertEquals(expected, actual);
    }

    @Test
    void testReturnsCorrectPriceForAmountEqualDiscount() {
        float actual = product.getPriceForAmount(2);
        float expected = 2.0f;

        assertEquals(expected, actual);
    }

    @Test
    void testReturnsCorrectPriceForAmountAboveDiscount() {
        float actual = product.getPriceForAmount(5);
        float expected = 5.2f;

        assertEquals(expected, actual);
    }
}