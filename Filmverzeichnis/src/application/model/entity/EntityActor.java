package application.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.model.dto.Actor;
import application.model.dto.Movie;
import application.model.dto.enums.Sex;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class EntityActor {
	 	private int id;
	    private String name;
	    private Date birthDate;
	    private Sex sex;
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

		public List<Integer> getMovieIds() {
			return movieIds;
		}

		public void setMovieIds(List<Integer> movieIds) {
			this.movieIds = movieIds;
		}
}
