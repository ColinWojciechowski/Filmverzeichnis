package application.model.dto;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class Movie implements Comparable<Movie>{
    private int id;
    private StringProperty name = new SimpleStringProperty();
    private StringProperty releaseYear = new SimpleStringProperty();
    private StringProperty genre = new SimpleStringProperty();
    private List<Actor> actors;

    public int getId() {
        return id;
    }

    public StringProperty getReleaseYear() {
      return releaseYear;
   }

   public void setReleaseYear(StringProperty releaseYear) {
      this.releaseYear = releaseYear;
   }

    public StringProperty getName() {
      return name;
   }

   public void setName(StringProperty name) {
      this.name = name;
   }

   public void setId(int id) {
        this.id = id;
    }

   public List<Actor> getActors() {
      return actors;
   }

   public void setActors(List<Actor> actors) {
      this.actors = actors;
   }

   public StringProperty getGenre() {
      return genre;
   }

   public void setGenre(StringProperty genre) {
      this.genre = genre;
   }

   @Override
   public int compareTo(Movie movie) {
      return this.name.get().compareTo(movie.name.get());
   }

}
