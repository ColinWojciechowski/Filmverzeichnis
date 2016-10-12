package application.model.entity;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class EntityActor {
       private int id;
       private String name;
       private String birthDate;
       private String sex;
       private List<Integer> movieIds;

       public EntityActor(){
       }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getBirthDate() {
           return birthDate;
       }

       public void setBirthDate(String birthDate) {
           this.birthDate = birthDate;
       }

       public String getSex() {
           return sex;
       }

       public void setSex(String sex) {
           this.sex = sex;
       }

      public List<Integer> getMovieIds() {
         return movieIds;
      }

      public void setMovieIds(List<Integer> movieIds) {
         this.movieIds = movieIds;
      }
}
