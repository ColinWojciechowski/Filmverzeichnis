package application.model.fachkonzept.interfaces;

import java.util.List;

public interface IFachkonzept<T> {

   void saveOrUpdate(T actor);
   void saveOrUpdateAll(List<T> actorList);
   void delete(T Dto);
   void deleteAll(List<T> dtoList);
   List<T> getAll();
   List<T> getAllWithoutRelations();

}


/**
 * $ID: IFachkonzept.java,v $
 */
