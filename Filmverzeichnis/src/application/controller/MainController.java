package application.controller;

import java.io.IOException;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.MainViewModel;
import application.view.InsertWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
   private TableColumn<Actor, String> actorBirth;
   @FXML
   private TableColumn<Actor, String> actorSex;
   @FXML
   private TableView<Actor> movieActorsTable;
   @FXML
   private TableColumn<Actor, String> movieActorsName;
   @FXML
   private TableColumn<Actor, String> movieActorsBirth;
   @FXML
   private TableColumn<Actor, String> movieActorsSex;
   @FXML
   private TableView<Movie> actorMoviesTable;
   @FXML
   private TableColumn<Movie, String> actorMoviesName;
   @FXML
   private TableColumn<Movie, Number> actorMoviesYear;
   @FXML
   Label lblTitle;
   @FXML
   TextField txtActor;
   @FXML
   AnchorPane movieAnchor;

   @FXML
   public void initialize() {
      viewModel = new MainViewModel();
      movieTable.setItems(viewModel.getMovieData());
      actorTable.setItems(viewModel.getActorData());
      movieName.setCellValueFactory(cellData -> cellData.getValue().getName());
      movieYear.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
      actorName.setCellValueFactory(cellData -> cellData.getValue().getName());
      actorBirth.setCellValueFactory(cellData -> cellData.getValue().getBirthDate());
      actorSex.setCellValueFactory(cellData -> cellData.getValue().getSex());
      movieTable.getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               lblTitle.textProperty().unbind();
               lblTitle.textProperty().bind(newSelection.getName());
               movieActors.clear();
               if (newSelection.getActors() != null) {
                  movieActors.addAll(newSelection.getActors());
                  movieActorsTable.setItems(movieActors);
                  movieActorsName.setCellValueFactory(cellData -> cellData.getValue().getName());
                  movieActorsBirth
                     .setCellValueFactory(cellData -> cellData.getValue().getBirthDate());
                  movieActorsSex.setCellValueFactory(cellData -> cellData.getValue().getSex());
               }
            }
         });

      actorTable.getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               txtActor.textProperty().unbind();
               txtActor.textProperty().bind(newSelection.getName());
               actorMovies.clear();
               if (newSelection.getMovies() != null) {
                  actorMovies.addAll(newSelection.getMovies());
                  actorMoviesTable.setItems(actorMovies);
                  actorMoviesName.setCellValueFactory(cellData -> cellData.getValue().getName());
                  actorMoviesYear
                     .setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
               }
            }
         });

      txtActor.setEditable(false);

   }

   @FXML
   public void btnNewMovieClicked() throws IOException {
      new InsertWindow("../view/fxml/NewMovie.fxml", "Create new movie");
   }

   @FXML
   public void btnAddActorClicked() throws IOException {
      new InsertWindow("../view/fxml/AddActor.fxml", "Add actor");
   }

   @FXML
   public void btnNewActorClicked() throws IOException {
      new InsertWindow("../view/fxml/NewActor.fxml", "Create new actor");
   }

   @FXML
   public void btnAddMovieClicked() throws IOException {
      new InsertWindow("../view/fxml/AddMovie2.fxml", "Add movie" );
   }
}
