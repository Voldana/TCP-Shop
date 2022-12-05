package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class LoginBox {
    private static String username,password;

    public static void setUsername(String username) {
        LoginBox.username = username;
    }

    public static void setPassword(String password) {
        LoginBox.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public void login(){
        Stage window = new Stage();
        window.setTitle("Login");
        GridPane grid = new GridPane();
        Button loginButton = new Button("Login");
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        username.setId("bold-label");
        password.setId("bold-label");
        GridPane.setConstraints(username , 0 ,0);
        GridPane.setConstraints(password , 0 , 1);
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        GridPane.setConstraints(passwordField , 1 , 1);
        GridPane.setConstraints(usernameField , 1,0);
        GridPane.setConstraints(loginButton , 1,2);
        loginButton.setOnAction(e -> {
            setUsername(usernameField.getText());
            setPassword(passwordField.getText());
            window.close();
        });
        loginButton.getStyleClass().add("button-blue");
        grid.getChildren().addAll(username,password,passwordField,usernameField,loginButton);
        Scene scene = new Scene(grid , 300 , 150);
        scene.getStylesheets().add(getClass().getResource("Voldana.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}
