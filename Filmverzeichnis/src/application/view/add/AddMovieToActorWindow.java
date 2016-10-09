package application.view.add;

import java.io.IOException;

import application.view.AbstractWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AddMovieToActorWindow extends AbstractWindow{

	public AddMovieToActorWindow() throws IOException{
		root = FXMLLoader.load(getClass().getResource("../fxml/AddMovie.fxml"));
		scene = new Scene(root);
		stage.setTitle("Add movie");
		stage.setScene(scene);
		stage.show();
	}
	
}
