package application.view.create;

import java.io.IOException;

import application.view.AbstractWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CreateNewActorWindow extends AbstractWindow{

	
	public CreateNewActorWindow() throws IOException{
		root = FXMLLoader.load(getClass().getResource("../fxml/NewActor.fxml"));
		scene = new Scene(root);
		stage.setTitle("Create new actor");
		stage.setScene(scene);
		stage.show();
	}
	
}
