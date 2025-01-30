package com.lauracercas.moviecards.unittest.data;

import com.lauracercas.moviecards.data.ActorDTO;
import com.lauracercas.moviecards.data.MovieDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorDTOTest {

    ActorDTO actor = new ActorDTO();

    @Test
    void testSetGetId() {
        Integer idExample = 1;
        actor.setId(idExample);
        assertEquals(idExample, actor.getId());
    }

    @Test
    void testSetGetName() {
        String nameExample = "Sample name";
        actor.setName(nameExample);
        assertEquals(nameExample, actor.getName());
    }

    @Test
    void testSetGetDeadDate() {
        Date deadDateExample = new Date();
        actor.setDeadDate(deadDateExample);
        assertEquals(deadDateExample, actor.getDeadDate());
    }

    @Test
    void testSetGetBirthDate() {
        Date birthDateExample = new Date();
        actor.setBirthDate(birthDateExample);
        assertEquals(birthDateExample, actor.getBirthDate());
    }

    @Test
    void testSetGetCountry() {
        String countryExample = "Sample country";
        actor.setCountry(countryExample);
        assertEquals(countryExample, actor.getCountry());

    }

    @Test
    void testSetGetMovies() {
        List<MovieDTO> moviesExample = new ArrayList<MovieDTO>();
        actor.setMovies(moviesExample);
        assertEquals(moviesExample, actor.getMovies());
    }

}
