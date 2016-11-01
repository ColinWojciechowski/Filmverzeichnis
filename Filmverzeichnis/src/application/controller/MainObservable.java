package application.controller;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.scene.control.TableView;

public class MainObservable {

   private static MainController main;

   public static void setMainObservable(MainController mainController) {
      main = mainController;
   }

   public static void toggleMovie() {
      main.toggle(main.getMovieStack(), main.getMovieTopDrawer());
   }

   public static void toggleActor() {
      main.toggle(main.getActorStack(), main.getActorTopDrawer());
   }

   public static void refreshMainView() {
      main.prepareTable();
      main.getMovieTable().refresh();
      main.getActorTable().refresh();
      main.getMovieActorsTable().refresh();
      main.getActorMoviesTable().refresh();
   }

   public static int getNewMovieId() {
      int movieId = 0;
      if (main.getMovieTable().getSelectionModel().getSelectedItem() == null) {
         for (Movie curMovie : main.getViewModel().getDaoMovieXml().getAll()) {
            if (curMovie.getId() > movieId)
               movieId = curMovie.getId();
         }
         return movieId + 1;
      } else
         return main.getMovieTable().getSelectionModel().getSelectedItem().getId();
   }

   public static int getNewActorId() {
      int actorId = 0;
      if (main.getActorTable().getSelectionModel().getSelectedItem() == null) {
         for (Actor curActor : main.getViewModel().getDaoActorXml().getAll()) {
            if (curActor.getId() > actorId)
               actorId = curActor.getId();
         }
         return actorId + 1;
      } else
         return main.getActorTable().getSelectionModel().getSelectedItem().getId();
   }

   public static int getAddMovieId() {
      int movieId = 0;
      if (main.getActorMoviesTable().getSelectionModel().getSelectedItem() == null) {
         for (Movie curMovie : main.getViewModel().getDaoMovieXml().getAll()) {
            if (curMovie.getId() > movieId)
               movieId = curMovie.getId();
         }
         return movieId + 1;
      } else
         return main.getActorMoviesTable().getSelectionModel().getSelectedItem().getId();
   }

   public static int getAddActorId() {
      int actorId = 0;
      if (main.getMovieActorsTable().getSelectionModel().getSelectedItem() == null) {
         for (Actor curActor : main.getViewModel().getDaoActorXml().getAll()) {
            if (curActor.getId() > actorId)
               actorId = curActor.getId();
         }
         return actorId + 1;
      } else
         return main.getMovieActorsTable().getSelectionModel().getSelectedItem().getId();
   }

   public static TableView<Movie> getMovieTable(){
      return main.getMovieTable();
   }

   public static TableView<Actor> getActorTable(){
      return main.getActorTable();
   }

   public static Movie getSelectedMovie() {
      return main.getMovieTable().getSelectionModel().getSelectedItem();
   }

   public static Actor getSelectedActor() {
      return main.getActorTable().getSelectionModel().getSelectedItem();
   }

   public static IDao<Actor> getDaoActorXml() {
      return main.getViewModel().getDaoActorXml();
   }

   public static IDao<Movie> getDaoMovieXml() {
      return main.getViewModel().getDaoMovieXml();
   }
}

/**
 * $ID: ControllerObserver.java,v $
 */
