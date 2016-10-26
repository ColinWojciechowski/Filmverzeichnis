package application.model.viewmodel;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieViewModel {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty title = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   IntegerProperty year = new SimpleIntegerProperty();

   public void createMovie() {
      Movie movie = new Movie();
      movie.setId(MainObservable.getNewMovieId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

   public void addMovie() {
      Movie movie = new Movie();
      movie.setId(MainObservable.getAddMovieId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      movie.setActors(new ArrayList<Actor>());
      for(Movie curMovie : MainObservable.getDaoMovieXml().getAll()){
         if(movie.getId() == curMovie.getId()){
            if(MainObservable.getSelectedActor() != null){
               movie.getActors().add(MainObservable.getSelectedActor());
            }
            MainObservable.getDaoMovieXml().saveOrUpdate(movie);
            return;
         }
      }
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
      MainObservable.getSelectedActor().getMovies().add(movie);
      MainObservable.getDaoActorXml().saveOrUpdate(MainObservable.getSelectedActor());
      MainObservable.refreshMainView();
   }

   public void editMovie(){
         Movie curMovie = MainObservable.getSelectedMovie();
            curMovie.setName(title);
            curMovie.setGenre(genre);
            curMovie.setReleaseYear(year);
            MainObservable.getDaoMovieXml().saveOrUpdate(curMovie);
            MainObservable.refreshMainView();
   }

   public IntegerProperty getId() {
      return id;
   }

   public void setId(IntegerProperty id) {
      this.id = id;
   }

   public StringProperty getTitle() {
      return title;
   }

   public void setTitle(StringProperty title) {
      this.title = title;
   }

   public StringProperty getGenre() {
      return genre;
   }

   public void setGenre(StringProperty genre) {
      this.genre = genre;
   }

   public IntegerProperty getYear() {
      return year;
   }

   public void setYear(IntegerProperty year) {
      this.year = year;
   }
}
