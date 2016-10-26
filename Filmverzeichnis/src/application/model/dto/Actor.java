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

   /** Identifikationsnummer des Schauspielers */
   private int id;

   /** Name des Schauspielers */
   private StringProperty name = new SimpleStringProperty();
   /** Geburtstag des Schauspielers */
   private StringProperty birthDate = new SimpleStringProperty();
   /** Geschlecht des Schauspielers */
   private StringProperty sex = new SimpleStringProperty();
   /** Liste aller Filme, in denen der Schauspieler mitwirkt */
   private List<Movie> movies;

   /**
    * Laden der Identifikationsnummer
    *
    * @return int
    * @since 1.0
    */
   public int getId() {
      return id;
   }

   /**
    * Setzen des Identifikationsnummer
    *
    * @param id Identifikationsnummer
    * @since 1.0
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * Laden des Namens
    *
    * @return StringProperty
    * @since 1.0
    */
   public StringProperty getName() {
      return name;
   }

   /**
    * Setzen des Namens
    *
    * @param name Namen
    * @since 1.0
    */
   public void setName(StringProperty name) {
      this.name = name;
   }

   /**
    * Laden des Geburtstags
    *
    * @return StringProperty
    * @since 1.0
    */
   public StringProperty getBirthDate() {
      return birthDate;
   }

   /**
    * Setzen des Geburtstags
    *
    * @param birthDate Geburtstags
    * @since 1.0
    */
   public void setBirthDate(StringProperty birthDate) {
      this.birthDate = birthDate;
   }

   /**
    * Laden des Geschlechts
    *
    * @return StringProperty
    * @since 1.0
    */
   public StringProperty getSex() {
      return sex;
   }

   /**
    * Setzen des Geschlechts
    *
    * @param sex Geschlechts
    * @since 1.0
    */
   public void setSex(String sex) {
      this.sex.set(sex);
   }

   /**
    * Laden der Liste von Filmen
    *
    * @return List
    * @since 1.0
    */
   public List<Movie> getMovies() {
      return movies;
   }

   /**
    * Setzen des Liste von Filmen
    *
    * @param movies Liste von Filmen
    * @since 1.0
    */
   public void setMovies(List<Movie> movies) {
      this.movies = movies;
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Comparable#compareTo(java.lang.Object)
    */
   @Override
   public int compareTo(Actor actor) {
      return this.name.get().compareTo(actor.getName().get());
   }
}
