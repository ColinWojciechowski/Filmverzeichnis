package application.model.viewmodel.impl;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.interfaces.IFachkonzept;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieViewModel implements IFachkonzept<Movie> {

   StringProperty name = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   StringProperty year = new SimpleStringProperty();
   Movie movieTableItem = MainObservable.getSelectedMovie();
   Actor actorTableItem = MainObservable.getSelectedActor();
   Movie actorMoviesItem = MainObservable.getActorsMovieTableItem();
   Movie movie = new Movie();

   @Override
   public void persist() {
      if (movieTableItem == null)
         create();
      else {
         update(movieTableItem);
         MainObservable.toggleMovie();
      }
   }

   private void updateActorsMovie(Movie movie) {
      movie.setId(MainObservable.getAddMovieId());
      movie.setActors(new ArrayList<Actor>());
      if (!isActorsMovieSelected()) {
         actorTableItem.getMovies().add(movie);
         movie.getActors().add(actorTableItem);
         update(movie);
      } else {
         setValues(actorMoviesItem);
         actorMoviesItem.getActors().add(actorTableItem);
         MainObservable.getDaoMovieXml().saveOrUpdate(actorMoviesItem);
      }
      MainObservable.getDaoActorXml().saveOrUpdate(actorTableItem);
   }

   private boolean isActorsMovieSelected() {
      return actorMoviesItem != null;
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty genre, StringProperty year) {
      this.name = name;
      this.genre = genre;
      this.year = year;
   }

   @Override
   public void create() {
      if (actorTableItem != null) {
         updateActorsMovie(movie);
         MainObservable.toggleActor();
      } else {
         update(movie);
         MainObservable.toggleMovie();
      }
   }

   @Override
   public void update(Movie movie) {
      movie.setId(MainObservable.getNewMovieId());
      setValues(movie);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

   @Override
   public void delete() {
      MainObservable.getDaoMovieXml().delete(MainObservable.getSelectedMovie());
   }

   @Override
   public void setValues(Movie movie) {
      movie.setName(name);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
   }

}
