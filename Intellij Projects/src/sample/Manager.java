package sample;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Manager {
    ObservableList<Product> products = FXCollections.observableArrayList();
    private  String username,password;
    TableView<Product> productList,table;

    public void setUpList(){
        /*Stage window = new Stage();
        Scene scene;

        //Name column
        TableColumn<Product,String > nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product,Double > priceColumn = new TableColumn<>("Price");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        //ID column
        TableColumn<Product,Integer > IDcolumn = new TableColumn<>("ID");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));

        //Count column
        TableColumn<Product,Integer > countColumn = new TableColumn<>("Quantity");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("count"));

        //Color column
        TableColumn<Product,String > colorColumn = new TableColumn<>("Color");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        productList = new TableView<>();
        productList.setItems(getProduct());
        productList.getColumns().addAll(nameColumn,colorColumn,countColumn,priceColumn,IDcolumn);

        VBox layout = new VBox();
        layout.getChildren().addAll(productList);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();*/
        Stage window = new Stage();
        window.setTitle("thenewboston - JavaFX");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));


        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        //Quantity column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("count"));

        /*//Color column
        TableColumn<Product,String > colorColumn = new TableColumn<>("Color");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        */
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn, idColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox,600,800);
        window.setScene(scene);
        window.show();
    }
    //Login
    public void login(){
        LoginBox loginBox = new LoginBox();
        loginBox.login();
        setPassword(loginBox.getPassword());
        setUsername(loginBox.getUsername());
        System.out.println(username + "\n" + password);
    }

    //Registering
    public void register(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    //Returns all products
    public ObservableList<Product> getProduct(){
        return products;
    }

    //Adding product method
    public void addProduct(Product newProduct){
        boolean found = false;
        for(int i = 0 ; i < products.size() ; i++){
            if(products.get(i).isItThisProduct(newProduct)){
                found = true;
                products.get(i).addProduct(newProduct.getCount());
                System.out.println("\nThis product is already in the store,added to stock");
                //sendMassege("\nThis product is already in the store,added to stock");
                break;
            }
        }
        if (!found) {
            System.out.println("\nNew product added to the storage");
            //sendMassege("\nNew product added to the storage");
            products.add(newProduct);
        }
    }

    //Reading the list sent by the server and adding products
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
    public void showAllProducts(){
        for (int i = 0; i<products.size() ; i++){
            products.get(i).showStatus();
        }
    }
}
