package application.view.add;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMovieToActorWindow extends Stage{

	Stage stage;
	
	public AddMovieToActorWindow() throws IOException{
		stage = this;
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/AddMovie.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Add movie");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
}
