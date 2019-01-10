package com.codecool;

import java.io.FileNotFoundException;
import java.util.Map;

public class BillGenerator {

    private PricesProvider pricesProvider;
    private Basket basket;

    public BillGenerator(PricesProvider pricesProvider, Basket basket) {
        this.pricesProvider = pricesProvider;
        this.basket = basket;
    }

    private float generateBill() {
        float totalPrice = 0;
        Map<Integer, Integer> productsInBasket = basket.getProducts();

        for (Integer barcode: productsInBasket.keySet()) {
            Integer amount = productsInBasket.get(barcode);
            totalPrice += pricesProvider.getTotalPriceForProduct(barcode, amount);
        }

        return totalPrice;
    }

    public static void main(String[] args){
        if (args.length < 2) {
            System.out.println("Pleas provide files for product prices and basket");
            return;
        }

        PricesProvider pricesProvider;
        Basket basket;

        try {
            pricesProvider = new PricesProvider(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + args[0]);
            return;
        }

        try {
            basket = new Basket(args[1]);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + args[1]);
            return;
        }

        float bill = new BillGenerator(pricesProvider, basket).generateBill();

        System.out.printf("The total price is: %.2f EUR\n", bill);
    }
}
