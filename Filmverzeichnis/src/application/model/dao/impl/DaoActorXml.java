package application.model.dao.impl;

import application.model.dao.abstracts.DaoXml;
import application.model.dto.Actor;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoActorXml extends DaoXml<Actor> {
    @Override
    public void saveOrUpdate(Actor actor) {

    }

    @Override
    public void saveOrUpdateAll(List<Actor> dtoList) {

    }

    @Override
    public void delete(Actor actor) {

    }

    @Override
    public void deleteAll(List<Actor> dtoList) {

    }

    @Override
    public List<Actor> getAll() {
        return null;
    }
}
