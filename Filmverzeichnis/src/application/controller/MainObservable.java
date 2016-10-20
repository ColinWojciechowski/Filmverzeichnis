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

   public static void getFachkonzept(){
      main.getViewModel().getFachkonzept();
   }

   public static void getDaoActorXml(){
      main.getViewModel().getDaoActorXml();
   }

   public static void getDaoMovieXml(){
      main.getViewModel().getDaoMovieXml();
   }

}


/**
 * $ID: ControllerObserver.java,v $
 */
