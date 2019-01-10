package com.codecool;

public class AmountPrice implements Comparable<AmountPrice> {

    private Integer amount;
    private float price;

    public AmountPrice(int amount, float price) {
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public int compareTo(AmountPrice o) {
        return this.amount.compareTo(o.getAmount());
    }
}
