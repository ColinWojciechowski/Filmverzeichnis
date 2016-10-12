package application.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InsertWindow extends Stage{

   protected Stage stage;
   protected Parent root;
   protected Scene scene;

   public InsertWindow(String fxmlFile, String title) throws IOException{
      root = FXMLLoader.load(getClass().getResource(fxmlFile));
      scene = new Scene(root);
      stage = this;
      stage.setTitle(title);
      stage.setScene(scene);
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.resizableProperty().set(false);
      stage.show();
   }

}
