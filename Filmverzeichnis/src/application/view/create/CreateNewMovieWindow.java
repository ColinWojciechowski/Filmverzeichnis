package application.view.create;

import java.io.IOException;

import application.view.AbstractWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CreateNewMovieWindow extends AbstractWindow{

	
	public CreateNewMovieWindow() throws IOException{
		root = FXMLLoader.load(getClass().getResource("../fxml/NewMovie.fxml"));
		scene = new Scene(root);
		stage.setTitle("Create new movie");
		stage.setScene(scene);
		stage.show();
	}
	
}
