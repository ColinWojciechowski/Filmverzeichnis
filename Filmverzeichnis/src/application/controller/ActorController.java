package application.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import application.model.dto.enums.Sex;
import application.model.viewmodel.impl.ActorViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ActorController {

   final ToggleGroup group = new ToggleGroup();
   ActorViewModel viewModel = new ActorViewModel();
   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();
   StringProperty birth = new SimpleStringProperty();

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
         .add(getClass().getResource("../view/application.css").toExternalForm());
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      dateBirth.editableProperty().set(false);
   }

   @FXML
   public void btnOkClicked() {
      try {
         if (txtName.getText().isEmpty() || dateBirth.getPromptText().isEmpty())
            throw new NullPointerException();
         String sex = (rbtnMale.selectedProperty().get() == true) ? Sex.MALE.toString() : Sex.FEMALE.toString();
         this.sex.set(sex);
         this.name = txtName.textProperty();
         this.birth = new SimpleStringProperty(this.dateBirth.getValue().toString());
         viewModel.bindAttributes(name, this.sex, birth);
         viewModel.persist();
         resetValues();
         MainObservable.toggleActor();
         MainObservable.refreshMainView();
      } catch (NullPointerException e) {
         txtName.setPromptText(txtName.getText().isEmpty() ? "Name - Pflichtfeld" : "Name");
         dateBirth.setPromptText("Geburtstag - Pflichtfeld");
      }
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
