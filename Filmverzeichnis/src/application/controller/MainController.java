package application.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML
	Button btnAdd;
	
	@FXML
	public void initialize(){
		
	}
	
	@FXML
	public void btnAddClicked(){
		System.out.println("Hello World");
	}
}