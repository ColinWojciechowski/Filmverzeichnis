package application.model.viewmodel;

import java.time.LocalDate;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.dto.enums.Sex;
import application.model.fachkonzept.interfaces.IFachkonzept;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

   private ObservableList<Movie> movieData = FXCollections.observableArrayList();
   private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
   private ObservableList<Movie> actorMovies = FXCollections.observableArrayList();
   private ObservableList<String> allMovies = FXCollections.observableArrayList();
   private IFachkonzept<Actor> fachkonzeptActor;
   private IFachkonzept<Movie> fachkonzeptMovie;
   private IDao<Actor> daoActorXml;
   private IDao<Movie> daoMovieXml;

   public MainViewModel() {
      Movie testMovie = new Movie();
      Movie testMovie2 = new Movie();
      Actor testActor = new Actor();

      testMovie.setId(1);
      testMovie2.setId(2);
      testActor.setId(1);

      testMovie.setName(new SimpleStringProperty("Scary Movie"));
      testMovie2.setName(new SimpleStringProperty("Pulp Fiction"));
      testActor.setName(new SimpleStringProperty("Harrisson Ford"));

      testMovie.setReleaseYear(new SimpleIntegerProperty(2005));
      testMovie2.setReleaseYear(new SimpleIntegerProperty(1998));
      testActor.setBirthDate(new SimpleStringProperty(LocalDate.now().toString()));
      testActor.setSex(Sex.MALE.toString());

      testMovie.setGenre(new SimpleStringProperty("Comedy"));
      testMovie2.setGenre(new SimpleStringProperty("Ganster"));

      movieActors.add(testActor);
      actorMovies.add(testMovie);
      testMovie.setActors(movieActors);
      testActor.setMovies(actorMovies);

      movieData.add(testMovie);
      movieData.add(testMovie2);

      allMovies.add(getTestMovie().getName().get());

   }

   public ObservableList<Movie> getMovieData() {
      return movieData;
   }

   public ObservableList<String> getAllMovies() {
      return allMovies;
   }

   public ObservableList<Actor> getActorData() {
      return movieActors;
   }

   public Movie getTestMovie() {
      Movie testMovie = new Movie();
      testMovie.setId(4);
      testMovie.setName(new SimpleStringProperty("Sleepy Hollow"));
      testMovie.setReleaseYear(new SimpleIntegerProperty(2120));
      return testMovie;
   }

   public void setFachkonzept(IFachkonzept<Actor> fachkonzeptActor, IFachkonzept<Movie> fachkonzeptMovie) {
      this.fachkonzeptActor = fachkonzeptActor;
      this.fachkonzeptMovie = fachkonzeptMovie;
   }

   public void setDatenhaltung(IDao<Actor> daoActorXml, IDao<Movie> daoMovieXml) {
      this.daoActorXml = daoActorXml;
      this.daoMovieXml = daoMovieXml;
   }

   public IFachkonzept<Actor> getFachkonzeptActor() {
      return fachkonzeptActor;
   }


   public IFachkonzept<Movie> getFachkonzeptMovie() {
      return fachkonzeptMovie;
   }

   public IDao<Actor> getDaoActorXml() {
      return daoActorXml;
   }

   public IDao<Movie> getDaoMovieXml() {
      return daoMovieXml;
   }

}
