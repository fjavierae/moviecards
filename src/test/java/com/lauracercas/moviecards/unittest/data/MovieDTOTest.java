package com.lauracercas.moviecards.unittest.data;

import com.lauracercas.moviecards.data.ActorDTO;
import com.lauracercas.moviecards.data.MovieDTO;
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieDTOTest {

    MovieDTO movie = new MovieDTO();

    @Test
    void testSetGetId() {
        Integer idExample = 1;
        movie.setId(idExample);
        assertEquals(idExample, movie.getId());
    }

    @Test
    void testSetGetTitle() {
        String titleExample = "Sample title";
        movie.setTitle(titleExample);
        assertEquals(titleExample, movie.getTitle());
    }

    @Test
    void testSetGetReleaseYear() {
        Integer releaseYearExample = 2000;
        movie.setReleaseYear(releaseYearExample);
        assertEquals(releaseYearExample,movie.getReleaseYear());
    }

    @Test
    void testSetGetDuration() {
        Integer durationExample = 100;
        movie.setDuration(durationExample);
        assertEquals(durationExample,movie.getDuration());
    }    

    @Test
    void testSetGetCountry() {
        String countryExample = "Sample country";
        movie.setCountry(countryExample);
        assertEquals(countryExample,movie.getCountry());
    }

    @Test
    void testSetGetDirector() {
        String directorExample = "Sample director";
        movie.setDirector(directorExample);
        assertEquals(directorExample,movie.getDirector());
    }

    @Test
    void testSetGetGenre() {
        String genreExample = "Sample genre";
        movie.setGenre(genreExample);
        assertEquals(genreExample,movie.getGenre());
    }

    @Test
    void testSetGetSinopsis() {
        String sinopsisExample = "Sample sinopsis";
        movie.setSinopsis(sinopsisExample);
        assertEquals(sinopsisExample,movie.getSinopsis());
    }

    @Test
    void testSetGetActors() {
        List<ActorDTO> actorsExample = new ArrayList<ActorDTO>();
        movie.setActors(actorsExample);
        assertEquals(actorsExample, movie.getActors());
    }

    @Test
    void testAddActor() {
        List<ActorDTO> actorsExample = new ArrayList<ActorDTO>();
        movie.setActors(actorsExample);
        ActorDTO actorExample = new ActorDTO(1, "Sample name");
        movie.addActor(actorExample);
        assert(movie.getActors().contains(actorExample));
        assertEquals(1, movie.getActors().size());
    }

    @Test void testExistActorInMovie() {
        List<ActorDTO> actorsExample = new ArrayList<ActorDTO>();
        ActorDTO actorExample = new ActorDTO(2, "Sample name");
        actorsExample.add(actorExample);
        movie.setActors(actorsExample);
        assertTrue(movie.existActorInMovie(actorExample));
        assertTrue(movie.getActors().contains(actorExample));
    }


}
