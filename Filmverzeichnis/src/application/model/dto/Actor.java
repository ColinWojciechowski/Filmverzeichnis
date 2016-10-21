package application.model.dto;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class Actor implements Comparable<Actor>{
    private int id;
    private StringProperty name = new SimpleStringProperty();
    private StringProperty birthDate = new SimpleStringProperty();
//    private Date birthDate;
    private StringProperty sex = new SimpleStringProperty();
//    private Sex sex;
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
        LocalDate d = LocalDate.now();
        birthDate.set(d.toString());
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
