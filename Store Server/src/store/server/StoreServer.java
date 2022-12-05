package store.server;

import java.io.*;
import java.net.*;

public class StoreServer {
    
    public static void main(String[] args) throws IOException {
        StoreManagement manager = new StoreManagement();
        int count = 0, i = 0;
        Manager manager1 = new Manager("Voldana", "a123");
        Manager client1 = new Manager("Koldana", "321");
        StoreManagement.addManager(manager1);
        StoreManagement.addManager(client1);
        for (int j = 0; j < 5; j++) {
            manager.addProduct(new Product("Car", "Blue", 20000, 192));
        }
        for (int j = 0; j < 5; j++) {
            manager.addProduct(new Product("Gloves", "Black", 14.99, 168));
        }
        TCPServer server = new TCPServer();
        
        System.out.println("The server is ready!");
    }
}
