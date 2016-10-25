package application.model.viewmodel;

import application.model.dao.impl.DaoActorXml;
import application.model.dao.impl.DaoMovieXml;
import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.fachkonzept.impl.FachkonzeptActor;
import application.model.fachkonzept.impl.FachkonzeptMovie;
import application.model.fachkonzept.interfaces.IFachkonzept;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

   private ObservableList<Movie> movieData = FXCollections.observableArrayList();
   private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
   private IFachkonzept<Actor> fachkonzeptActor;
   private IFachkonzept<Movie> fachkonzeptMovie;
   private IDao<Actor> daoActorXml;
   private IDao<Movie> daoMovieXml;

   public MainViewModel() {
      setFachkonzept(new FachkonzeptActor(), new FachkonzeptMovie());
      setDatenhaltung(new DaoActorXml(), new DaoMovieXml());
   }

   public ObservableList<Movie> getMovieData() {
      return movieData;
   }

   public ObservableList<Actor> getActorData() {
      return movieActors;
   }

   public void setFachkonzept(IFachkonzept<Actor> fachkonzeptActor, IFachkonzept<Movie> fachkonzeptMovie) {
      this.fachkonzeptActor = fachkonzeptActor;
      this.fachkonzeptMovie = fachkonzeptMovie;
   }

   public void setDatenhaltung(IDao<Actor> daoActorXml, IDao<Movie> daoMovieXml) {
      this.daoActorXml = daoActorXml;
      this.daoMovieXml = daoMovieXml;
   }

   public IFachkonzept<Actor> getFachkonzeptActor() {
      return fachkonzeptActor;
   }


   public IFachkonzept<Movie> getFachkonzeptMovie() {
      return fachkonzeptMovie;
   }

   public IDao<Actor> getDaoActorXml() {
      return daoActorXml;
   }

   public IDao<Movie> getDaoMovieXml() {
      return daoMovieXml;
   }

}
