package application.model.viewmodel.impl;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.interfaces.IFachkonzept;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieViewModel implements IFachkonzept {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty title = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   StringProperty year = new SimpleStringProperty();
   Movie movieTableItem = MainObservable.getSelectedMovie();
   Actor actorTableItem = MainObservable.getSelectedActor();
   Movie actorMoviesItem = MainObservable.getActorsMovieTableItem();
   Actor movieActorsItem = MainObservable.getMovieActorsTableItem();
   Movie movie = new Movie();

   @Override
   public void persist() {
      if (movieTableItem == null) {
         createNewMovie();
      } else {
         updateMovie(movieTableItem);
         MainObservable.toggleMovie();
      }
   }

   private void createNewMovie() {
      if (actorTableItem != null) {
         updateActorsMovie(movie);
         MainObservable.toggleActor();
      } else {
         movie.setId(MainObservable.getNewMovieId());
         updateMovie(movie);
         MainObservable.toggleMovie();
      }
   }

   private void updateActorsMovie(Movie movie) {
      movie.setId(MainObservable.getAddMovieId());
      if(actorMoviesItem != null && movie.getId() == actorMoviesItem.getId()){
         setValues(movie);
         MainObservable.getDaoMovieXml().saveOrUpdate(movie);
         MainObservable.getDaoActorXml().saveOrUpdate(actorTableItem);
      }else{
         updateMovie(movie);
         actorTableItem.getMovies().add(movie);
         MainObservable.getDaoActorXml().saveOrUpdate(actorTableItem);
         MainObservable.toggleMovie();
      }
      MainObservable.toggleMovie();
   }

   private void updateMovie(Movie movie) {
      setValues(movie);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

   private void setValues(Movie movie) {
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty genre, StringProperty year) {
      this.title = name;
      this.genre = genre;
      this.year = year;
   }

   @Override
   public void delete() {
      MainObservable.getDaoMovieXml().delete(MainObservable.getSelectedMovie());
   }

}
