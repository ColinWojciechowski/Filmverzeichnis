package application.model.viewmodel;

import application.model.dto.Movie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AddActorViewModel {

   public Movie getTestMovie(){
      Movie testMovie = new Movie();
      testMovie.setId(4);
      testMovie.setName(new SimpleStringProperty("Sleepy Hollow"));
      testMovie.setReleaseYear(new SimpleIntegerProperty(2120));
      return testMovie;
   }

}
