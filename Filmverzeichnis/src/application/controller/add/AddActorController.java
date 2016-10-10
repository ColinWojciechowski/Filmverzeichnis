package application.controller.add;


import application.model.viewmodel.AddActorViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddActorController {

   AddActorViewModel viewModel;
   private ObservableList<String> allMovies = FXCollections.observableArrayList();

   @FXML
   TextField txtName;
   @FXML
   Button btnAdd;
   @FXML
   ChoiceBox<String> chbMovie;



   @FXML
   public void initialize(){
      viewModel = new AddActorViewModel();

      allMovies.add(viewModel.getTestMovie().getName().get());
      chbMovie.setItems(allMovies);
   }

   @FXML
   public void btnOKClicked(){

   }
}
