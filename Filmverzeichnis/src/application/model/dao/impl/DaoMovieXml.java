package application.model.dao.impl;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityMovie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoMovieXml implements IDao<Movie> {	
	private List<Movie> dtoList;
	private List<EntityMovie> entityList;
	private IDao daoActor;
	
	public DaoMovieXml() {
		dtoList = new ArrayList<Movie>();
		entityList = new ArrayList<EntityMovie>();
		daoActor = new DaoActorXml();
	}
	
    @Override
    public void saveOrUpdate(Movie movie) {
    	addNewMovie(movie);    	
    	try {
			DaoXmlService.persistMovies(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void addNewMovie(Movie movie){
    	if(dtoList.contains(movie)){
    		deleteOldMovie(movie); 	
    	}    	    	
    	entityList.add(new EntityMovie(movie));
    	
    }

	private void deleteOldMovie(Movie movie) {
		EntityMovie oldEntity = null;
		for(EntityMovie entity : entityList){
			if(entity.getId() == movie.getId()){
				oldEntity = entity;
			}
		}
		entityList.remove(oldEntity);
		dtoList.remove(movie);
	}

    @Override
    public void saveOrUpdateAll(List<Movie> movieList) {
    	for(Movie movie : movieList){
    		addNewMovie(movie);
    	} 	
    	
    	try {
			DaoXmlService.persistMovies(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void delete(Movie movie) {
    	if(dtoList.contains(movie)){
    		deleteOldMovie(movie);
    	}
    	
    	try {
			DaoXmlService.persistMovies(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void deleteAll(List<Movie> movieList) {
    	dtoList.clear();
    	entityList.clear();
    	
    	try {
			DaoXmlService.persistMovies(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public List<Movie> getAll() {
    	dtoList.clear();
    	try {
			entityList = DaoXmlService.loadMovies();			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(entityList != null){	
    		fillDtoList();
    	} else {
    		return new ArrayList<Movie>();
    	}   		
    	
        return dtoList;
    }

	private void fillDtoList() {
		Movie currentMovie;
		for(EntityMovie entity : entityList){
			List<Actor> actors = daoActor.getAll();
			currentMovie = EntityConverter.getMovie(entity, actors);
			dtoList.add(currentMovie);
		}
	}
}
