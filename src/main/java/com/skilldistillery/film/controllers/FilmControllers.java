package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;

@Controller
public class FilmControllers {
	@Autowired
	private FilmDAO filmDao;

	
	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = {"/", "FindFilmByIDPage.do"})
	public String findFilmByID() {
		return "WEB-INF/FindFilmByID.jsp";
	}
	
	
	
}
