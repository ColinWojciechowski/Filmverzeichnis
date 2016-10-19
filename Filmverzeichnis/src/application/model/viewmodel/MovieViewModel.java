package application.model.viewmodel;

import application.model.dto.Actor;
import application.model.dto.enums.Sex;
import javafx.beans.property.SimpleStringProperty;

public class MovieViewModel {

   public Actor getTestActor(){
      Actor testActor = new Actor();
      testActor.setId(4);
      testActor.setName(new SimpleStringProperty("Jonny Banana"));
      testActor.setSex(Sex.FEMALE.toString());
      return testActor;
   }

   public void createMovie() {
      // TODO Auto-generated method stub

   }

}
