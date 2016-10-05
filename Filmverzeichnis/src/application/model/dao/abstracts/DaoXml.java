package model.dao.abstracts;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public abstract class DaoXml<T> {
    public abstract void saveOrUpdate(T dto);
    public abstract void saveOrUpdateAll(List<T> dtoList);
    public abstract void delete(T dto);
    public abstract void deleteAll(List<T> dtoList);
    public abstract List<T> getAll();
}
