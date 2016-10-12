package application.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.entity.EntityActor;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoActorXml implements IDao<Actor> {
   private List<Actor> dtoList;
   private List<EntityActor> entityList;
   private IDao<Movie> daoMovie;

   public DaoActorXml() {
      this.dtoList = new ArrayList<Actor>();
      this.entityList = new ArrayList<EntityActor>();
      this.daoMovie = new DaoMovieXml(this);
   }

    public DaoActorXml(DaoMovieXml daoMovieXml) {
       this.dtoList = new ArrayList<Actor>();
      this.entityList = new ArrayList<EntityActor>();
      this.daoMovie = daoMovieXml;
   }

   @Override
    public void saveOrUpdate(Actor actor) {
       dtoList = getAll();
       dtoList.add(actor);
       saveOrUpdateAll(dtoList);
    }

   private void addNewEntityActor(Actor actor){
       EntityActor newEntity = createNewEntity(actor);
       entityList.add(newEntity);
    }

   private EntityActor createNewEntity(Actor actor) {
      EntityActor newEntity = new EntityActor();
       newEntity.setId(actor.getId());
       newEntity.setName(actor.getName().get());
       newEntity.setBirthDate(actor.getBirthDate().get());
       newEntity.setSex(actor.getSex().get());
       newEntity.setMovieIds(new ArrayList<Integer>());
       for (Movie movie : actor.getMovies()) {
          newEntity.getMovieIds().add(new Integer(movie.getId()));
      }
       return newEntity;
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
       entityList.clear();
       dtoList = actorList;

       for(Actor actor : actorList){
          addNewEntityActor(actor);
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
         List<Movie> movies = daoMovie.getAllWithoutRelations();
         currentActor = EntityConverter.getActor(entity, movies);
         dtoList.add(currentActor);
      }
    }

   @Override
   public List<Actor> getAllWithoutRelations() {
       dtoList.clear();
       try {
         entityList = DaoXmlService.loadActors();
      } catch (Exception e) {
         e.printStackTrace();
      }

       if(entityList != null){
          fillDtoListWithoutRelations();
       } else {
          return new ArrayList<Actor>();
       }

        return dtoList;
   }

    private void fillDtoListWithoutRelations(){
      Actor currentActor;
      for(EntityActor entity : entityList){
         currentActor = EntityConverter.getActor(entity);
         dtoList.add(currentActor);
      }
    }
}
