package application.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddActorToMovieWindow extends Stage{

	Stage stage;
	
	public AddActorToMovieWindow() throws IOException{
		stage = this;
		Parent root = FXMLLoader.load(getClass().getResource("AddActor.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Add actor");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
}
