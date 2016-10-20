package application;

import application.model.dao.impl.DaoActorXml;
import application.model.dao.impl.DaoMovieXml;
import application.model.fachkonzept.impl.FachkonzeptActor;
import application.model.fachkonzept.impl.FachkonzeptMovie;
import application.view.GUI;

public class Main  {
   public static void main(String[] args) {
      GUI gui = new GUI();
      gui.setFachkonzept(new FachkonzeptActor(), new FachkonzeptMovie());
      gui.setDatenhaltung(new DaoActorXml(), new DaoMovieXml());
      gui.startGUI();
   }
}
