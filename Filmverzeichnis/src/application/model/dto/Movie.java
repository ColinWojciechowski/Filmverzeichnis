package application.model.dto;

import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class Movie {
    private int id;
    private String name;
    private int releaseYear;
    private List<Actor> actors;
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

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}    
}
