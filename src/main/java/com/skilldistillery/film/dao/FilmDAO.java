package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId);
	public Actor findActorById(int actorId);
	public List<Actor> findActorsByFilmId(int filmId);
	public List<Film> findFilmByKeyword(String keyword);
	public Actor createActor(Actor actor);
	public boolean saveActor(Actor actor);
	public boolean deleteActor(Actor actor);
	public Film createFilm(Film film);
	public boolean saveFilm(Film film);
	public boolean deleteFilm(Film film);
}