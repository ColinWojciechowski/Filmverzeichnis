package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dao.interfaces.AbstractDaoXml;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoActorXml extends AbstractDaoXml<Actor, EntityActor, Movie> {
	public DaoActorXml() {
		this.dtoList = new ArrayList<Actor>();
		this.entityList = new ArrayList<EntityActor>();
		this.dao = new DaoMovieXml(this);
	}

	public DaoActorXml(DaoMovieXml daoMovieXml) {
		this.dtoList = new ArrayList<Actor>();
		this.entityList = new ArrayList<EntityActor>();
		this.dao = daoMovieXml;
	}

	@Override
	public void saveOrUpdate(Actor actor) {
		dtoList = getAll();
		dtoList.add(actor);
		saveOrUpdateAll(dtoList);
	}

	@Override
	public void saveOrUpdateAll(List<Actor> actorList) {
		entityList.clear();
		dtoList = actorList;

		for (Actor actor : actorList) {
			addNewEntity(actor);
		}

		try {
			DaoXmlService.persistActors(entityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Actor actor) {
		if (dtoList.contains(actor)) {
			deleteDto(actor);
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

		if (entityList != null) {
			fillDtoList();
		} else {
			return new ArrayList<Actor>();
		}

		return dtoList;
	}

	@Override
	protected Actor convertEntityToDto(EntityActor entity, List<Movie> otherDtoList) {
		return EntityToDtoConverterActor.convert(entity, otherDtoList);
	}

	@Override
	protected Actor convertEntityToDto(EntityActor entity) {
		return EntityToDtoConverterActor.convert(entity);
	}

	@Override
	protected EntityActor createNewEntity(Actor dto) {
		EntityActor newEntity = new EntityActor();
		newEntity.setId(dto.getId());
		newEntity.setName(dto.getName().get());
		newEntity.setBirthDate(dto.getBirthDate().get());
		newEntity.setSex(dto.getSex().get());
		newEntity.setMovieIds(new ArrayList<Integer>());
		for (Movie movie : dto.getMovies()) {
			newEntity.getMovieIds().add(new Integer(movie.getId()));
		}
		return newEntity;
	}

	@Override
	protected boolean isEntityIdEqualDtoId(Actor dto, EntityActor entity) {
		return dto.getId() == entity.getId();
	}

	@Override
	protected List<EntityActor> loadEntityList() throws Exception {
		return DaoXmlService.loadActors();
	}

	@Override
	protected void deleteDtoWithSameId(Actor dto) {
		List<Actor> duplicatedActors = new ArrayList<Actor>();
		for(Actor currentActor : dtoList){
			if(currentActor.getId() == dto.getId()){
				duplicatedActors.add(currentActor);
			}
		}
		dtoList.removeAll(duplicatedActors);		
	}
}
