package application.model.viewmodel;

import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActorViewModel {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();
   StringProperty birthDate = new SimpleStringProperty();

   public void createActor(LocalDate birth) {
      birthDate.set(birth.toString());
      Actor actor = new Actor();
      actor.setId(MainObservable.getNewActorId());
      actor.setName(name);
      actor.setSex(sex.get());
      actor.setBirthDate(birthDate);
      for (Actor curActor : MainObservable.getDaoActorXml().getAll()) {
         if (actor.getId() == curActor.getId())
            actor.setId(MainObservable.getAddActorId());
         curActor.setSex(sex.get());
         curActor.setName(name);
         curActor.setBirthDate(birthDate);
         MainObservable.getDaoActorXml().saveOrUpdate(curActor);
         curActor.getMovies().add(MainObservable.getSelectedMovie());
         MainObservable.getDaoActorXml().saveOrUpdate(curActor);
         MainObservable.getSelectedMovie().getActors().add(curActor);
         return;
      }
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
   }

   public void addActor(LocalDate birth) {
      StringProperty birthDate = new SimpleStringProperty(birth.toString());
      Actor actor = new Actor();
      actor.setId(MainObservable.getAddActorId());
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);
      actor.setMovies(new ArrayList<Movie>());
      for (Actor curActor : MainObservable.getDaoActorXml().getAll()) {
         if (actor.getId() == curActor.getId()) {
            curActor.setSex(sex.get());
            curActor.setName(name);
            curActor.setBirthDate(birthDate);
            MainObservable.getDaoActorXml().saveOrUpdate(curActor);
            MainObservable.refreshMainView();
            return;
         }
      }
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
      MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
      MainObservable.refreshMainView();
   }

   public StringProperty getSex() {
      return sex;
   }

   public void setSex(StringProperty sex) {
      this.sex = sex;
   }

   public StringProperty getName() {
      return name;
   }

   public void setName(StringProperty name) {
      this.name = name;
   }

}
