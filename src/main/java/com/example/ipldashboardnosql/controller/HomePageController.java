package com.example.ipldashboardnosql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboardnosql.service.MatchService;
import com.example.ipldashboardnosql.service.TeamService;
import com.example.ipldashboardnosql.service.VenueService;

@RestController
public class HomePageController {

	@Autowired
	private TeamService teamService;

	@Autowired
	private MatchService matchService;

	@Autowired
	private VenueService venueService;

	private int PAGE_SIZE = 5;

	@GetMapping("/")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("teams", teamService.getTeams());
		modelAndView.addObject("venues", venueService.getVenues());
		modelAndView.addObject("matches", matchService.getMatches(0, PAGE_SIZE));
		modelAndView.addObject("cities", venueService.getCities());
		return modelAndView;
	}
}
