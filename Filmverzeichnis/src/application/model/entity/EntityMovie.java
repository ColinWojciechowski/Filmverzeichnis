package application.model.entity;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class EntityMovie {
   private int id;
    private String name;
    private String releaseYear;
    private String genre;
    private List<Integer> actorIds;

    public EntityMovie(){
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }


   public String getGenre() {
      return genre;
   }


   public void setGenre(String genre) {
      this.genre = genre;
   }

   public List<Integer> getActorIds() {
      return actorIds;
   }

   public void setActorIds(List<Integer> actorIds) {
      this.actorIds = actorIds;
   }
}
