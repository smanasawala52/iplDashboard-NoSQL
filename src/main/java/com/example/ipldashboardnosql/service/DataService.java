package com.example.ipldashboardnosql.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.Match;
import com.example.ipldashboardnosql.model.MatchBuilder;
import com.example.ipldashboardnosql.model.MatchInputJson;
import com.example.ipldashboardnosql.model.Venue;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataService {
	private List<Match> matches = new CopyOnWriteArrayList<>();
	private List<Venue> venues = new CopyOnWriteArrayList<>();
	private String dirLocation = "ipl_json";

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@Autowired
	private ObjectMapper objectMapper;

	@PostConstruct
	public void loadMatchData() throws Exception {
		System.out.println("Dataloading started");

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		try {
			List<File> files = Files.list(Paths.get(dirLocation)).map(Path::toFile).collect(Collectors.toList());
			for (File file : files) {
				try {
					MatchInputJson value = objectMapper.readValue(new File(file.getPath()), MatchInputJson.class);
					// System.out.println(value);
					Match match = new MatchBuilder().setId(Long.valueOf(file.getName().replace(".json", "")))
							.setCity(value.getInfo().getCity())
							.setDate(Instant.ofEpochMilli(value.getInfo().getDates().get(0).getTime())
									.atZone(ZoneId.systemDefault()).toLocalDate())
							.setPlayerOfMatch(value.getInfo().getPlayerOfMatch())
							.setOutcome(value.getInfo().getOutcome()).setTeam1(value.getInfo().getTeams().get(0))
							.setTeam2(value.getInfo().getTeams().get(1)).setVenue(value.getInfo().getVenue())
							.setTossDecision(value.getInfo().getToss().getDecision())
							.setTossWinner(value.getInfo().getToss().getWinner())
							.setOfficials(value.getInfo().getOfficials()).build();
					getMatches().add(match);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//			files.forEach(System.out::println);
		} catch (IOException e) {
			// Error while reading the directory
		}
//		try (CSVReader reader = new CSVReader(new FileReader("match-data.csv"))) {
//			List<String[]> r = reader.readAll();
//			r.forEach(x -> {
//				try {
//					Match match = new MatchBuilder().setId(Long.parseLong(x[0])).setCity(x[1])
//							.setDate(LocalDate.parse(x[2], dateFormat)).setPlayerOfMatch(x[3]).setVenue(x[4])
//							.setTeam1(x[6]).setTeam2(x[7]).setTossWinner(x[8]).setTossDecision(x[9]).setWinner(x[10])
//							.setResult(x[11]).setResultMargin(x[12]).setUmpire1(x[15]).setUmpire2(x[16]).build();
//					getMatches().add(match);
//					getMatchesMap().put(match.getId(), match);
//					System.out.println("Match: " + match);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			});
//		}
		Collections.sort(getMatches());
//		System.out.println(getMatches());

	}

	public List<Venue> getVenues() {
		return venues;
	}

	public MatchInputJson getMatch(Long key) {
		try {
			MatchInputJson value = objectMapper.readValue(new File(dirLocation + "/" + key + ".json"),
					MatchInputJson.class);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
