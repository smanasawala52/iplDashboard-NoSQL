package com.example.ipldashboardnosql.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.Team;

@Service
public class TeamRepository {
	public Team getByName(String name) {
		return null;
	}

	public List<Team> findAllByOrderByNameAsc() {
		return null;
	}

}
