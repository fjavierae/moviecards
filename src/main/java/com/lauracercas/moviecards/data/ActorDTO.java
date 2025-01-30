package com.lauracercas.moviecards.data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * 
 */

public class ActorDTO {

    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadDate;

    private String country;

    private List<MovieDTO> movies;

    public ActorDTO() {
    }

    public ActorDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Date getDeadDate() {
        return deadDate;
    }

    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDTO actor = (ActorDTO) o;
        return Objects.equals(id, actor.id) && Objects.equals(name, actor.name) && Objects.equals(birthDate, actor.birthDate) && Objects.equals(country, actor.country) && Objects.equals(deadDate, actor.deadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, country, deadDate);
    }
}