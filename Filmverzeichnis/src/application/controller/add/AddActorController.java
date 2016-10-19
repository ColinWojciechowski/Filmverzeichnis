package application.controller.add;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import application.controller.MainObservable;
import application.model.viewmodel.AddActorViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class AddActorController {

   AddActorViewModel viewModel;
   private ObservableList<String> allMovies = FXCollections.observableArrayList();
   final ToggleGroup group = new ToggleGroup();

   @FXML
   TextField txtName;
   @FXML
   Button btnAdd;
   @FXML
   JFXComboBox<String> chbMovie;
   @FXML
   AnchorPane addActorPane;
   @FXML
   JFXRadioButton rbtnMale;
   @FXML
   JFXRadioButton rbtnFemale;
   @FXML
   JFXDatePicker dateBirth;

   @FXML
   public void initialize() {

      addActorPane.getStylesheets()
         .add(getClass().getResource("../../view/application.css").toExternalForm());
      viewModel = new AddActorViewModel();
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      dateBirth.editableProperty().set(false);
      allMovies.add(viewModel.getTestMovie().getName().get());
      chbMovie.setItems(allMovies);
      txtName.setFocusTraversable(false);
   }

   @FXML
   public void btnCancleClicked() {
      resetValues();
      MainObservable.toggleMovie();
   }

   private void resetValues() {
      chbMovie.getSelectionModel().clearSelection();
      dateBirth.setValue(null);
      dateBirth.setPromptText("Geburtstag");
      txtName.clear();
      txtName.setPromptText("Name");
      chbMovie.setPromptText("Select Movie");
      rbtnMale.fire();
   }

   @FXML
   public void btnOkClicked() {

      try {
         String sex = (rbtnMale.selectedProperty().get() == true) ? "Male" : "Female";
         viewModel.getSex().set(sex);
         viewModel.getName().bind(txtName.textProperty());
         if (txtName.getText().isEmpty() || dateBirth.getPromptText().isEmpty() || chbMovie.getSelectionModel().getSelectedItem().isEmpty())
            throw new NullPointerException();
         viewModel.addActor(this.dateBirth.getValue());
         resetValues();
         MainObservable.toggleMovie();
      } catch (NullPointerException e) {
         txtName.setPromptText((txtName.getText().isEmpty()) ? "Name - Pflichtfeld" : "Name");
         dateBirth.setPromptText("Geburtstag - Pflichtfeld");
         chbMovie.setPromptText("Film auswählen!");
      }

   }
}
