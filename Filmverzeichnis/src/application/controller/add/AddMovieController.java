package application.controller.add;

import application.model.viewmodel.AddMovieViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class AddMovieController {

   private AddMovieViewModel viewModel;
   private ObservableList<String> allActors = FXCollections.observableArrayList();

   @FXML
   Button btnAdd;
   @FXML
   ChoiceBox<String> chbActor;

   @FXML
   public void initialize() {
      viewModel = new AddMovieViewModel();

      allActors.add(viewModel.getTestActor().getName().get());
      chbActor.setItems(allActors);
   }

   @FXML
   public void btnOKClicked() {
      System.out.println("Hello World");
   }
}
