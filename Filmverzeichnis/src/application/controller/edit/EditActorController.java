package application.controller.edit;

import java.time.LocalDate;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import application.controller.MainObservable;
import application.model.dto.enums.Sex;
import application.model.viewmodel.ActorViewModel;
import application.model.viewmodel.IFachkonzept;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class EditActorController {

   final ToggleGroup group = new ToggleGroup();
   IFachkonzept viewModel = new ActorViewModel();
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
         .add(getClass().getResource("../../view/application.css").toExternalForm());
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      dateBirth.editableProperty().set(false);

      MainObservable.getActorTable().getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               this.name = newSelection.getName();
               this.sex = newSelection.getSex();
               dateBirth.setValue(LocalDate.parse(newSelection.getBirthDate().get()));
               if (this.sex.get().equals(Sex.MALE.toString())) {
                  rbtnMale.fire();
               } else {
                  rbtnFemale.fire();
               }
               txtName.textProperty().bind(name);
            } else {
               txtName.clear();
               rbtnMale.fire();
               dateBirth.setValue(null);
            }
            txtName.textProperty().unbind();
         });
   }

   @FXML
   public void btnOkClicked() {
      try {
         if (txtName.getText().isEmpty() || dateBirth.getPromptText().isEmpty()
            || dateBirth.getValue() == null)
            throw new NullPointerException();
         String sex = (rbtnMale.selectedProperty().get() == true) ? Sex.MALE.toString()
            : Sex.FEMALE.toString();
         this.sex.set(sex);
         this.name.set(txtName.getText());
         this.birth = new SimpleStringProperty(this.dateBirth.getValue().toString());
         viewModel.bindAttributes(name, this.sex, birth);
         viewModel.saveOrUpdate();
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

/**
 * $ID: EditActorController.java,v $
 */
