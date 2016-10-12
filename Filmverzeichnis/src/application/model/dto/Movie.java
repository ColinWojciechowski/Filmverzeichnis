package application.model.dto;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class Movie {
    private int id;
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty releaseYear = new SimpleIntegerProperty();
    private List<Actor> actors;
    public int getId() {
        return id;
    }
    
    public IntegerProperty getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(IntegerProperty releaseYear) {
		this.releaseYear = releaseYear;
	}

    public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public void setId(int id) {
        this.id = id;
    }

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}    
}
