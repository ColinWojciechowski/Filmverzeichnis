package application.model.fachkonzept.impl;

import java.util.List;

import application.model.dao.impl.DaoActorXml;
import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;
import application.model.fachkonzept.interfaces.IFachkonzept;


public class FachkonzeptActor implements IFachkonzept<Actor> {

   IDao<Actor> actorDao = new DaoActorXml();

   @Override
   public void saveOrUpdate(Actor actor) {
      actorDao.saveOrUpdate(actor);
   }

   @Override
   public void saveOrUpdateAll(List<Actor> actorList) {
      actorDao.saveOrUpdateAll(actorList);
   }

   @Override
   public void delete(Actor actor) {
      actorDao.delete(actor);
   }

   @Override
   public void deleteAll(List<Actor> actorList) {
      actorDao.deleteAll(actorList);
   }

   @Override
   public List<Actor> getAll() {
      return actorDao.getAll();
   }

   @Override
   public List<Actor> getAllWithoutRelations() {
      return actorDao.getAllWithoutRelations();
   }


}


/**
 * $ID: FachkonzeptActor.java,v $
 */
