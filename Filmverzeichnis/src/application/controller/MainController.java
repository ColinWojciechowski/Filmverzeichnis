package application.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.MainViewModel;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class MainController {

   private MainViewModel viewModel;
   private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
   private ObservableList<Movie> actorMovies = FXCollections.observableArrayList();
   final ToggleGroup group = new ToggleGroup();

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
   private Label lblTitle;
   @FXML
   private Label lblActor;
   @FXML
   private JFXDrawersStack movieStack;
   @FXML
   private JFXDrawer movieTopDrawer;
   @FXML
   private JFXDrawer actorTopDrawer;
   @FXML
   private Pane addActorPane;
   @FXML
   private Pane newMoviePane;
   @FXML
   private JFXDrawersStack actorStack;
   @FXML
   private Pane addMoviePane;
   @FXML
   private Pane newActorPane;

   @SuppressWarnings("unused")
   @FXML
   public void initialize() throws IOException {
      viewModel = new MainViewModel();
      loadFxmlFiles();
      prepareTable();
      bindMovieTableToContent();
      bindActorTableToContent();
      setDrawerDirection();
      MainObservable observable = new MainObservable(this);
   }

   @FXML
   public void addActorToggle() {
      prepareDrawer(movieTopDrawer, addActorPane);
      toggle(movieStack, movieTopDrawer);
   }

   @FXML
   public void newMovieToggle() {
      prepareDrawer(movieTopDrawer, newMoviePane);
      toggle(movieStack, movieTopDrawer);
   }

   public void toggle(JFXDrawersStack stack, JFXDrawer drawer) {
      stack.toggle(drawer);
   }

   @FXML
   public void addMoviewToggle() {
      prepareDrawer(actorTopDrawer, addMoviePane);
      toggle(actorStack, actorTopDrawer);
   }

   @FXML
   public void newActorToggle() {
      prepareDrawer(actorTopDrawer, newActorPane);
      toggle(actorStack, actorTopDrawer);
   }

   public JFXDrawersStack getMovieStack() {
      return movieStack;
   }

   public JFXDrawer getMovieTopDrawer() {
      return movieTopDrawer;
   }

   public JFXDrawer getActorTopDrawer() {
      return actorTopDrawer;
   }

   public JFXDrawersStack getActorStack() {
      return actorStack;
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

   private void bindActorTableToContent() {
      actorTable.getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            StringProperty lblActorValue = newSelection.getName();
            if (newSelection != null) {
               lblActor.textProperty().bind(lblActorValue);
               actorMovies.clear();
               if (newSelection.getMovies() != null) {
                  actorMovies.addAll(newSelection.getMovies());
                  changeAcorMoviesTableContent();
               }
            }
         });
   }

   private void bindMovieTableToContent() {
      movieTable.getSelectionModel().selectedItemProperty()
         .addListener((obs, oldSelection, newSelection) -> {
            StringProperty lblMovieValue = newSelection.getName();
            if (newSelection != null) {
               lblTitle.textProperty().bind(lblMovieValue);
               movieActors.clear();
               if (newSelection.getActors() != null) {
                  movieActors.addAll(newSelection.getActors());
                  changeMovieActorsTableContent();
               }
            }
         });
   }

   private void changeAcorMoviesTableContent() {
      actorMoviesTable.setItems(actorMovies);
      actorMoviesName.setCellValueFactory(cellData -> cellData.getValue().getName());
      actorMoviesYear
         .setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());
      actorMoviesGenre.setCellValueFactory(cellData -> cellData.getValue().getGenre());
   }

   private void changeMovieActorsTableContent() {
      movieActorsTable.setItems(movieActors);
      movieActorsName.setCellValueFactory(cellData -> cellData.getValue().getName());
      movieActorsBirth
         .setCellValueFactory(cellData -> cellData.getValue().getBirthDate());
      movieActorsSex.setCellValueFactory(cellData -> cellData.getValue().getSex());
   }

   private void loadFxmlFiles() throws IOException {
      addActorPane = FXMLLoader.load(getClass().getResource("../view/fxml/AddActor.fxml"));
      newMoviePane = FXMLLoader.load(getClass().getResource("../view/fxml/NewMovie.fxml"));
      addMoviePane = FXMLLoader.load(getClass().getResource("../view/fxml/AddMovie.fxml"));
      newActorPane = FXMLLoader.load(getClass().getResource("../view/fxml/NewActor.fxml"));
   }

   private void setDrawerDirection() {
      movieTopDrawer.setDirection(JFXDrawer.DrawerDirection.TOP);
      actorTopDrawer.setDirection(JFXDrawer.DrawerDirection.TOP);
   }

   private void prepareDrawer(JFXDrawer drawer, Pane pane) {
      drawer.setSidePane(pane);
      drawer.setDefaultDrawerSize(400);
   }

   public MainViewModel getViewModel() {
      return viewModel;
   }

}
