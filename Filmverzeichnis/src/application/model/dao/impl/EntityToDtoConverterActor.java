package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;
import javafx.beans.property.SimpleStringProperty;

public class EntityToDtoConverterActor {
	public static Actor convert(EntityActor entity) {
		Actor actor = new Actor();
		actor.setId(entity.getId());
		actor.setBirthDate(new SimpleStringProperty(entity.getBirthDate()));
		actor.setName(new SimpleStringProperty(entity.getName()));
		actor.setSex(entity.getSex());
		actor.setMovies(new ArrayList<Movie>());
		return actor;
	}

	public static Actor convert(EntityActor entity, List<Movie> movieList) {
		Actor actor = convert(entity);
		for (Integer movieId : entity.getMovieIds()) {
			addMovieToActor(movieList, actor, movieId);
		}

		return actor;
	}

	private static void addMovieToActor(List<Movie> movieList, Actor actor, Integer movieId) {
		for (Movie movie : movieList) {
			if (movie.getId() == movieId.intValue()) {
				actor.getMovies().add(movie);
			}
		}
	}
}
