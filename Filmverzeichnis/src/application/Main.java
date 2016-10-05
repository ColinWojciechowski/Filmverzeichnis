package application;
	
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import application.model.dao.impl.DaoActorXml;
import application.model.dao.impl.DaoMovieXml;
import application.model.dao.impl.DaoXmlService;
import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.dto.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("rootFXML.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Filmverzeichnis");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		ArrayList<Actor> actorList = new ArrayList<Actor>();
		
		Movie movie1 = new Movie();
		movie1.setId(1);
		movie1.setName("Fluch der Karibik");
		movie1.setReleaseYear(2006);
		movie1.setActors(new ArrayList<Actor>());
		movieList.add(movie1);
		
		Movie movie2 = new Movie();
		movie2.setId(2);
		movie2.setName("Batman Begins");
		movie2.setReleaseYear(2008);		
		movie2.setActors(new ArrayList<Actor>());
		movieList.add(movie2);
		
		Actor actor1 = new Actor();
		actor1.setId(1);
		actor1.setName("Johnny Depp");
		actor1.setBirthDate(new Date(1901, 01, 01));
		actor1.setMovies(new ArrayList<Movie>());
		actor1.setSex(Sex.MALE);
		actorList.add(actor1);
		
		Actor actor2 = new Actor();
		actor2.setId(2);
		actor2.setName("Katy Holmes");
		actor2.setBirthDate(new Date(1902, 02, 02));
		actor2.setMovies(new ArrayList<Movie>());		
		actor2.setSex(Sex.FEMALE);
		actorList.add(actor2);
		
		movie1.getActors().add(actor1);
		movie1.getActors().add(actor2);
		movie2.getActors().add(actor2);
		
		actor1.getMovies().add(movie1);
		actor2.getMovies().add(movie2);
		
		IDao daoMovie = new DaoMovieXml();
		IDao daoActor = new DaoActorXml();
		
		daoMovie.saveOrUpdateAll(movieList);
		daoActor.saveOrUpdateAll(actorList);
		
		actor2.setName("Manuel Neuer");
		daoActor.saveOrUpdateAll(actorList);
		
		ArrayList<Movie> movies = (ArrayList<Movie>) daoMovie.getAll();
		for (Movie movie : movies) {
			System.out.println(movie.getName());
			int actorId = 1;
			for (Actor actor : movie.getActors()) {
				System.out.println("Actor" + actorId + ": " + actor.getName());
				actorId++;
			}
		}
		
		launch(args);		
	}
}
