package application.model.dao.interfaces;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public interface IDao<T> {
    void saveOrUpdate(T dto);
    void saveOrUpdateAll(List<T> dtoList);
    void delete(T dto);
    void deleteAll(List<T> dtoList);
    List<T> getAll();
    List<T> getAllWithoutRelations();
}
