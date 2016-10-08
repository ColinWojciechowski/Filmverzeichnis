package application.controller;

import java.io.IOException;

import application.view.AddActorToMovieWindow;
import application.view.AddMovieToActorWindow;
import application.view.CreateNewActorWindow;
import application.view.CreateNewMovieWindow;
import javafx.fxml.FXML;

public class MainController {

	@FXML
	public void initialize() {

	}

	@FXML
	public void btnNewMovieClicked() {
		try {
			new CreateNewMovieWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnAddActorClicked() {
		try {
			new AddActorToMovieWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnNewActorClicked() {
		try {
			new CreateNewActorWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void btnAddMovieClicked() {
		try {
			new AddMovieToActorWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
