package application.controller.create;

import com.jfoenix.controls.JFXTextField;

import application.controller.MainObservable;
import application.model.viewmodel.NewMovieViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class NewMovieController {

   NewMovieViewModel viewModel = new NewMovieViewModel();
   IntegerProperty year = new SimpleIntegerProperty();

   @FXML
   Button btnAdd;
   @FXML
   AnchorPane newMoviePane;
   @FXML
   JFXTextField txtTitle;
   @FXML
   JFXTextField txtGenre;
   @FXML
   JFXTextField txtYear;

   @FXML
   public void initialize() {
      newMoviePane.getStylesheets()
         .add(getClass().getResource("../../view/application.css").toExternalForm());

      viewModel.getTitle().bind(txtTitle.textProperty());
      viewModel.getGenre().bind(txtGenre.textProperty());
      viewModel.getYear().bind(year);

      txtTitle.setFocusTraversable(false);
      txtGenre.setFocusTraversable(false);
      txtYear.setFocusTraversable(false);
   }

   @FXML
   public void btnOkClicked() {
      try {
         this.year.set(Integer.parseInt(txtYear.textProperty().get()));
         viewModel.addMovie();
         removeArguments();
         txtYear.setPromptText("Year");
         MainObservable.toggleMovie();
      } catch (NumberFormatException | NullPointerException e) {
         txtYear.clear();
         txtYear.setPromptText("Bitte nur Zahlen eingeben!");
      }
   }

   @FXML
   public void btnCancleClicked() {
      removeArguments();
      MainObservable.toggleMovie();
      txtYear.setPromptText("Year");
   }

   private void removeArguments() {
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
   }
}
