package application.controller.add;

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

public class AddActorController {

   IFachkonzept viewModel;
   final ToggleGroup group = new ToggleGroup();
   StringProperty name = new SimpleStringProperty();
   StringProperty sex = new SimpleStringProperty();
   StringProperty birth = new SimpleStringProperty();

   @FXML
   TextField txtName;
   @FXML
   Button btnAdd;
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
      viewModel = new ActorViewModel();
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      dateBirth.editableProperty().set(false);
   }

   @FXML
   public void btnCancleClicked() {
      resetValues();
      MainObservable.toggleMovie();
   }

   private void resetValues() {
      dateBirth.setValue(null);
      dateBirth.setPromptText("Geburtstag");
      txtName.clear();
      txtName.setPromptText("Name");
      rbtnMale.fire();
   }

   @FXML
   public void btnOkClicked() {
      try {
         String sex = (rbtnMale.selectedProperty().get() == true) ? Sex.MALE.toString() : Sex.FEMALE.toString();
         this.sex = new SimpleStringProperty(sex);
         this.name.set(txtName.getText());
         this.birth = this.dateBirth.promptTextProperty();
         if (txtName.getText().isEmpty() || dateBirth.getPromptText().isEmpty())
            throw new NullPointerException();
         viewModel.bindAttributes(name, this.sex, birth);
//         viewModel.setSex(this.sex);
//         viewModel.setName(name);
         viewModel.add();
         MainObservable.refreshMainView();
         resetValues();
         MainObservable.toggleMovie();
      } catch (NullPointerException e) {
         txtName.setPromptText((txtName.getText().isEmpty()) ? "Name - Pflichtfeld" : "Name");
         dateBirth.setPromptText("Geburtstag - Pflichtfeld");
      }
   }
}
