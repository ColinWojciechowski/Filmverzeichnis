package model.dao.impl;

import model.dao.abstracts.DaoXml;
import model.dto.Movie;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoMovieXml extends DaoXml<Movie> {
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
