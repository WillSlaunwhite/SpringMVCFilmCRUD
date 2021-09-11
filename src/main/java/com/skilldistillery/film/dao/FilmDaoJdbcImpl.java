package com.skilldistillery.film.dao;

import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static String url = "jdbc:mysql://localhost:3306/historydb?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final String user = "historyuser";
	private final String pass = "historyuser";
	
	
	@Override
	public Film findById(int filmId) {
		Film film = null;
		
		return film;
	}

}
