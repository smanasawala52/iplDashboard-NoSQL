package com.example.ipldashboardnosql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.Match;
import com.example.ipldashboardnosql.model.Page;
import com.example.ipldashboardnosql.repository.MatchRepository;

@Service
public class MatchService {
	@Autowired
	private MatchRepository matchRepository;

	public Page<Match> getMatches(int i, int pAGE_SIZE) {
		return matchRepository.getByOrderByDateDesc(i, pAGE_SIZE);
	}

	public Match getMatchDetails(String id) {
		return matchRepository.findById(Long.valueOf(id));
	}
}
