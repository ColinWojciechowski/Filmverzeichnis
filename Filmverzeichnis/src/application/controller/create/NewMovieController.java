package application.controller.create;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewMovieController {

   @FXML
   Button btnAdd;
   @FXML
   AnchorPane newMoviePane;
   @FXML
   TextField txtTitle;
   @FXML
   TextField txtGenre;
   @FXML
   TextField txtYear;

   @FXML
   public void initialize(){
      newMoviePane.getStylesheets().add(getClass().getResource("../../application.css").toExternalForm());
   }

   @FXML
   public void btnAddClicked(){
      System.out.println("Hello World");
   }
}
