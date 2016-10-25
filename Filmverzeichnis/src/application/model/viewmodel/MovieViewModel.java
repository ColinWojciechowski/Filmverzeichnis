package application.model.viewmodel;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.dto.enums.Sex;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieViewModel {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty title = new SimpleStringProperty();
   StringProperty genre = new SimpleStringProperty();
   IntegerProperty year = new SimpleIntegerProperty();

   public Actor getTestActor(){
      Actor testActor = new Actor();
      testActor.setId(4);
      testActor.setName(new SimpleStringProperty("Jonny Banana"));
      testActor.setSex(Sex.FEMALE.toString());
      return testActor;
   }

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
      movie.setName(title);
      movie.setGenre(genre);
      movie.setReleaseYear(year);
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
