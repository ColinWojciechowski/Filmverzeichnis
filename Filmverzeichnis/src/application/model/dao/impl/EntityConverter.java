package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;
import application.model.entity.EntityMovie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntityConverter {


   public static Movie getMovie(EntityMovie entity) {
      Movie movie = new Movie();
      movie.setId(entity.getId());
      movie.setName(new SimpleStringProperty(entity.getName()));
      movie.setReleaseYear(new SimpleIntegerProperty(entity.getReleaseYear()));
      movie.setActors(new ArrayList<Actor>());

      return movie;
   }

   public static Movie getMovie(EntityMovie entity, List<Actor> actorList) {
      Movie movie = getMovie(entity);
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

   public static Actor getActor(EntityActor entity) {
      Actor actor = new Actor();
      actor.setId(entity.getId());
      actor.setBirthDate(new SimpleStringProperty(entity.getBirthDate()));
      actor.setName(new SimpleStringProperty(entity.getName()));
      actor.setSex(entity.getSex());
      actor.setMovies(new ArrayList<Movie>());
      return actor;
   }

   public static Actor getActor(EntityActor entity, List<Movie> movieList) {
      Actor actor = getActor(entity);
      for(Integer movieId : entity.getMovieIds()){
         addMovieToActor(movieList, actor, movieId);
      }

      return actor;
   }

   private static void addMovieToActor(List<Movie> movieList, Actor actor, Integer movieId) {
      for(Movie movie : movieList){
         if(movie.getId() == movieId.intValue()){
            actor.getMovies().add(movie);
         }
      }
   }
}
