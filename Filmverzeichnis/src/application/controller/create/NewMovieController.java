package application.controller.create;


import application.model.dto.Movie;
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
      newMoviePane.getStylesheets().add(getClass().getResource("../../view/application.css").toExternalForm());
      txtTitle.setFocusTraversable(false);
      txtGenre.setFocusTraversable(false);
      txtYear.setFocusTraversable(false);
   }

   @FXML
   public void btnAddClicked(){
      System.out.println("Hello World");
   }

   @FXML
   public void btnCancleClicked(){
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
   }

   @FXML
   public void btnOKClicked(){
      Movie movie = new Movie();

   }
}
