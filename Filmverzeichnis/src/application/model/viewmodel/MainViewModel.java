package application.model.viewmodel;

import java.util.Date;

import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

	private ObservableList<Movie> movieData = FXCollections.observableArrayList();
	private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
	private ObservableList<Movie> actorMovies = FXCollections.observableArrayList();
	
	public MainViewModel(){
		Movie testMovie = new Movie();
		Movie testMovie2 = new Movie();
		Actor testActor = new Actor();
		
		testMovie.setId(1);
		testMovie2.setId(2);
		testActor.setId(1);
		
		testMovie.setName(new SimpleStringProperty("Scary Movie"));
		testMovie2.setName(new SimpleStringProperty("Pulp Fiction"));
		testActor.setName(new SimpleStringProperty("Harrisson Ford"));
		
		testMovie.setReleaseYear(new SimpleIntegerProperty(2005));
		testMovie2.setReleaseYear(new SimpleIntegerProperty(1998));
		testActor.setBirthDate(new Date());
		
		movieActors.add(testActor);
		actorMovies.add(testMovie);
		testMovie.setActors(movieActors);
		testActor.setMovies(actorMovies);
		
		movieData.add(testMovie);
		movieData.add(testMovie2);

	}
	
	public ObservableList<Movie> getMovieData(){
		return movieData;
	}
	
	public ObservableList<Actor> getActorData(){
		return movieActors;
	}
	
}
