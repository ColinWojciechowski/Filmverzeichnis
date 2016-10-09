package application.controller;

import java.io.IOException;
import java.util.Date;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.MainViewModel;
import application.view.add.AddActorToMovieWindow;
import application.view.add.AddMovieToActorWindow;
import application.view.create.CreateNewActorWindow;
import application.view.create.CreateNewMovieWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

	MainViewModel viewModel;

	@FXML
	private TableView<Movie> movieTable;
	@FXML
	private TableColumn<Movie, String> movieName;
	@FXML
	private TableColumn<Movie, Number> movieYear;
	@FXML
	private TableView<Actor> actorTable;
	@FXML
	private TableColumn<Actor, String> actorName;
	@FXML
	private TableColumn<Movie, Date> actorBirth;
	@FXML
	TextField txtTitle;
	@FXML
	TextField txtActor;

	@FXML
	public void initialize() {
		viewModel = new MainViewModel();
		movieTable.setItems(viewModel.getMovieData());
		actorTable.setItems(viewModel.getActorData());
		movieName.setCellValueFactory(cellData -> cellData.getValue().getName());
		movieYear.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
		actorName.setCellValueFactory(cellData -> cellData.getValue().getName());
		movieTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				txtTitle.textProperty().unbind();
				txtTitle.textProperty().bind(newSelection.getName());
			}
		});

		actorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				txtActor.textProperty().unbind();
				txtActor.textProperty().bind(newSelection.getName());
			}
		});

		txtTitle.setEditable(false);
		txtActor.setEditable(false);
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
