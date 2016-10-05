package application.model.dao.impl;

import application.model.dao.interfaces.IDao;
import application.model.dto.Movie;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoMovieXml implements IDao<Movie> {
    @Override
    public void saveOrUpdate(Movie movie) {

    }

    @Override
    public void saveOrUpdateAll(List<Movie> movieList) {

    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteAll(List<Movie> movieList) {

    }

    @Override
    public List<Movie> getAll() {
        return null;
    }
}
