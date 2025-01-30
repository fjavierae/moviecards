package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.data.MovieDTO;
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
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
public class MovieController {
    final String movies = "movies";
    final String movie = "movie";
    final String title ="title";
    final String formPage="movies/form";
    @Autowired
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(movies)
    public String getMoviesList(Model model) {
        model.addAttribute(movies, movieService.getAllMovies());
        return "movies/list";
    }

    @GetMapping(movies+"/new")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute(title, Messages.NEW_MOVIE_TITLE);
        return formPage;
    }

    @PostMapping("saveMovie")
    public String saveMovie(@ModelAttribute(movie) MovieDTO movieDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return formPage;
        }
        Movie m = new Movie(movieDTO);
        Movie movieSaved = movieService.save(m);
        if (movieSaved.getId() != null) {
            model.addAttribute("message", Messages.UPDATED_MOVIE_SUCCESS);
        } else {
            model.addAttribute("message", Messages.SAVED_MOVIE_SUCCESS);
        }

        model.addAttribute(movie, movieSaved);
        model.addAttribute(title, Messages.EDIT_MOVIE_TITLE);
        return formPage;
    }

    @GetMapping("editMovie/{movieId}")
    public String editMovie(@PathVariable Integer movieId, Model model) {
        Movie m = movieService.getMovieById(movieId);
        List<Actor> actors = m.getActors();
        model.addAttribute(movie, m);
        model.addAttribute("actors", actors);

        model.addAttribute(title, Messages.EDIT_MOVIE_TITLE);

        return formPage;
    }


}
