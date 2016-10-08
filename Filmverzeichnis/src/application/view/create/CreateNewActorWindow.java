package application.view.create;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewActorWindow extends Stage{

	Stage stage;
	
	public CreateNewActorWindow() throws IOException{
		stage = this;
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/NewActor.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Create new actor");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
}
