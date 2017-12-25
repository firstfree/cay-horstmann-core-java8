package ch03.sec04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(event -> System.out.println("Thanks for clicking!"));
		
		Label message = new Label("Hello, JavaFX!");
		message.setFont(new Font(100));
		
		VBox root = new VBox();
		root.getChildren().addAll(cancelButton, message);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
