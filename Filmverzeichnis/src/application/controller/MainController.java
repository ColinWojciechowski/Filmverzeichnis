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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

	MainViewModel viewModel;
	private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
	private ObservableList<Movie> actorMovies = FXCollections.observableArrayList();

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
	private TableView<Actor> movieActorsTable;
	@FXML
	private TableColumn<Actor, String> movieActorsName;
	@FXML
	private TableView<Movie> actorMoviesTable;
	@FXML
	private TableColumn<Movie, String> actorMoviesName;
	@FXML
	private TableColumn<Movie, Number> actorMoviesYear;
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
				movieActors.clear();
				if (newSelection.getActors() != null) {
					movieActors.addAll(newSelection.getActors());
					movieActorsTable.setItems(movieActors);
					movieActorsName.setCellValueFactory(cellData -> cellData.getValue().getName());
				}
			}
		});

		actorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				txtActor.textProperty().unbind();
				txtActor.textProperty().bind(newSelection.getName());
				actorMovies.clear();
				if (newSelection.getMovies() != null) {
					actorMovies.addAll(newSelection.getMovies());
					actorMoviesTable.setItems(actorMovies);
					actorMoviesName.setCellValueFactory(cellData -> cellData.getValue().getName());
					actorMoviesYear.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
				}
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
