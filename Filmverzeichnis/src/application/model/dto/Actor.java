package application.model.dto;

import application.model.dto.enums.Sex;
import java.util.Date;
import java.util.List;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class Actor {
    private int id;
    private String name;
    private Date birthDate;
    private Sex sex;
    private List<Movie> movies;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}