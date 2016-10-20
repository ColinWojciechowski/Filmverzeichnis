package application.view;

import application.controller.MainController;
import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.fachkonzept.interfaces.IFachkonzept;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {

   private IFachkonzept<Actor> fachkonzeptActor;
   private IFachkonzept<Movie> fachkonzeptMovie;
   private IDao<Actor> daoActorXml;
   private IDao<Movie> daoMovieXml;

   @Override
   public void start(Stage primaryStage) {
      try {
         primaryStage.setResizable(false);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/rootFXML.fxml"));
         MainController mainController = new MainController();
         loader.setController(mainController);
         Pane root = (Pane) loader.load();
         mainController.getViewModel().setFachkonzept(fachkonzeptActor, fachkonzeptMovie);
         mainController.getViewModel().setDatenhaltung(daoActorXml, daoMovieXml);
         Scene scene = new Scene(root);
         primaryStage.setTitle("Filmverzeichnis");
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void startGUI() {
      launch();
   }

   public void setFachkonzept(IFachkonzept<Actor> fachkonzeptActor, IFachkonzept<Movie> fachkonzeptMovie) {
      this.fachkonzeptActor = fachkonzeptActor;
      this.fachkonzeptMovie = fachkonzeptMovie;
   }

   public void setDatenhaltung(IDao<Actor> daoActorXml, IDao<Movie> daoMovieXml) {
      this.daoActorXml = daoActorXml;
      this.daoMovieXml = daoMovieXml;
   }
}

/**
 * $ID: Entrypoint.java,v $
 */
