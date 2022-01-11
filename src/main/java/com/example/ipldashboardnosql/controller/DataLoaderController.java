package com.example.ipldashboardnosql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ipldashboardnosql.model.Match;
import com.example.ipldashboardnosql.service.DataService;

@RestController
public class DataLoaderController {

	@Autowired
	private DataService dataService;

	@GetMapping(path = "/getMatchData")
	public List<Match> getMatchData() {
		return dataService.getMatches();
	}
}
