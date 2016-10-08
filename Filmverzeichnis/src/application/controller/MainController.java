package application.controller;

import java.io.IOException;

import application.view.add.AddActorToMovieWindow;
import application.view.add.AddMovieToActorWindow;
import application.view.create.CreateNewActorWindow;
import application.view.create.CreateNewMovieWindow;
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
