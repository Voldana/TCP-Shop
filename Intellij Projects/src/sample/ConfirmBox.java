package sample;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ConfirmBox {

    //Create variable
    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        HBox innerLayout = new HBox(8);
        innerLayout.getChildren().addAll(yesButton,noButton);
        innerLayout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,innerLayout);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,250,100);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}
