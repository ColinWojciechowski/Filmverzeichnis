package application.controller.add;


import application.model.viewmodel.AddActorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddActorController {
	
	AddActorViewModel viewModel;
	
	@FXML
	TextField txtName;
	

	@FXML
	Button btnAdd;
	
	@FXML
	public void initialize(){
		viewModel = new AddActorViewModel();
		txtName.textProperty().bindBidirectional(viewModel.getLabelText());
	}
	
	@FXML
	public void btnOKClicked(){
		System.out.println("Hello World");
	}
}
