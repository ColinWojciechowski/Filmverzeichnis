package application.controller.edit;

import com.jfoenix.controls.JFXTextField;

import application.controller.MainObservable;
import application.model.viewmodel.IFachkonzept;
import application.model.viewmodel.MovieViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class EditMovieController {

   IFachkonzept viewModel = new MovieViewModel();
   StringProperty name = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   StringProperty year = new SimpleStringProperty();

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
      MainObservable.getMovieTable().getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               this.name = newSelection.getName();
               this.genre = newSelection.getGenre();
               this.year = newSelection.getReleaseYear();
               txtTitle.textProperty().bind(name);
               txtGenre.textProperty().bind(genre);
               txtYear.textProperty().bind(new SimpleStringProperty(""+year.get()));

            }
            else{
               txtTitle.clear();
               txtGenre.clear();
               txtYear.clear();
            }
            txtTitle.textProperty().unbind();
            txtGenre.textProperty().unbind();
            txtYear.textProperty().unbind();
         });
   }

   @FXML
   public void btnOkClicked() {
      boolean yearValid = false;
      boolean txtValid = false;
      try {
         this.year.set(txtYear.getText());
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
         viewModel.bindAttributes(name, genre, year);
//         viewModel.setTitle(name);
//         viewModel.setGenre(genre);
//         viewModel.setYear(year);
         viewModel.edit();
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

   private void removeArguments() {
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
   }

   private void resetPrompt() {
      txtTitle.setPromptText("Title");
      txtGenre.setPromptText("Genre");
      txtYear.setPromptText("Year");
   }

}

/**
 * $ID: EditMovieController.java,v $
 */
