package application.model.viewmodel;

import application.model.dao.impl.DaoActorXml;
import application.model.dao.impl.DaoMovieXml;
import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

   private ObservableList<Movie> movieData = FXCollections.observableArrayList();
   private ObservableList<Actor> movieActors = FXCollections.observableArrayList();
   private IDao<Actor> daoActorXml;
   private IDao<Movie> daoMovieXml;

   public MainViewModel() {
      setDatenhaltung(new DaoActorXml(), new DaoMovieXml());
   }

   public ObservableList<Movie> getMovieData() {
      return movieData;
   }

   public ObservableList<Actor> getActorData() {
      return movieActors;
   }

   public void setDatenhaltung(IDao<Actor> daoActorXml, IDao<Movie> daoMovieXml) {
      this.daoActorXml = daoActorXml;
      this.daoMovieXml = daoMovieXml;
   }

   public IDao<Actor> getDaoActorXml() {
      return daoActorXml;
   }

   public IDao<Movie> getDaoMovieXml() {
      return daoMovieXml;
   }

}
