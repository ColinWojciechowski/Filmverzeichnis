package application.model.fachkonzept.impl;

import java.util.Collections;
import java.util.List;

import application.model.dao.impl.DaoMovieXml;
import application.model.dao.interfaces.IDao;
import application.model.dto.Movie;
import application.model.fachkonzept.interfaces.IFachkonzept;

public class FachkonzeptMovie implements IFachkonzept<Movie> {

   IDao<Movie> movieDao = new DaoMovieXml();

   @Override
   public void saveOrUpdate(Movie movie) {
      movieDao.saveOrUpdate(movie);
   }

   @Override
   public void saveOrUpdateAll(List<Movie> movieList) {
      movieDao.saveOrUpdateAll(movieList);
   }

   @Override
   public void delete(Movie movie) {
      movieDao.delete(movie);
   }

   @Override
   public void deleteAll(List<Movie> movieList) {
      movieDao.deleteAll(movieList);
   }

   @Override
   public List<Movie> getAll() {
      Collections.sort(movieDao.getAll());
      return movieDao.getAll();
   }

   @Override
   public List<Movie> getAllWithoutRelations() {
      Collections.sort(movieDao.getAllWithoutRelations());
      return movieDao.getAllWithoutRelations();
   }

}

/**
 * $ID: FachkonzeptMovie.java,v $
 */
