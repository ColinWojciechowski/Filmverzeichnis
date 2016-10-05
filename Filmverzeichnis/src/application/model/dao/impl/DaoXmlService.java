package application.model.dao.impl;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import application.model.constants.Constants;
import application.model.entity.EntityActor;
import application.model.entity.EntityMovie;

/**
 * Created by Kay Gerlitzki on 05.10.2016.
 */

public class DaoXmlService {
	
    public static void persistMovies(List<EntityMovie> movies) throws Exception{
        XMLEncoder encoder =
           new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Constants.XML_MOVIE_FILENAME)));        
        encoder.writeObject(movies);        
        encoder.close();
    }
    
    public static List<EntityMovie> loadMovies() throws Exception {    	
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(Constants.XML_MOVIE_FILENAME)));
        List<EntityMovie> movies = (List<EntityMovie>)decoder.readObject();
        decoder.close();
        return movies;
    }
    
    public static void persistActors(List<EntityActor> actors) throws Exception{    	
        XMLEncoder encoder =
           new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Constants.XML_ACTOR_FILENAME)));        
        encoder.writeObject(actors);
        encoder.close();
    }
    
    public static List<EntityActor> loadActors() throws Exception {
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(Constants.XML_ACTOR_FILENAME)));
        List<EntityActor> movies = (List<EntityActor>)decoder.readObject();
        decoder.close();
        return movies;
    }
}
