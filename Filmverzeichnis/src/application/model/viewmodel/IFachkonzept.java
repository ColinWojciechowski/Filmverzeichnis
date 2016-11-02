package application.model.viewmodel;

import javafx.beans.property.StringProperty;

public interface IFachkonzept {

   void add();
   void saveOrUpdate();
   void bindAttributes(StringProperty string1, StringProperty string2, StringProperty string3);

}


/**
 * $ID: Fachkonzept.java,v $
 */
