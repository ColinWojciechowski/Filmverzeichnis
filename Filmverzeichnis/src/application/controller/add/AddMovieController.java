package application.controller.add;

import com.jfoenix.controls.JFXButton;

import application.controller.MainObservable;
import application.model.viewmodel.IFachkonzept;
import application.model.viewmodel.MovieViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddMovieController {

   private IFachkonzept viewModel;
  StringProperty name = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   StringProperty year = new SimpleStringProperty();

   @FXML
   JFXButton btnCancle;
   @FXML
   TextField txtTitle;
   @FXML
   TextField txtGenre;
   @FXML
   TextField txtYear;
   @FXML
   AnchorPane addMoviePane;

   @FXML
   public void initialize() {
      addMoviePane.getStylesheets()
         .add(getClass().getResource("../../view/application.css").toExternalForm());
      viewModel = new MovieViewModel();
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
         viewModel.add();
         removeArguments();
         MainObservable.refreshMainView();
         MainObservable.toggleActor();
      }
   }

   @FXML
   public void btnCancleClicked() {
      removeArguments();
      MainObservable.toggleActor();
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
