package user;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class UserManager {

    public static LinkedList<Product> productList = new LinkedList<>();

    public void readList(String storeList) throws IOException {
        String name = null, color;
        int count, productID;
        double cost;
        Scanner input = new Scanner(storeList);
        String firstLine = input.nextLine();
        while (input.hasNextLine()) {
            name = input.nextLine();
            color = input.nextLine();
            cost = Double.parseDouble(input.nextLine());
            productID = Integer.parseInt(input.nextLine());
            count = Integer.parseInt(input.nextLine());
            Product newProduct = new Product(name, color, cost, productID, count);
            addProduct(newProduct);
        }

    }

    public void addProduct(Product newProduct) throws IOException {
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).isItThisProduct(newProduct)) {
                found = true;
                productList.get(i).addProduct();
                System.out.println("\nThis product is already in the store,added to stock");
                //sendMassege("\nThis product is already in the store,added to stock");
                break;
            }
        }
        if (!found) {
            System.out.println("\nNew product added to the storage");
            //sendMassege("\nNew product added to the storage");
            productList.add(newProduct);
        }
    }

    public void showProductList() {
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).showStatus();
        }
    }

}
