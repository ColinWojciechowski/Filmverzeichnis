package application.model.viewmodel;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActorViewModel implements IFachkonzept {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();
   StringProperty birthDate = new SimpleStringProperty();

   @Override
   public void add() {
      Actor actor = new Actor();
      actor.setId(MainObservable.getAddActorId());
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);
      actor.setMovies(new ArrayList<Movie>());
      for (Actor curActor : MainObservable.getDaoActorXml().getAll()) {
         if (actor.getId() == curActor.getId()) {
            if (MainObservable.getSelectedMovie() != null) {
               actor.getMovies().add(MainObservable.getSelectedMovie());
               MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
            }
            MainObservable.getDaoActorXml().saveOrUpdate(actor);
            return;
         }
      }
      actor.getMovies().add(MainObservable.getSelectedMovie());
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
      MainObservable.getSelectedMovie().getActors().add(actor);
      MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
      MainObservable.refreshMainView();
   }

   @Override
   public void saveOrUpdate() {
      Actor curActor = MainObservable.getSelectedActor();
      if (curActor != null) {
         curActor.setSex(sex.get());
         curActor.setName(name);
         curActor.setBirthDate(birthDate);
         MainObservable.getDaoActorXml().saveOrUpdate(curActor);
         MainObservable.refreshMainView();
      } else {
         Actor actor = new Actor();
         actor.setId(MainObservable.getNewActorId());
         actor.setName(name);
         actor.setSex(sex.get());
         actor.setBirthDate(birthDate);
         MainObservable.getDaoActorXml().saveOrUpdate(actor);
      }
   }

   @Override
   public void bindAttributes(StringProperty name, StringProperty sex, StringProperty birthDate) {
      this.name = name;
      this.sex = sex;
      this.birthDate = birthDate;
   }

}
