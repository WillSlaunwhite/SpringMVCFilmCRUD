package com.skilldistillery.film.dao;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class InMemoryFilmJdbcDaoImpl implements FilmDAO{
	List<Film> films = new ArrayList<>();
	
//	public Film(String title, String description, int releaseYear, int languageId, int rentalDuration,
//	double rentalRate, int length, double replacementCost, String rating)

	InMemoryFilmJdbcDaoImpl() {
		films.add(new Film());
		films.add(new Film());
		films.add(new Film());
		films.add(new Film());
		films.add(new Film());
	}
	
	

	@Override
	public Film findFilmById(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Film> findFilmByKeyword(String filmKeyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Film addFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}

}
