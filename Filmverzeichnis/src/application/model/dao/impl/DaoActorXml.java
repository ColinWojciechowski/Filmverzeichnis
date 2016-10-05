package application.model.dao.impl;

import application.model.dao.interfaces.IDao;
import application.model.dto.Actor;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoActorXml implements IDao<Actor> {
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
