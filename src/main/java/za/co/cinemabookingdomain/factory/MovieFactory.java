/*Movie.java
MovieFactory
Author: VR Ramncwana (220618534)
Date: 18 May 2025
 */



package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Movie;
import za.co.cinemabookingdomain.util.Helper;

public class MovieFactory {

    public static Movie createMovie(String title, String genre, String duration, String language, String description, String releaseDate, String releaseTime){
        if(title==null ||
                Helper.isInvalidgenre(genre) ||
                Helper.isInvalduration(duration) ||
                Helper.isInvalidlanguage(language)){
            return null;
        }

        return new Movie.MovieBuilder()
                .setTitle(title)
                .setGenre(genre)
                .setDuration(duration)
                .setLanguage(language)
                .setDescription(description)
                .setReleaseDate(releaseDate)
                .setReleaseTime(releaseTime)
                .build();

    }
}

