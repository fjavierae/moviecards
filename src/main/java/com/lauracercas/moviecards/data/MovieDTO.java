package com.lauracercas.moviecards.data;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
public class MovieDTO {

    private Integer id;
    private String title;
    private Integer releaseYear;
    private Integer duration;
    private String country;
    private String director;
    private String genre;
    private String sinopsis;

    private List<ActorDTO> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer year) {
        this.releaseYear = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String address) {
        this.director = address;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movie = (MovieDTO) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(releaseYear, movie.releaseYear) && Objects.equals(duration, movie.duration) && Objects.equals(country, movie.country) && Objects.equals(director, movie.director) && Objects.equals(genre, movie.genre) && Objects.equals(sinopsis, movie.sinopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseYear, duration, country, director, genre, sinopsis);
    }

    public void addActor(ActorDTO actor) {
        if (actor != null) {
            getActors().add(actor);
        }
    }

    public boolean existActorInMovie(ActorDTO actor) {
        return actors.contains(actor);
    }


}