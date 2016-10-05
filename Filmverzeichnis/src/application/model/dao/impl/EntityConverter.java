package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;
import application.model.entity.EntityMovie;

public class EntityConverter {

	public static Movie getMovie(EntityMovie entity, List<Actor> actorList) {
		Movie movie = new Movie();
		movie.setId(entity.getId());
		movie.setName(entity.getName());
		movie.setReleaseYear(entity.getReleaseYear());
		movie.setActors(new ArrayList<Actor>());
		
		for(Integer actorId : entity.getActors()){
			addActorToMovie(actorList, movie, actorId);
		}
		
		return movie;
	}

	private static void addActorToMovie(List<Actor> actorList, Movie movie, Integer actorId) {
		for(Actor actor : actorList){
			if(actor.getId() == actorId){
				movie.getActors().add(actor);
			}
		}
	}
	
	public static Actor getActor(EntityActor entity, List<Movie> movieList) {
		Actor actor = new Actor();
		actor.setId(entity.getId());
		actor.setBirthDate(entity.getBirthDate());
		actor.setName(entity.getName());
		actor.setSex(entity.getSex());
				
		for(Integer movieId : entity.getMovies()){
			addMovieToActor(movieList, actor, movieId);
		}
		
		return actor;
	}

	private static void addMovieToActor(List<Movie> movieList, Actor actor, Integer movieId) {
		for(Movie movie : movieList){
			if(movie.getId() == movieId){
				actor.getMovies().add(movie);
			}
		}
	}

}
