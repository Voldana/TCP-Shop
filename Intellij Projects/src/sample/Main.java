package sample;

import javafx.application.Application;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class Main extends Application {

    Stage window;
    Button login = new Button("Click here if you're already a member");
    Button register = new Button("Click here if you want to register");
    Button showList = new Button ("Show products");
    Manager manager = new Manager();


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        window.setTitle("JavaFX - Store");
        VBox layout = new VBox(30);
        layout.getChildren().addAll(login,register,showList);
        login.setOnAction(e -> {
            manager.login();
        });
        register.setOnAction(e -> {
            manager.register();
        });
        showList.setOnAction( e -> {
            try {
                manager.readList("\nCar\nBlue\n20000\n192\n4\nGloves\nBlack\n14.99\n168\n3");
                manager.showAllProducts();
                manager.setUpList();
            }
            catch (IOException er){
                System.out.println("Error");
            }
        });
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 800, 600);
//        scene.getStylesheets().add("/Voldana.css");
        scene.getStylesheets().add(getClass().getResource("Voldana.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    public void closeProgram(){
        boolean answer = ConfirmBox.display("Quit", "Are you sure you want to exit?");
        if(answer)
            window.close();
    }

}
