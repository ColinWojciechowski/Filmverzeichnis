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
         MainObservable.getMovieTable().getSelectionModel().clearSelection();
      }
   }

   private void updateActorsMovie(Movie movie) {
      movie.setId(MainObservable.getAddMovieId());
      movie.setActors(new ArrayList<Actor>());
      if (!isActorsMovieSelected()){
         actorTableItem.getMovies().add(movie);
         movie.getActors().add(actorTableItem);
      }
      update(movie);
      MainObservable.getDaoActorXml().saveOrUpdate(actorTableItem);
   }

   private boolean isActorsMovieSelected() {
      return actorMoviesItem != null && movie.getId() == actorMoviesItem.getId();
   }


   @Override
   public void bindAttributes(StringProperty name, StringProperty genre, StringProperty year) {
      this.name = name;
      this.genre = genre;
      this.year = year;
   }

   @Override
   public void delete() {
      MainObservable.getDaoMovieXml().delete(MainObservable.getSelectedMovie());
   }

   @Override
   public void create() {
      if (actorTableItem != null) {
         updateActorsMovie(movie);
         MainObservable.toggleActor();
         MainObservable.getActorTable().getSelectionModel().clearSelection();
      } else {
         movie.setId(MainObservable.getNewMovieId());
         update(movie);
         MainObservable.toggleMovie();
         MainObservable.getMovieTable().getSelectionModel().clearSelection();
      }
   }

   @Override
   public void update(Movie t) {
      setValues(movie);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

   @Override
   public void setValues(Movie movie) {
      movie.setName(name);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
   }

}
