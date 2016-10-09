package application.view;

import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class AbstractWindow extends Stage{

	protected Stage stage;
	protected Parent root;
	protected Scene scene;
	
	public AbstractWindow() throws IOException{
		stage = this;
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.resizableProperty().set(false);
	}
	
}
