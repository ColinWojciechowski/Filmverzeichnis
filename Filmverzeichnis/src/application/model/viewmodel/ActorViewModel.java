package application.model.viewmodel;

import java.time.LocalDate;

import application.controller.MainObservable;
import application.model.dto.Actor;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActorViewModel {

   IntegerProperty id = new SimpleIntegerProperty();
   StringProperty sex = new SimpleStringProperty();
   StringProperty name = new SimpleStringProperty();
   StringProperty birthDate = new SimpleStringProperty();

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

   public void createActor(LocalDate birth) {
      birthDate.set(birth.toString());
      Actor actor = new Actor();
      actor.setId(5);
      actor.setName(name);
      actor.setSex(sex.get());
      actor.setBirthDate(birthDate);
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
   }

   public void addActor(LocalDate birth) {
      boolean overrideActor = false;
      StringProperty birthDate = new SimpleStringProperty(birth.toString());
      Actor actor = new Actor();
      System.out.println(MainObservable.getAddActorId());
      actor.setId(MainObservable.getAddActorId());
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);

      for (Actor curActor : MainObservable.getDaoActorXml().getAll()) {
         if (actor.getId() == curActor.getId())
            overrideActor = true;
      }
      if (overrideActor == true) {
         MainObservable.getDaoActorXml().saveOrUpdate(actor);
         MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
         MainObservable.refreshMainView();
      } else {
         MainObservable.getDaoActorXml().saveOrUpdate(actor);
         MainObservable.getSelectedMovie().getActors().add(actor);
         MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
         MainObservable.refreshMainView();
      }

   }

}
