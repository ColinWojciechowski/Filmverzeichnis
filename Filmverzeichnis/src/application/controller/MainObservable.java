package application.controller;


public class MainObservable {

   private static MainController main;

   public MainObservable(MainController main){
      MainObservable.main = main;
   }

   public static void toggleMovie(){
      main.toggle(main.getMovieStack(), main.getMovieTopDrawer());
   }

   public static void toggleActor(){
      main.toggle(main.getActorStack(), main.getActorTopDrawer());
   }

}


/**
 * $ID: ControllerObserver.java,v $
 */
