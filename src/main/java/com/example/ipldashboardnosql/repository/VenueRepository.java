package com.example.ipldashboardnosql.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.ICity;
import com.example.ipldashboardnosql.model.Venue;

@Service
public class VenueRepository {
	public Venue getByName(String name) {
		return null;

	}

	public List<Venue> getByCity(String city) {
		return null;

	}

//	@Query("SELECT city as city, name as venueName FROM Venue where city != 'NA' order by city asc,name asc")
	public List<ICity> findCity() {
		return null;

	}

	public List<Venue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveAll(List<Venue> venues) {
		// TODO Auto-generated method stub

	}
}
