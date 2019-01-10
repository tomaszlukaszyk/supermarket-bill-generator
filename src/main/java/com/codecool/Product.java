package com.codecool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private String name;
    private List<AmountPrice> amountPrices;

    public Product(String name) {
        this.name = name;
        this.amountPrices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPrice(AmountPrice amountPrice) {
        this.amountPrices.add(amountPrice);
        Collections.sort(this.amountPrices);
    }

    public float getPriceForAmount(int amount) {
        float price = 0f;
        int lastElement = this.amountPrices.size() - 1;

        for (int i = lastElement; i>=0; i--) {

            int currentAmount = this.amountPrices.get(i).getAmount();

            if (currentAmount > amount) {
                continue;
            }

            float currentPrice = this.amountPrices.get(i).getPrice();

            price += currentPrice * (amount / currentAmount);

            amount = amount % currentAmount;
        }

        return price;
    }
}
