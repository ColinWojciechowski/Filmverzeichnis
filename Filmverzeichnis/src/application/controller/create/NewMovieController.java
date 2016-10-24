package application.controller.create;

import com.jfoenix.controls.JFXTextField;

import application.controller.MainObservable;
import application.model.viewmodel.MovieViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class NewMovieController {

   MovieViewModel viewModel = new MovieViewModel();
   StringProperty name = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
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
   }

   @FXML
   public void btnOkClicked() {
      boolean yearValid = false;
      boolean txtValid = false;
      try {
         this.year.set(Integer.parseInt(txtYear.getText()));
         txtYear.setPromptText("Year");
         yearValid = true;
      } catch (NumberFormatException e) {
         txtYear.clear();
         txtYear.setPromptText("Bitte Jahreszahl eingeben!");
      }
      try {
         if (txtTitle.getText().isEmpty() || txtGenre.getText().isEmpty())
            throw new NullPointerException();
         txtTitle.setPromptText("Title");
         txtGenre.setPromptText("Genre");
         this.name.set(txtTitle.getText());
         this.genre.set(txtGenre.getText());
         txtValid = true;
      } catch (NullPointerException e) {
         txtTitle.setPromptText(txtTitle.getText().isEmpty() ? "Title - Pflichtfeld" : "Title");
         txtGenre.setPromptText(txtGenre.getText().isEmpty() ? "Genre - Pflichtfeld" : "Genre");
      }
      if (yearValid && txtValid) {
         viewModel.setTitle(name);
         viewModel.setGenre(genre);
         viewModel.setYear(year);
         viewModel.createMovie();
         MainObservable.refreshMainView();
         removeArguments();
         MainObservable.toggleMovie();
      }
   }

   @FXML
   public void btnCancleClicked() {
      removeArguments();
      MainObservable.toggleMovie();
      resetPrompt();
   }

   private void resetPrompt() {
      txtTitle.setPromptText("Title");
      txtGenre.setPromptText("Genre");
      txtYear.setPromptText("Year");
   }

   private void removeArguments() {
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
   }


   @FXML
   public void selectNextTextField(){
   }

}
