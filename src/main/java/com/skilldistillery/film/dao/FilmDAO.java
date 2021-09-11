package com.skilldistillery.film.dao;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Actor;
import java.util.List;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public List<Film> findFilmByKeyword(String filmKeyword);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);
}
