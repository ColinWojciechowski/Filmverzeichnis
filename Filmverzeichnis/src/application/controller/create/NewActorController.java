package application.controller.create;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import application.controller.MainObservable;
import application.model.viewmodel.ActorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class NewActorController {

   final ToggleGroup group = new ToggleGroup();
   ActorViewModel viewModel = new ActorViewModel();

   @FXML
   Button btnAdd;
   @FXML
   AnchorPane newActorPane;
   @FXML
   JFXRadioButton rbtnMale;
   @FXML
   JFXRadioButton rbtnFemale;
   @FXML
   TextField txtName;
   @FXML
   JFXDatePicker dateBirth;

   @FXML
   public void initialize() {
      newActorPane.getStylesheets()
         .add(getClass().getResource("../../view/application.css").toExternalForm());
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      dateBirth.editableProperty().set(false);
      txtName.setFocusTraversable(false);
   }

   @FXML
   public void btnOkClicked() {
      try {
         String sex = (rbtnMale.selectedProperty().get() == true) ? "Male" : "Female";
         viewModel.getSex().set(sex);
         viewModel.getName().bind(txtName.textProperty());
         if (txtName.getText().isEmpty() || dateBirth.getPromptText().isEmpty())
            throw new NullPointerException();
        viewModel.createActor(this.dateBirth.getValue());
        resetValues();
         MainObservable.toggleActor();
      } catch (NullPointerException e) {
         txtName.setPromptText(txtName.getText().isEmpty() ? "Name - Pflichtfeld" : "Name");
         dateBirth.setPromptText("Geburtstag - Pflichtfeld");
      }
      // TODO Fachkonzept 1 anbinden
   }

   @FXML
   public void btnCancleClicked() {
      resetValues();
      MainObservable.toggleActor();
   }

   private void resetValues() {
      txtName.clear();
      txtName.setPromptText("Name");
      dateBirth.setValue(null);
      dateBirth.setPromptText("Geburtstag");
      rbtnMale.fire();
   }
}
