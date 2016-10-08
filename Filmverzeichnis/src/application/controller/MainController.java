package application.controller;

import java.io.IOException;

import application.model.dto.Movie;
import application.model.viewmodel.MainViewModel;
import application.view.add.AddActorToMovieWindow;
import application.view.add.AddMovieToActorWindow;
import application.view.create.CreateNewActorWindow;
import application.view.create.CreateNewMovieWindow;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

	MainViewModel viewModel;
	
	@FXML
	private TableView<Movie> movieTable;
	@FXML
	private TableColumn<Movie, String> movieName;
	@FXML
	private TableColumn<Movie, Number> movieYear;
	
	@FXML
	public void initialize() {
		viewModel = new MainViewModel();
		movieTable.setItems(viewModel.getMovieData());
		movieName.setCellValueFactory(cellData -> cellData.getValue().getName());
		movieYear.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
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
