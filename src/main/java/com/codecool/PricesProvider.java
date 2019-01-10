package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PricesProvider {

    private final int BARCODE_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int AMOUNT_INDEX = 2;
    private final int PRICE_INDEX = 3;

    private Map<Integer, Product> products;

    public PricesProvider(String filePath) throws FileNotFoundException {
        this.products = new HashMap<>();
        initProductsFromFile(filePath);
    }

    private void initProductsFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(", ");

            Integer barcode = Integer.valueOf(line[BARCODE_INDEX]);
            String name = line[NAME_INDEX];
            Integer amount = Integer.valueOf(line[AMOUNT_INDEX]);
            float price = Float.valueOf(line[PRICE_INDEX]);

            Product product = getProduct(barcode, name);
            AmountPrice amountPrice = new AmountPrice(amount, price);
            product.addPrice(amountPrice);
        }
    }

    private Product getProduct(Integer barcode, String name) {
        if (products.containsKey(barcode)) {
            return products.get(barcode);
        }

        Product product = new Product(name);
        products.put(barcode, product);

        return product;
    }

    public float getTotalPriceForProduct(int barcode, int amount) {
        Product product = products.get(barcode);

        return product.getPriceForAmount(amount);
    }
}
