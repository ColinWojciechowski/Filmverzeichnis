package application.model.viewmodel.impl;

import java.util.ArrayList;

import application.controller.MainObservable;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.viewmodel.interfaces.IFachkonzept;
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
   public void persist() {
      Actor curActor = MainObservable.getSelectedActor();
      Movie curMovie = MainObservable.getSelectedMovie();
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
         if(curMovie != null){
            actor.setMovies(new ArrayList<Movie>());
            for (Actor curActor2 : MainObservable.getDaoActorXml().getAll()) {
               if (actor.getId() == curActor2.getId()) {
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
