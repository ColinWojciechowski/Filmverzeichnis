package application.view.add;

import java.io.IOException;

import application.view.AbstractWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AddActorToMovieWindow extends AbstractWindow{

	public AddActorToMovieWindow() throws IOException{
		root = FXMLLoader.load(getClass().getResource("../fxml/AddActor.fxml"));
		scene = new Scene(root);
		stage.setTitle("Add actor");
		stage.setScene(scene);
		stage.show();
	}
	
}
