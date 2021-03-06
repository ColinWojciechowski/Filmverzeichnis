package application.model.viewmodel.impl;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.interfaces.IFachkonzept;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActorViewModel implements IFachkonzept<Actor> {

   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();
   StringProperty birthDate = new SimpleStringProperty();
   Movie movieTableItem = MainObservable.getSelectedMovie();
   Actor actorTableItem = MainObservable.getSelectedActor();
   Actor movieActorsItem = MainObservable.getMovieActorsTableItem();
   Actor actor = new Actor();

   @Override
   public void persist() {
      if (actorTableItem == null)
         create();
      else {
         update(actorTableItem);
         MainObservable.toggleActor();
      }
   }

   private void updateMoviesActor(Actor actor) {
      actor.setId(MainObservable.getAddActorId());
      actor.setMovies(new ArrayList<Movie>());
      if (!isMoviesActorSelected()) {
         movieTableItem.getActors().add(actor);
         actor.getMovies().add(movieTableItem);
         update(actor);
      } else {
         setValues(movieActorsItem);
         movieActorsItem.getMovies().add(movieTableItem);
         MainObservable.getDaoActorXml().saveOrUpdate(movieActorsItem);
      }
      MainObservable.getDaoMovieXml().saveOrUpdate(movieTableItem);
   }

   private boolean isMoviesActorSelected() {
      return movieActorsItem != null;
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty sex, StringProperty birthDate) {
      this.name = name;
      this.sex = sex;
      this.birthDate = birthDate;
   }

   @Override
   public void delete() {
      MainObservable.getDaoActorXml().delete(MainObservable.getSelectedActor());
   }

   @Override
   public void create() {
      if (movieTableItem != null) {
         updateMoviesActor(actor);
         MainObservable.toggleMovie();
      } else {
         update(actor);
         MainObservable.toggleActor();
      }
   }

   @Override
   public void update(Actor actor) {
      actor.setId(MainObservable.getNewActorId());
      setValues(actor);
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
   }

   @Override
   public void setValues(Actor actor) {
      actor.setName(name);
      actor.setSex(sex.get());
      actor.setBirthDate(birthDate);
   }

}
