package application.controller.add;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import application.controller.MainObservable;
import application.model.viewmodel.MovieViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddMovieController {

   private MovieViewModel viewModel;
   private ObservableList<String> allActors = FXCollections.observableArrayList();
   IntegerProperty year = new SimpleIntegerProperty();

   @FXML
   JFXButton btnCancle;
   @FXML
   JFXComboBox<String> chbActor;
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

      allActors.add(viewModel.getTestActor().getName().get());
      chbActor.setItems(allActors);
      txtTitle.setFocusTraversable(false);
      txtGenre.setFocusTraversable(false);
      txtYear.setFocusTraversable(false);
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
         if (txtTitle.getText().isEmpty() || txtGenre.getText().isEmpty()
            || chbActor.getSelectionModel().getSelectedItem().isEmpty())
            throw new NullPointerException();
         txtTitle.setPromptText("Title");
         txtGenre.setPromptText("Genre");
         txtValid = true;
      } catch (NullPointerException e) {
         txtTitle.setPromptText(txtTitle.getText().isEmpty() ? "Title - Pflichtfeld" : "Title");
         txtGenre.setPromptText(txtGenre.getText().isEmpty() ? "Genre - Pflichtfeld" : "Genre");
         chbActor.setPromptText("Film auswählen!");
      }
      if (yearValid && txtValid) {
         viewModel.createMovie();
         resetValues();
         MainObservable.toggleActor();
      }
      // TODO Fachkonzept 1 anbinden
   }

   @FXML
   public void btnCancleClicked() {
      resetValues();
      MainObservable.toggleActor();
   }

   private void resetValues() {
      chbActor.getSelectionModel().clearSelection();
      chbActor.setPromptText("Select Actor");
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
      txtTitle.setPromptText("Title");
      txtGenre.setPromptText("Genre");
      txtYear.setPromptText("Year");
      chbActor.getSelectionModel().clearSelection();
   }
}
