package application.model.viewmodel;

import application.model.dto.Movie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

	private ObservableList<Movie> movieData = FXCollections.observableArrayList();
	
	public MainViewModel(){
		Movie testMovie = new Movie();
		Movie testMovie2 = new Movie();
		
		testMovie.setId(1);
		testMovie2.setId(2);
		
		testMovie.setName(new SimpleStringProperty("Scary Movie"));
		testMovie2.setName(new SimpleStringProperty("Pulp Fiction"));
		
		testMovie.setReleaseYear(new SimpleIntegerProperty(2005));
		testMovie2.setReleaseYear(new SimpleIntegerProperty(1998));
		
		movieData.add(testMovie);
		movieData.add(testMovie2);

	}
	
	public ObservableList<Movie> getMovieData(){
		return movieData;
	}
	
}
