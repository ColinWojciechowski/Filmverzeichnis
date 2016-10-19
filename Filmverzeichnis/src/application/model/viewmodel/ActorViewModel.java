package application.model.viewmodel;

import java.time.LocalDate;

import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author cw
 * @version 1.0
 */
public class ActorViewModel {

   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();

   public StringProperty getSex() {
      return sex;
   }

   public void setSex(StringProperty sex) {
      this.sex = sex;
   }

   public StringProperty getName() {
      return name;
   }

   public void setName(StringProperty name) {
      this.name = name;
   }

   /**
    * Erstellen eines Test-Films
    *
    * @return Ein Film, der zu Testzwecken erzeugt wurde
    * @see Movie
    * @since 1.0
    */
   public Movie getTestMovie() {
      Movie testMovie = new Movie();
      testMovie.setId(4);
      testMovie.setName(new SimpleStringProperty("Sleepy Hollow"));
      testMovie.setReleaseYear(new SimpleIntegerProperty(2120));
      return testMovie;
   }

   /**
    * Weist einem Schauspieler einen Film zu
    *
    * @param birth Geburtsdatum des Schauspielers
    * @since 1.0
    */
   public void addActor(LocalDate birth) {
      StringProperty birthDate = new SimpleStringProperty(birth.toString());
      Actor actor = new Actor();
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);
      // TODO Fachkonzept einbinden
   }

   public void createActor(LocalDate birth) {
      StringProperty birthDate = new SimpleStringProperty(birth.toString());
      Actor actor = new Actor();
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);
      // TODO Fachkonzept einbinden
   }

}
