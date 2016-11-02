package application.controller.add;

import application.controller.MainObservable;
import application.model.viewmodel.IFachkonzept;
import application.model.viewmodel.MovieViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddMovieController {

   private IFachkonzept viewModel;
   boolean yearValid = false;
   boolean txtValid = false;

   @FXML
   TextField txtTitle;
   @FXML
   TextField txtGenre;
   @FXML
   TextField txtYear;

   @FXML
   public void initialize() {
      viewModel = new MovieViewModel();
   }

   @FXML
   public void btnOkClicked() {
      boolean yearValid = false;
      boolean txtValid = false;
      try {
         Integer.parseInt(txtYear.getText());
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
         txtValid = true;
      } catch (NullPointerException e) {
         txtTitle.setPromptText(txtTitle.getText().isEmpty() ? "Title - Pflichtfeld" : "Title");
         txtGenre.setPromptText(txtGenre.getText().isEmpty() ? "Genre - Pflichtfeld" : "Genre");
      }
      if (yearValid && txtValid) {
         viewModel.bindAttributes(txtTitle.textProperty(), txtGenre.textProperty(),
            txtYear.textProperty());
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
