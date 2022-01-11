package com.example.ipldashboardnosql.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.Match;
import com.example.ipldashboardnosql.model.MatchBuilder;
import com.example.ipldashboardnosql.model.Venue;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class DataService {
	private List<Match> matches = new CopyOnWriteArrayList<>();
	private Map<Long, Match> matchesMap = new ConcurrentHashMap<Long, Match>();
	private List<Venue> venues = new CopyOnWriteArrayList<>();

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@PostConstruct
	public void loadMatchData() throws FileNotFoundException, IOException, CsvException {
		System.out.println("Dataloading started");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		try (CSVReader reader = new CSVReader(new FileReader("match-data.csv"))) {
			List<String[]> r = reader.readAll();
			r.forEach(x -> {
				try {
					Match match = new MatchBuilder().setId(Long.parseLong(x[0])).setCity(x[1])
							.setDate(LocalDate.parse(x[2], dateFormat)).setPlayerOfMatch(x[3]).setVenue(x[4])
							.setTeam1(x[6]).setTeam2(x[7]).setTossWinner(x[8]).setTossDecision(x[9]).setWinner(x[10])
							.setResult(x[11]).setResultMargin(x[12]).setUmpire1(x[15]).setUmpire2(x[16]).build();
					getMatches().add(match);
					getMatchesMap().put(match.getId(), match);
					System.out.println("Match: " + match);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		Collections.sort(getMatches());
		System.out.println(getMatches());
	}

	public Map<Long, Match> getMatchesMap() {
		return matchesMap;
	}

	public List<Venue> getVenues() {
		return venues;
	}
}
