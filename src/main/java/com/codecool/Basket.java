package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Basket {

    private Map<Integer, Integer> products;

    public Basket(String filePath) throws FileNotFoundException {
        products = new HashMap<>();
        initProductsFromFile(filePath);
    }

    private void initProductsFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            Integer barcode = Integer.valueOf(line);
            Integer amount = 0;

            if (products.containsKey(barcode)) {
                amount = products.get(barcode);
            }
            products.put(barcode, ++amount);
        }
    }

    public Map<Integer, Integer> getProducts() {
        return products;
    }
}
