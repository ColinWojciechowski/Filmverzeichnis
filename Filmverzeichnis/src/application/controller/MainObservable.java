package application.controller;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.fachkonzept.interfaces.IFachkonzept;

public class MainObservable {

   private static MainController main;

   public MainObservable(MainController main) {
      MainObservable.main = main;
   }

   public static void toggleMovie() {
      main.toggle(main.getMovieStack(), main.getMovieTopDrawer());
   }

   public static void toggleActor() {
      main.toggle(main.getActorStack(), main.getActorTopDrawer());
   }

   public IFachkonzept<Actor> getFachkonzeptActor() {
      return main.getViewModel().getFachkonzeptActor();
   }

   public IFachkonzept<Movie> getFachkonzeptMovie() {
      return main.getViewModel().getFachkonzeptMovie();
   }

   public static IDao<Actor> getDaoActorXml() {
      return main.getViewModel().getDaoActorXml();
   }

   public static IDao<Movie> getDaoMovieXml() {
      return main.getViewModel().getDaoMovieXml();
   }

   public static void refreshMainView() {
      main.getMovieTable().refresh();
      main.getActorTable().refresh();
      main.getMovieActorsTable().refresh();
      main.getActorMoviesTable().refresh();
   }

   public static int getMovieId() {
      if (main.getMovieTable().getSelectionModel().getSelectedItem() == null)
         return main.getMovieTable().getItems().size() + 1;
      else
         return main.getMovieTable().getSelectionModel().getSelectedItem().getId();
   }

   public static Movie getSelectedMovie(){
      return main.getMovieTable().getSelectionModel().getSelectedItem();
   }

}

/**
 * $ID: ControllerObserver.java,v $
 */
