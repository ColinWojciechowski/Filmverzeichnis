package application.model.dao.impl;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import application.model.constants.Constants;
import application.model.entity.EntityActor;
import application.model.entity.EntityMovie;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoXmlService {
	public static void persistMovies(List<EntityMovie> movies) throws Exception {
		for(EntityMovie currentMovie : movies){
		}
		
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(new FileOutputStream(Constants.XML_MOVIE_FILENAME)));
		encoder.writeObject(movies);
		encoder.close();
	}

	public static List<EntityMovie> loadMovies() throws Exception {
		checkAndCreateFiles(Constants.XML_MOVIE_FILENAME);
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Constants.XML_MOVIE_FILENAME)));
		List<EntityMovie> movies;
		try {
			movies = (List<EntityMovie>) decoder.readObject();
		} catch (ArrayIndexOutOfBoundsException e){
			movies = new ArrayList<>();
		}
		decoder.close();
		return movies;
	}

	public static void persistActors(List<EntityActor> actors) throws Exception {
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(new FileOutputStream(Constants.XML_ACTOR_FILENAME)));
		encoder.writeObject(actors);
		encoder.close();
	}

	public static List<EntityActor> loadActors() throws Exception {
		checkAndCreateFiles(Constants.XML_ACTOR_FILENAME);
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Constants.XML_ACTOR_FILENAME)));
		List<EntityActor> actors;
		try {
			actors = (List<EntityActor>) decoder.readObject();
		} catch (ArrayIndexOutOfBoundsException e){
			actors = new ArrayList<>();
		}
		decoder.close();
		return actors;
	}

	private static void checkAndCreateFiles(String path) throws FileNotFoundException {
		if (!isFileExistent(path)) {
			createNewFile(path);
		}
	}

	private static void createNewFile(String path) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
		encoder.close();
	}

	private static boolean isFileExistent(String path) {
		File file = new File(path);
		if (file.exists() && !file.isDirectory()) {
			return true;
		}
		return false;
	}
}
