package application.controller.add;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import application.controller.MainObservable;
import application.model.viewmodel.AddMovieViewModel;
import application.model.viewmodel.MainViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddMovieController {

   private AddMovieViewModel viewModel;
   private MainViewModel main;
   private ObservableList<String> allActors = FXCollections.observableArrayList();

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
   @FXML AnchorPane addMoviePane;

   @FXML
   public void initialize() {
      addMoviePane.getStylesheets().add(getClass().getResource("../../view/application.css").toExternalForm());
      viewModel = new AddMovieViewModel();

      allActors.add(viewModel.getTestActor().getName().get());
      chbActor.setItems(allActors);
      txtTitle.setFocusTraversable(false);
      txtGenre.setFocusTraversable(false);
      txtYear.setFocusTraversable(false);
   }

   @FXML
   public void btnOkClicked() {
      MainObservable.toggleActor();
      //TODO Fachkonzept 1 anbinden
   }

   @FXML
   public void btnCancleClicked(){
      txtTitle.clear();
      txtGenre.clear();
      txtYear.clear();
      chbActor.getSelectionModel().clearSelection();
      MainObservable.toggleActor();
   }
}
