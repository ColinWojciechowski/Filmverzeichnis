package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityMovie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntityToDtoConverterMovie {
   public static Movie convert(EntityMovie entity) {
      Movie movie = new Movie();
      movie.setId(entity.getId());
      movie.setName(new SimpleStringProperty(entity.getName()));
      movie.setReleaseYear(new SimpleIntegerProperty(entity.getReleaseYear()));
      movie.setActors(new ArrayList<Actor>());
      movie.setGenre(new SimpleStringProperty(entity.getGenre()));

      return movie;
   }

   public static Movie convert(EntityMovie entity, List<Actor> actorList) {
      Movie movie = convert(entity);
      for(Integer actorId : entity.getActorIds()){
         addActorToMovie(actorList, movie, actorId);
      }

      return movie;
   }

   private static void addActorToMovie(List<Actor> actorList, Movie movie, Integer actorId) {
      for(Actor actor : actorList){
         if(actor.getId() == actorId.intValue()){
            movie.getActors().add(actor);
         }
      }
   }
}
