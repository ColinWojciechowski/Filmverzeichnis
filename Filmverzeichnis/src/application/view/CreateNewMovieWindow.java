package application.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewMovieWindow extends Stage{

	Stage stage;
	
	public CreateNewMovieWindow() throws IOException{
		stage = this;
		Parent root = FXMLLoader.load(getClass().getResource("NewMovie.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Create new movie");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
}
