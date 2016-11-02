package application.model.viewmodel.impl;

import java.util.ArrayList;

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

   @Override
   public void persist() {
      Movie curMovie = MainObservable.getSelectedMovie();
      Actor curActor = MainObservable.getSelectedActor();
      if (curMovie != null) {
         curMovie.setName(title);
         curMovie.setGenre(genre);
         curMovie.setReleaseYear(year);
         MainObservable.getDaoMovieXml().saveOrUpdate(curMovie);
         MainObservable.refreshMainView();
      } else {
         Movie movie = new Movie();
         movie.setId(MainObservable.getNewMovieId());
         movie.setName(title);
         movie.setGenre(genre);
         movie.setReleaseYear(year);
         if (curActor != null) {
            movie.setActors(new ArrayList<Actor>());
            for (Movie curMovie2 : MainObservable.getDaoMovieXml().getAll()) {
               if (movie.getId() == curMovie2.getId()) {
                  movie.getActors().add(MainObservable.getSelectedActor());
                  MainObservable.getDaoActorXml().saveOrUpdate(MainObservable.getSelectedActor());
                  MainObservable.getDaoMovieXml().saveOrUpdate(movie);
                  return;
               }
            }
            movie.getActors().add(MainObservable.getSelectedActor());
            MainObservable.getDaoMovieXml().saveOrUpdate(movie);
            MainObservable.getSelectedActor().getMovies().add(movie);
            MainObservable.getDaoActorXml().saveOrUpdate(MainObservable.getSelectedActor());
            MainObservable.refreshMainView();
         }
         MainObservable.getDaoMovieXml().saveOrUpdate(movie);
      }
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty genre, StringProperty year) {
      this.title = name;
      this.genre = genre;
      this.year = year;
   }

}
