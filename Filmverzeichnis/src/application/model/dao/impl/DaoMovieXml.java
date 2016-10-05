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
		this.dtoList = new ArrayList<Movie>();
		this.entityList = new ArrayList<EntityMovie>();
		this.daoActor = new DaoActorXml(this);
	}
	
    public DaoMovieXml(DaoActorXml daoActorXml) {
    	this.dtoList = new ArrayList<Movie>();
    	this.entityList = new ArrayList<EntityMovie>();
		this.daoActor = daoActorXml;
	}

	@Override
    public void saveOrUpdate(Movie movie) {
    	addNewEntityMovie(movie);    	
    	dtoList = getAll();
    	saveOrUpdateAll(dtoList);
    }
    
    private void addNewEntityMovie(Movie movie){
    	if(dtoList.contains(movie)){
    		deleteOldMovie(movie); 	
    	}    	    
    	EntityMovie newEntity = createNewEntity(movie);    
    	entityList.add(newEntity);	
    }

	private EntityMovie createNewEntity(Movie movie) {
		EntityMovie newEntity = new EntityMovie();
    	newEntity.setId( movie.getId());
    	newEntity.setName(movie.getName());
    	newEntity.setReleaseYear(movie.getReleaseYear());
    	newEntity.setActorIds(new ArrayList<Integer>());
    	
    	for(Actor actor : movie.getActors()){
    		newEntity.getActorIds().add(new Integer(actor.getId()));
    	}
    	return newEntity;
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
    		addNewEntityMovie(movie);
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
			List<Actor> actors = daoActor.getAllWithoutRelations();
			currentMovie = EntityConverter.getMovie(entity, actors);
			dtoList.add(currentMovie);
		}
	}

	@Override
	public List<Movie> getAllWithoutRelations() {
    	dtoList.clear();
    	try {
			entityList = DaoXmlService.loadMovies();			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(entityList != null){	
    		fillDtoListWithoutRelations();
    	} else {
    		return new ArrayList<Movie>();
    	}   		
    	
        return dtoList;
	}
	
	private void fillDtoListWithoutRelations() {
		Movie currentMovie;
		for(EntityMovie entity : entityList){
			currentMovie = EntityConverter.getMovie(entity);
			dtoList.add(currentMovie);
		}
	}
}
