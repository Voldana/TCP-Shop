package store.server;

import java.io.*;
import java.net.*;

public class TCPClient extends Thread {

    private Socket socket;
    private DataOutputStream output = null;
    private static int count = 0;
    private int number;

    public TCPClient(Socket clientSocket) {
        socket = clientSocket;
        number = count;
        count++;
    }

    public void reciveMassege(String massege) throws IOException {
        output.writeBytes(massege);
    }

    public void run() {
        try {
            StoreManagement manageUtility = new StoreManagement();
            manageUtility.setIndex(number);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());
            String massege, username, password;
            int userCommand;
            output.writeBytes("Please enter your username and password to login:\n");
            username = input.readLine();
            System.out.println(username);
            password = input.readLine();
            System.out.println(password);
            manageUtility.login(username, password);
            if (manageUtility.isIsManager()) {
                output.writeBytes("\nWelcome manager"
                        + "\n1-Adding a product\n2-Deleting a product\n3-Showing product list"
                        + "\nAny other command will end the programm");
                int managerCommand;
                do {
                    output.writeBytes("\nPlease select your command: ");
                    managerCommand = Integer.parseInt(input.readLine());
                    switch (managerCommand) {
                        case 1:
                            output.writeBytes("\nPlease enter the product's name,color,cost"
                                    + " and ID in the order given\n");
                            String productName = input.readLine();
                            String productColor = input.readLine();
                            double productCost = Double.parseDouble(input.readLine());
                            int productID = Integer.parseInt(input.readLine());
                            Product newProduct = new Product(productName, productColor, productCost, productID);
                            manageUtility.addProduct(newProduct);
                            break;
                        case 2:
                            output.writeBytes("\nPlease enter the product's name,color,cost"
                                    + " and ID in the order given\n");
                            productName = input.readLine();
                            productColor = input.readLine();
                            productCost = Integer.parseInt(input.readLine());
                            productID = Integer.parseInt(input.readLine());
                            newProduct = new Product(productName, productColor, productCost, productID);
                            manageUtility.deleteProduct(newProduct);
                            break;
                        case 3:
//                            String afk = StoreManagement.turnListToString();
                            manageUtility.showProductList();
//                           output.writeBytes(afk);
                            break;
                    }
                } while (managerCommand < 6);

            }
            if (manageUtility.isIsClient()) {
                output.writeBytes("\nWelcome client"
                        + "\n1-Adding a product to your shopping cart\n2-Add money to your wallet"
                        + "\n3-Showing product list"
                        + "\nAny other command will end the programm");
            }

        } catch (IOException ignored) {

        }
    }

}
