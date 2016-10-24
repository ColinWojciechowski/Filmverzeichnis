package application.model.viewmodel;

import application.controller.MainObservable;
import application.model.dto.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NewMovieViewModel {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty title = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   IntegerProperty year = new SimpleIntegerProperty();

   public void addMovie() {
      Movie movie = new Movie();
//      movie.setId(MainObservable.getId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      //TODO Fachkonzept einbinden
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


   public void createMovie() {
      Movie movie = new Movie();
      movie.setId(MainObservable.getId());
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
      MainObservable.getDaoMovieXml().saveOrUpdate(movie);
   }

}


/**
 * $ID: NewMovieViewModel.java,v $
 */
