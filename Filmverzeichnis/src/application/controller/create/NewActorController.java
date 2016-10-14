package application.controller.create;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class NewActorController {

   final ToggleGroup group = new ToggleGroup();

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
   public void initialize(){
      newActorPane.getStylesheets().add(getClass().getResource("../../view/application.css").toExternalForm());
      rbtnMale.fire();
      rbtnMale.setToggleGroup(group);
      rbtnFemale.setToggleGroup(group);
      txtName.setFocusTraversable(false);
   }

   @FXML
   public void btnAddClicked(){
      System.out.println("Hello World");
   }

   @FXML
   public void btnCancleClicked(){
      txtName.clear();
      dateBirth.setValue(null);
      rbtnMale.fire();
   }
}
