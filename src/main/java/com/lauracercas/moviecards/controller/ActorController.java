package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.util.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
@Controller
public class ActorController {
    final static String actor ="actor";
    final static String title ="title";
    final static String formPage ="actors/form";
    @Autowired
    ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("actors")
    public String getActorsList(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors/list";
    }

    @GetMapping("actors/new")
    public String newActor(Model model) {
        model.addAttribute(actor, new Actor());
        model.addAttribute(title, Messages.NEW_ACTOR_TITLE);
        return formPage;
    }

    @PostMapping("saveActor")
    public String saveActor(@ModelAttribute Actor a, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return formPage;
        }
        Actor actorSaved = actorService.save(a);
        if (a.getId() != null) {
            model.addAttribute("message", Messages.UPDATED_ACTOR_SUCCESS);
        } else {
            model.addAttribute("message", Messages.SAVED_ACTOR_SUCCESS);
        }

        model.addAttribute(actor, actorSaved);
        model.addAttribute(title, Messages.EDIT_ACTOR_TITLE);
        return formPage;
    }

    @GetMapping("editActor/{actorId}")
    public String editActor(@PathVariable Integer actorId, Model model) {
        Actor a = actorService.getActorById(actorId);
        List<Movie> movies = a.getMovies();
        model.addAttribute(actor, a);
        model.addAttribute("movies", movies);

        model.addAttribute(title, Messages.EDIT_ACTOR_TITLE);

        return formPage;
    }


}
