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
		launch(args);		
	}
}
