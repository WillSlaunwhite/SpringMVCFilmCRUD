package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmControllers {
	private static FilmDAO dao = null;
	private FilmDAO filmDao;

	
	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = {"/", "FindFilmByIDPage.do"})
	public String findFilmByID() {
		return "WEB-INF/FindFilmByID.jsp";
	}
	
	@RequestMapping("createFilmPage.do")
	public String createFilm() {
		return "WEB-INF/CreateFilm.jsp";
	}

	@RequestMapping("FindFilmByKeywordPage.do")
	public String findFilmByKeyword() {
		return "WEB-INF/FilmByKeyword.jsp";
	}
	
	@RequestMapping("ListFilms.do")
	public String listFilms() {
		return "WEB-INF/ListFilms.jsp";
	}
	
	
	@RequestMapping("DisplayFilmInfo.do")
	public ModelAndView displayFilmInfo(Film film) {
		ModelAndView mv = new ModelAndView();
		if(film == null || film.getId() == 0) {
			mv.setViewName("WEB-INF/filmNotFound.jsp");
		} else {
			mv.setViewName("WEB-INF/display.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path = "FindFilmByID.do", params = "id", method = RequestMethod.POST)
	public ModelAndView getFilmByID(@RequestParam("id") int id, RedirectAttributes redir) {
		Film film = dao.findFilmById(id);
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:DisplayFilmInfo.do");
		return mv;

	}
	
	@RequestMapping(path = "ListFilms.do", method = RequestMethod.POST)
	public ModelAndView findFilmByKW(String filmKeyword) {
		List<Film> filmList = dao.findFilmByKeyword(filmKeyword);
		ModelAndView mv = new ModelAndView();
		mv.addObject("FilmList", filmList);
		if(filmList.size() == 0) {
			mv.setViewName("WEB-INF/filmNotFound.jsp");
		} else {
			mv.setViewName("WEB-INF/ListFilms.jsp");
		}
		return mv;
	}
	
	
	@RequestMapping(path = "addFilmToDB.do", method = RequestMethod.POST)
	public ModelAndView newFilm(Film film, RedirectAttributes redir) {
		Film returnFilm = dao.addFilm(film);
		Film foundFilm = dao.findFilmById(returnFilm.getId());
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", foundFilm);
		mv.setViewName("redirect:DisplayFilmInfo.do");
		return mv;
	}
	
	@RequestMapping(path = "DeleteFilm.do")
	public ModelAndView deleteFilm(@RequestParam("id") int id) {
		Film film = dao.findFilmById(id);
		boolean isDeleted = dao.deleteFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.addObject("Delete",isDeleted);
		mv.setViewName("WEB-INF/ConfirmUpdate.jsp");
		return mv;
	}
	
	@RequestMapping(path = "UpdateFilm.do")
	public ModelAndView updateFilm(@RequestParam("id") int id) {
		Film film = dao.findFilmById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("Film", film);
		mv.setViewName("WEB-INF/UpdateFilm.jsp");
		return mv;
	}
	
	@RequestMapping(path = "UpdateFilmInDB.do", method = RequestMethod.POST)
	public ModelAndView UpdateFilmInDB(Film film, RedirectAttributes redir) {
		boolean updated = dao.updateFilm(film);
		Film updatedfilm = dao.findFilmById(film.getId());
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", updatedfilm);
		if(updated) {
			mv.setViewName("redirect:DisplayFilmInfo.do");	
		} else {
			mv.setViewName("WEB-INF/updateComplete.jsp");
		}
		return mv;
	}

	public void FilmController(FilmDAO dao) {
		FilmControllers.dao = dao;
	}
}
