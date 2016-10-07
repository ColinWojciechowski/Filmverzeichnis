package application.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenNewWindow extends Stage{

	Stage stage;
	
	public OpenNewWindow() throws IOException{
		stage = this;
		Parent root = FXMLLoader.load(getClass().getResource("AddActor.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
