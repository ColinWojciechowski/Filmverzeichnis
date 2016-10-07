package application.controller;

import java.io.IOException;

import application.view.OpenNewWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	@FXML
	Button btnAddActor;
	Button btnNewMovie;

	@FXML
	public void initialize() {

	}

	@FXML
	public void btnNewMovieClicked() {
		try {
			new OpenNewWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnAddActorClicked() {
		System.out.println("Hello Dennis!");
	}
}
