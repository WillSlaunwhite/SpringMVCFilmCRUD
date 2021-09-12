package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmControllers {

	@Autowired
	private FilmDAO filmdao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/index.html";
	}

	@RequestMapping(path = { "findFilmById.do" }, method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		try {
			film = filmdao.findFilmById(Integer.valueOf(id));
		}
		catch(Exception e) {
			mv.setViewName("WEB-INF/NoResults.jsp");
			return mv;
		}
	
		if (film == null) {
			mv.setViewName("WEB-INF/NoResults.jsp");
			return mv;
		}
		
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = { "findFilmByKeyword.do" }, method = RequestMethod.GET)
	public ModelAndView findFilmsByKeyword(@RequestParam("kw") String kw) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
		
		if(kw.equals("")) {
			mv.setViewName("WEB-INF/NoResults.jsp");
			return mv;
		}
		
		else {
			films = filmdao.findFilmByKeyword(kw);
		}

		if (films.size() == 0) {

//			mv.addObject("message",
//					"We weren't able to find any movies matching your request.  Maybe try fewer words or different phrases.");
			mv.setViewName("WEB-INF/NoResults.jsp");
			return mv;
		}
		
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/results.jsp");
			
		return mv;
	}

	@RequestMapping(path = { "addFilm.do" }, method = RequestMethod.GET)
	public ModelAndView addFilm(Film film) {

		ModelAndView mv = new ModelAndView();

//		Film f = filmdao.createFilm(film);
		Film f = null;
		
		try {
			f = filmdao.createFilm(film);
		}
		catch(Exception e) {
			mv.setViewName("WEB-INF/addFail.jsp");
			return mv;
		}

		if (f.equals(null)) {
//			mv.addObject("message", "Error: We weren't able to add your movie.  Popcorn on us?");
			mv.setViewName("WEB-INF/addFail.jsp");
			return mv;
		}

		mv.addObject("film", film);
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}

	@RequestMapping(path = { "delete.do" }, method = RequestMethod.GET)
	public ModelAndView deleteFilm(@RequestParam("deleteFilm") String toDeleteOrNot, @RequestParam("id") Integer id) {

		ModelAndView mv = new ModelAndView();
		System.out.println(id);

		if (toDeleteOrNot.toUpperCase().equals("YES")) {

			boolean success = filmdao.deleteFilm(filmdao.findFilmById(id));

			if (success) {
				mv.addObject("message", "Your film has been sucessfully deleted.");
				mv.setViewName("WEB-INF/message.jsp");
				return mv;
			} else {
				mv.addObject("message", "Error: We weren't able to remove the movie.  Popcorn on us?");
				mv.setViewName("WEB-INF/NoResults.jsp");
				return mv;
			}
		} else {

			mv.setViewName("WEB-INF/index.jsp");
			return mv;
		}

	}

	@RequestMapping(path = { "edit.do" }, method = RequestMethod.GET)
	public ModelAndView editFilm(@RequestParam("editFilm") String toEditOrNot, @RequestParam("id") String id) {

		ModelAndView mv = new ModelAndView();

		if (toEditOrNot.toUpperCase().equals("YES")) {
			Film toEdit = null;
			
			try {
				toEdit = filmdao.findFilmById(Integer.valueOf(id));
			}
			catch(Exception e) {
				mv.setViewName("WEB-INF/editFail.jsp");
			}

			if (toEdit != null) {
				mv.addObject("film", toEdit);
				mv.setViewName("WEB-INF/editMovie.jsp");
				return mv;
			} else {
				mv.addObject("message", "Error: We had an issue trying to edit that movie.  It's possible that it's been deleted.");
				mv.setViewName("WEB-INF/NoResults.jsp");
				return mv;
			}
		} else {

			mv.setViewName("WEB-INF/index.jsp");
			return mv;
		}

	}
	
	@RequestMapping(path = { "updateFilm.do" }, method = RequestMethod.GET)
	public ModelAndView updateFilm(Film film) {

		ModelAndView mv = new ModelAndView();

		boolean success = filmdao.saveFilm(film);
		
		if(success) {
			
			mv.addObject("message", "Your film has been updated.");
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/result.jsp");
			return mv;
		}
		else {
			mv.addObject("message", "Error: there was an issue updating the film.");
			mv.setViewName("WEB-INF/NoResults.jsp");
			return mv;
		}

	}

}