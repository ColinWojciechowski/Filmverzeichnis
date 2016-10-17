package application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {

   //TODO Fachkonzept1 fachkonzept = new Fachkonzept1();

   @Override
   public void start(Stage primaryStage) {
      try {
         primaryStage.setResizable(false);
         Pane root = (Pane) FXMLLoader.load(getClass().getResource("fxml/rootFXML.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Filmverzeichnis");
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void startGUI() {
      launch();
   }
}

/**
 * $ID: Entrypoint.java,v $
 */
