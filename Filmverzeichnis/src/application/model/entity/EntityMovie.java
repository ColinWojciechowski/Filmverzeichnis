package application.model.entity;

import java.util.ArrayList;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class EntityMovie {
	private int id;
    private String name;
    private int releaseYear;
    private List<Integer> actorIds;
    
    public EntityMovie(Movie movie){
    	this.id = movie.getId();
    	this.name = movie.getName();
    	this.releaseYear = movie.getReleaseYear();
    	this.actorIds = new ArrayList<Integer>();
    	for(Actor actor : movie.getActors()){
    		actorIds.add(actor.getId());
    	}
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

	public List<Integer> getActors() {
		return actorIds;
	}

	public void setActors(List<Integer> actorIds) {
		this.actorIds = actorIds;
	}    
}
