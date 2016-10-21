package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dao.interfaces.AbstractDaoXml;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityMovie;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoMovieXml extends AbstractDaoXml<Movie, EntityMovie, Actor> {	
	public DaoMovieXml() {
		this.dtoList = new ArrayList<Movie>();
		this.entityList = new ArrayList<EntityMovie>();
		this.dao = new DaoActorXml(this);
	}
	
    public DaoMovieXml(DaoActorXml daoActorXml) {
    	this.dtoList = new ArrayList<Movie>();
    	this.entityList = new ArrayList<EntityMovie>();
		this.dao = daoActorXml;
	}

	@Override
    public void saveOrUpdate(Movie movie) {
    	dtoList = getAll();
    	dtoList.add(movie);
    	saveOrUpdateAll(dtoList);
    }
	
    @Override
    public void saveOrUpdateAll(List<Movie> movieList) {
    	entityList.clear();
    	dtoList = movieList;
    	
    	for(Movie movie : movieList){
    		addNewEntity(movie);
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
    		deleteDto(movie);
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

	@Override
	protected Movie convertEntityToDto(EntityMovie entity, List<Actor> actors) {
		return EntityToDtoConverterMovie.convert(entity, actors);
	}

	@Override
	protected Movie convertEntityToDto(EntityMovie entity) {
		return EntityToDtoConverterMovie.convert(entity);
	}

	@Override
	protected EntityMovie createNewEntity(Movie movie) {
		EntityMovie newEntity = new EntityMovie();
    	newEntity.setId( movie.getId());
    	newEntity.setName(movie.getName().get());
    	newEntity.setReleaseYear(movie.getReleaseYear().get());
    	newEntity.setActorIds(new ArrayList<Integer>());
    	
    	if(movie.getActors() != null){
        	for(Actor actor : movie.getActors()){
        		newEntity.getActorIds().add(new Integer(actor.getId()));
        	}
    	}
    	return newEntity;    		
	}
	
	@Override
	protected boolean isEntityIdEqualDtoId(Movie dto, EntityMovie entity) {
		return entity.getId() == dto.getId();
	}

	@Override
	protected List<EntityMovie> loadEntityList() throws Exception {
		return DaoXmlService.loadMovies();
	}  
   
}
