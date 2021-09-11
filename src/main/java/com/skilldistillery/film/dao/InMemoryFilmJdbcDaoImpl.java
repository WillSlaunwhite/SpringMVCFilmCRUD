package com.skilldistillery.film.dao;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Film;

public class InMemoryFilmJdbcDaoImpl implements FilmDAO{
	List<Film> films = new ArrayList<>();

	InMemoryFilmJdbcDaoImpl() {
	}
	
	
	@Override
	public Film findById(int filmId) {
		
		
		return null;
	}

}
