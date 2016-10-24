package application.model.viewmodel;

import java.time.LocalDate;

import application.controller.MainObservable;
import application.model.dto.Actor;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author cw
 * @version 1.0
 */
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

   /**
    * Weist einem Schauspieler einen Film zu
    *
    * @param birth Geburtsdatum des Schauspielers
    * @since 1.0
    */
   public void addActor(LocalDate birth) {
      StringProperty birthDate = new SimpleStringProperty(birth.toString());
      Actor actor = new Actor();
      actor.setSex(sex.get());
      actor.setName(name);
      actor.setBirthDate(birthDate);
      MainObservable.getDaoActorXml().saveOrUpdate(actor);
      MainObservable.getSelectedMovie().getActors().add(actor);
      MainObservable.getDaoMovieXml().saveOrUpdate(MainObservable.getSelectedMovie());
      MainObservable.refreshMainView();
//       MainObservable.getDaoActorXml().saveOrUpdate(actor);
      // TODO: Methode, die einem Film diesen Schauspieler zuordnet in der Impl der IDao erzeugen
   }



}
