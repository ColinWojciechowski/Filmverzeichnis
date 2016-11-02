package application.model.dto;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

/**
 * DTO fuer die Verarbeitung der Daten eines Schauspielers
 *
 * @author Kay Gerlitzki
 * @version 1.0
 */
public class Actor implements Comparable<Actor> {

   private int id;
   private StringProperty name = new SimpleStringProperty();
   private StringProperty birthDate = new SimpleStringProperty();
   private StringProperty sex = new SimpleStringProperty();
   private List<Movie> movies;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public StringProperty getName() {
      return name;
   }

   public void setName(StringProperty name) {
      this.name = name;
   }

   public StringProperty getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(StringProperty birthDate) {
      this.birthDate = birthDate;
   }

   public StringProperty getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex.set(sex);
   }

   public List<Movie> getMovies() {
      return movies;
   }

   public void setMovies(List<Movie> movies) {
      this.movies = movies;
   }

   @Override
   public int compareTo(Actor actor) {
      return this.name.get().compareTo(actor.getName().get());
   }
}
