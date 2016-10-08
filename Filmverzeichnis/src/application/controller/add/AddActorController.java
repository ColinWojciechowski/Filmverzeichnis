package application.controller.add;


import application.model.dao.impl.DaoMovieXml;
import application.model.viewmodel.AddActorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddActorController {
	
	AddActorViewModel viewModel;
	private DaoMovieXml movies = new DaoMovieXml();
	
	@FXML
	TextField txtName;
	@FXML
	Button btnAdd;
	
	
	
	@FXML
	public void initialize(){
		viewModel = new AddActorViewModel();
		txtName.promptTextProperty().bind(viewModel.getLabelText());
	}
	
	@FXML
	public void btnOKClicked(){
		
	}
}
