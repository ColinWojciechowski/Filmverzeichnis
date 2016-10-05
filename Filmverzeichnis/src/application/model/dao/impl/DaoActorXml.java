package application.model.dao.impl;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoActorXml implements IDao<Actor> {
	private List<Actor> dtoList;
	private List<EntityActor> entityList;
	private IDao daoMovie;
	
	public DaoActorXml() {
		dtoList = new ArrayList<Actor>();
		entityList = new ArrayList<EntityActor>();
		daoMovie = new DaoMovieXml();
	}
	
    @Override
    public void saveOrUpdate(Actor actor) {
    	addNewActor(actor);    	
    	try {
			DaoXmlService.persistActors(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void addNewActor(Actor actor){
    	if(dtoList.contains(actor)){
    		deleteOldActor(actor); 	
    	}    	    	
    	entityList.add(new EntityActor(actor));    	
    }    
    
	private void deleteOldActor(Actor actor) {
		EntityActor oldEntity = null;
		for(EntityActor entity : entityList){
			if(entity.getId() == actor.getId()){
				oldEntity = entity;
			}
		}
		entityList.remove(oldEntity);
		dtoList.remove(actor);
	}

    @Override
    public void saveOrUpdateAll(List<Actor> actorList) {
    	for(Actor actor : actorList){
    		addNewActor(actor);
    	} 	
    	
    	try {
			DaoXmlService.persistActors(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void delete(Actor actor) {
    	if(dtoList.contains(actor)){
    		deleteOldActor(actor);
    	}
    	
    	try {
			DaoXmlService.persistActors(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void deleteAll(List<Actor> dtoList) {
    	dtoList.clear();
    	entityList.clear();
    	
    	try {
			DaoXmlService.persistActors(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public List<Actor> getAll() {
    	dtoList.clear();
    	try {
			entityList = DaoXmlService.loadActors();			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	if(entityList != null){	
    		fillDtoList();
    	} else {
    		return new ArrayList<Actor>();
    	}   		
    	
        return dtoList;
    }
    
    private void fillDtoList(){
		Actor currentActor;
		for(EntityActor entity : entityList){
			List<Movie> movies = daoMovie.getAll();
			currentActor = EntityConverter.getActor(entity, movies);
			dtoList.add(currentActor);
		}
    }
}
