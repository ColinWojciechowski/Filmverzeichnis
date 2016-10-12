package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
   @Override
   public void start(Stage primaryStage) {
      try {
         primaryStage.setResizable(false);
         Pane root = (Pane) FXMLLoader.load(getClass().getResource("view/fxml/rootFXML.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Filmverzeichnis");
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();
         } catch(Exception e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      launch(args);
   }
}
