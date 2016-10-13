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
   private TableColumn<Movie, String> movieGenre;
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
   private TableColumn<Movie, String> actorMoviesGenre;
   @FXML
   Label lblTitle;
   @FXML
   Label lblActor;
   @FXML
   AnchorPane movieAnchor;

   @FXML
   public void initialize() {
      viewModel = new MainViewModel();
      prepareTable();
      bindTableToContent();
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
      new InsertWindow("../view/fxml/AddMovie.fxml", "Add movie" );
   }

   private void bindTableToContent() {
      movieTable.getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
               lblTitle.textProperty().unbind();
               lblTitle.textProperty().bind(newSelection.getName());
               movieActors.clear();
               if (newSelection.getActors() != null) {
                  movieActors.addAll(newSelection.getActors());
                  movieActorsTable.setItems(movieActors);
                  changeMovieActorsContent();
               }
            }
         });

      actorTable.getSelectionModel().selectedItemProperty()
      .addListener((obs, oldSelection, newSelection) -> {
         if (newSelection != null) {
            lblActor.textProperty().unbind();
            lblActor.textProperty().bind(newSelection.getName());
            actorMovies.clear();
            if (newSelection.getMovies() != null) {
               actorMovies.addAll(newSelection.getMovies());
               changeAcorMoviesContent();
            }
         }
      });
   }

   private void changeAcorMoviesContent() {
      actorMoviesTable.setItems(actorMovies);
      actorMoviesName.setCellValueFactory(cellData -> cellData.getValue().getName());
      actorMoviesYear
         .setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
      actorMoviesGenre.setCellValueFactory(cellData -> cellData.getValue().getGenre());
   }

   private void changeMovieActorsContent() {
      movieActorsName.setCellValueFactory(cellData -> cellData.getValue().getName());
      movieActorsBirth
         .setCellValueFactory(cellData -> cellData.getValue().getBirthDate());
      movieActorsSex.setCellValueFactory(cellData -> cellData.getValue().getSex());
   }

   private void prepareTable() {
      movieTable.setItems(viewModel.getMovieData());
      movieName.setCellValueFactory(cellData -> cellData.getValue().getName());
      movieYear.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
      movieGenre.setCellValueFactory(cellData -> cellData.getValue().getGenre());

      actorTable.setItems(viewModel.getActorData());
      actorName.setCellValueFactory(cellData -> cellData.getValue().getName());
      actorBirth.setCellValueFactory(cellData -> cellData.getValue().getBirthDate());
      actorSex.setCellValueFactory(cellData -> cellData.getValue().getSex());
   }


}
