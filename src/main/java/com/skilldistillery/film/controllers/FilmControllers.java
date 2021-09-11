package com.skilldistillery.film.controllers;


@Controller
public class FilmControllers {
	private static FilmDAO dao = null;
	private FilmDAO filmDao;

	
	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		return "WEB-INF/home.jsp";
	}