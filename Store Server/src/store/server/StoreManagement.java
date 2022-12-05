package store.server;

import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

public class StoreManagement {

    private boolean isManager = false, isClient = false;
    private int index;

    public boolean isIsManager() {
        return isManager;
    }

    public boolean isIsClient() {
        return isClient;
    }
    private static LinkedList<Client> clientList = new LinkedList<>();
    private static LinkedList<Manager> managerList = new LinkedList<>();
    private static LinkedList<Product> productList = new LinkedList<>();

    public static void addClient(Client newClient) {
        if (clientList.contains(newClient)) {
            System.out.println("This client is already in the database");
        } else {
            clientList.add(newClient);
            System.out.println("New client added to the database");
        }
    }

    public static void addManager(Manager newManager) {
        if (managerList.contains(newManager)) {
            System.out.println("This manager is already in the database");
        } else {
            managerList.add(newManager);
            System.out.println("New manager added to the database");
        }
    }

    public void addProduct(Product newProduct) throws IOException {
        boolean found = false;
        /* if (isManager) {
            if (productList.contains(newProduct)) {
                int index = productList.indexOf(newProduct);
                System.out.println("This product is already in the store,added to stock");
                productList.get(index).addProduct();
            } else {
                productList.add(newProduct);
                System.out.println("New product added to the storage");
            }
        } else {
            System.out.println("Only a manager can add products");
        }*/
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).isItThisProduct(newProduct)) {
                found = true;
                productList.get(i).addProduct();
                System.out.print("\nThis product is already in the store,added to stock");
                sendMassege("\nThis product is already in the store,added to stock");
                break;
            }
        }
        if (!found) {
            System.out.print("\nNew product added to the storage");
            sendMassege("\nNew product added to the storage");
            productList.add(newProduct);
        }
    }

    public void deleteProduct(Product newProduct) throws IOException {
        /*if (isManager) {
            if (productList.contains(newProduct)) {
                System.out.println("Product deleted!");
                productList.remove(newProduct);
            }
        } else {
            System.out.println("Only a manager can remove products");
        }*/
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).isItThisProduct(newProduct)) {
                found = true;
                productList.get(i).deleteProduct();
                System.out.println("\nThe product deleted " + productList.get(i).getCount() + " left");
                sendMassege("\nThe product deleted " + productList.get(i).getCount() + " left");
                if (productList.get(i).getCount() == 0) {
                    productList.remove(i);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("The product was not found");
            sendMassege("\nThe product was not found");
        }
    }

    public void login(String username, String password) throws IOException {
        boolean found = false;
        /*Manager newManager = new Manager(username,password);
        Client newClient = new Client(username,password);
        if (managerList.contains(newManager)) {
            System.out.println("Manager logged in!");
            isManager = true;
        } else if (clientList.contains(newClient)) {
            System.out.println("Client logged in!");
            isClient = true;
        } else {
            System.out.println("The user does not exist in our database");
        }*/
        for (int i = 0; i < managerList.size(); i++) {
            if (managerList.get(i).isItManager(username, password)) {
                System.out.println("Manager " + username + " logged in!");
                sendMassege("\nManager " + username + " logged in!");
                found = true;
                isManager = true;
                break;
            }
        }
        if (!found) {
            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).isItClient(username, password)) {
                    System.out.println("Client " + username + " logged in!");
                    sendMassege("\nClient " + username + " logged in!");
                    found = true;
                    isClient = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("The user is not in our database");
            sendMassege("\nThe user is not in our database");
        }

    }

    public void sendMassege(String massege) throws IOException {
        if (massege != null) {
            TCPServer.sendMassegeToClient(massege, index);
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void showProductList() throws IOException {
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            sendMassege(productList.get(i).showStatus());
        }
    }

    public static String turnListToString() {

        String storeList = "";
        for (int i = 0; i < productList.size(); i++) {
            storeList += productList.get(i).statusString();
        }
//        System.out.println(storeList);
        return storeList;
    }

}
