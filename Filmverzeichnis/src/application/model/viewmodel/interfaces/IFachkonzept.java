package application.model.viewmodel.interfaces;

import javafx.beans.property.StringProperty;

public interface IFachkonzept<T> {

   void persist();

   void create();

   void update(T t);

   void setValues(T t);

   void bindAttributes(StringProperty string1, StringProperty string2, StringProperty string3);

   void delete();

}

/**
 * $ID: Fachkonzept.java,v $
 */
