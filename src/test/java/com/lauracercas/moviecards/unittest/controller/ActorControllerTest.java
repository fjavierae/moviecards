package com.lauracercas.moviecards.unittest.controller;

import com.lauracercas.moviecards.controller.ActorController;
import com.lauracercas.moviecards.data.ActorDTO;
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.util.Messages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
class ActorControllerTest {

    private static final Logger log = LoggerFactory.getLogger(ActorControllerTest.class);
    private ActorController controller;

    @Mock
    private ActorService actorServiceMock;

    private AutoCloseable closeable;
    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        closeable = openMocks(this);
        controller = new ActorController(actorServiceMock);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }


    @Test
    void shouldGoListActorAndGetAllActors() {
        List<Actor> actors = new ArrayList<>();

        when(actorServiceMock.getAllActors()).thenReturn(actors);

        String viewName = controller.getActorsList(model);

        assertEquals("actors/list", viewName);
    }

    @Test
    void shouldInitializeActor() {
        String viewName = controller.newActor(model);

        assertEquals("actors/form", viewName);

        verify(model).addAttribute("actor", new Actor());
        verify(model).addAttribute("title", Messages.NEW_ACTOR_TITLE);
    }

    @Test
    void shouldSaveActorWithNoErrors() {
        ActorDTO actor = new ActorDTO();
        Actor a = new Actor(actor);
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        when(actorServiceMock.save(any(Actor.class))).thenReturn(a);

        String viewName = controller.saveActor(actor, result, model);

        assertEquals("actors/form", viewName);

        verify(model).addAttribute("actor", a);
        verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
        verify(model).addAttribute("message", Messages.SAVED_ACTOR_SUCCESS);
    }

    @Test
    void shouldUpdateActorWithNoErrors() {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(1);
        Actor actor = new Actor(actorDTO);
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        when(actorServiceMock.save(any(Actor.class))).thenReturn(actor);

        String viewName = controller.saveActor(actorDTO, result, model);

        assertEquals("actors/form", viewName);

        verify(model).addAttribute("actor", actor);
        verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
        verify(model).addAttribute("message", Messages.UPDATED_ACTOR_SUCCESS);
    }

    @Test
    void shouldTrySaveActorWithErrors() {
        ActorDTO actorDTO = new ActorDTO();
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        String viewName = controller.saveActor(actorDTO, result, model);

        assertEquals("actors/form", viewName);

        verifyNoInteractions(model);
    }

    @Test
    void shouldGoToEditActor() {
        Actor actor = new Actor();
        actor.setId(1);
        List<Movie> movies = List.of(new Movie());
        actor.setMovies(movies);
        when(actorServiceMock.getActorById(actor.getId())).thenReturn(actor);

        String viewName = controller.editActor(actor.getId(), model);

        assertEquals("actors/form", viewName);

        verify(model).addAttribute("actor", actor);
        verify(model).addAttribute("movies", movies);
        verify(model).addAttribute("title", Messages.EDIT_ACTOR_TITLE);
    }


}