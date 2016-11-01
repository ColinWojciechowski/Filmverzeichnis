package application.model.viewmodel;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieViewModel implements IFachkonzept{

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty title = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   StringProperty year = new SimpleStringProperty();

   @Override
   public void create() {
      Movie movie = new Movie();
      movie.setId(MainObservable.getNewMovieId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

   @Override
   public void add() {
      Movie movie = new Movie();
      movie.setId(MainObservable.getAddMovieId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      movie.setActors(new ArrayList<Actor>());
      for (Movie curMovie : MainObservable.getDaoMovieXml().getAll()) {
         if (movie.getId() == curMovie.getId()) {
            if (MainObservable.getSelectedActor() != null) {
               movie.getActors().add(MainObservable.getSelectedActor());
               MainObservable.getDaoActorXml().saveOrUpdate(MainObservable.getSelectedActor());
            }
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

   @Override
   public void edit() {
      Movie curMovie = MainObservable.getSelectedMovie();
      if (curMovie != null) {
         curMovie.setName(title);
         curMovie.setGenre(genre);
         curMovie.setReleaseYear(year);
         MainObservable.getDaoMovieXml().saveOrUpdate(curMovie);
         MainObservable.refreshMainView();
      } else {
         create();
      }
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty genre, StringProperty year) {
      this.title = name;
      this.genre = genre;
      this.year = year;
   }

}
