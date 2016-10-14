package application.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.MainViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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
   private AnchorPane movieAnchor;
   @FXML
   private AnchorPane actorAnchor;
   @FXML
   private JFXDrawersStack stack;
   @FXML
   private JFXDrawer movieBottomDrawer;
   @FXML
   private JFXDrawer actorBottomDrawer;
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



   @FXML
   public void initialize() throws IOException {
      viewModel = new MainViewModel();
      prepareTable();
      bindTableToContent();
      addActorPane=  FXMLLoader.load(getClass().getResource("../view/fxml/AddActor.fxml"));
      newMoviePane=  FXMLLoader.load(getClass().getResource("../view/fxml/NewMovie.fxml"));
      addMoviePane=  FXMLLoader.load(getClass().getResource("../view/fxml/AddMovie.fxml"));
      newActorPane=  FXMLLoader.load(getClass().getResource("../view/fxml/NewActor.fxml"));
      movieBottomDrawer.setDirection(JFXDrawer.DrawerDirection.BOTTOM);
      actorBottomDrawer.setDirection(JFXDrawer.DrawerDirection.BOTTOM);
   }

   @FXML
   public void addActorToggle(){
      movieBottomDrawer.setSidePane(addActorPane);
      movieBottomDrawer.setDefaultDrawerSize(400);
      stack.toggle(movieBottomDrawer);
   }

   @FXML
   public void newMovieToggle(){
      movieBottomDrawer.setSidePane(newMoviePane);
      movieBottomDrawer.setDefaultDrawerSize(400);
      stack.toggle(movieBottomDrawer);
   }

   @FXML
   public void addMoviewToggle(){
      actorBottomDrawer.setSidePane(addMoviePane);
      actorBottomDrawer.setDefaultDrawerSize(400);
      actorStack.toggle(actorBottomDrawer);
   }

   @FXML
   public void newActorToggle(){
    actorBottomDrawer.setSidePane(newActorPane);
    actorBottomDrawer.setDefaultDrawerSize(400);
    actorStack.toggle(actorBottomDrawer);
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




}
