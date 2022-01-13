package com.example.ipldashboardnosql.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboardnosql.model.ICity;
import com.example.ipldashboardnosql.model.ITeamCount;
import com.example.ipldashboardnosql.model.IVenueCount;
import com.example.ipldashboardnosql.model.Match;
import com.example.ipldashboardnosql.model.MatchInputJson;
import com.example.ipldashboardnosql.model.Page;
import com.example.ipldashboardnosql.model.PageBuilder;
import com.example.ipldashboardnosql.model.Team;
import com.example.ipldashboardnosql.service.DataService;

@Service
public class MatchRepository {
	@Autowired
	private DataService dataService;

	// @Query("SELECT c.team1 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team1 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team1 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team1 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team1 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team1 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team2 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team1 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team1 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team1 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team1 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c GROUP BY c.team1
	// ORDER BY c.team1")
	public List<ITeamCount> countTotalMatchesByTeam1() {
		return null;
	}

	// @Query("SELECT c.team2 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team2 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team2 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team2 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team2 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team2 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team1 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team2 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team2 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team2 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team2 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c GROUP BY c.team2
	// ORDER BY c.team2")
	// public List<ITeamCount> countTotalMatchesByTeam2() {
	// return null;
	// }

	// @Query("SELECT c.team1 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team1 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team1 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team1 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team1 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team1 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team2 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team1 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team1 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team1 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team1 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 GROUP BY c.team1 ORDER BY c.team1")
	public Team countTotalMatchesByTeam1(String team1, int i, int pAGE_SIZE) {
		Team team = new Team();
		List<Match> matches = new ArrayList<>();
		Stream<Match> temp = dataService.getMatches().parallelStream()
				.filter(x -> x.getTeam1().equalsIgnoreCase(team1)
						|| x.getTeam2().equalsIgnoreCase(team1));
		temp.forEach(x -> {
			matches.add(x);
			team.setTotalMatches(team.getTotalMatches() + 1);
			if (x.getWinner() == null) {
				team.setTotalNoResult(team.getTotalNoResult() + 1);
			}
			if (x.getWinner() != null
					&& x.getWinner().equalsIgnoreCase(team1)) {
				team.setTotalWins(team.getTotalWins() + 1);
			}
		});
		Collections.reverse(matches);
		System.out.println(matches);
		if (matches != null && !matches.isEmpty()) {
			int totalPages = (matches.size() / pAGE_SIZE) + 1;
			int offset = i * pAGE_SIZE;
			if (i > totalPages - 1) {
				offset = (totalPages - 1) * pAGE_SIZE;
			}
			int totalElements = matches.size();
			Page<Match> page = new PageBuilder<Match>()
					.setContent(matches.subList(offset, pAGE_SIZE))
					.setNumber(offset / pAGE_SIZE)
					.setNumberOfElements(matches.size())
					.setTotalElements(getTotalMatches())
					.setTotalPages(totalPages).setTotalElements(totalElements)
					.build();
			team.setMatches(page);
		}
		return team;
	}

	// @Query("SELECT c.team2 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team2 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team2 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team2 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team2 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team2 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team1 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team2 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team2 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team2 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team2 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team2=:team2 GROUP BY c.team2 ORDER BY c.team2")
	// private List<ITeamCount> countTotalMatchesByTeam2(String team2) {
	// return null;
	// }

	// @Query("SELECT c.team1 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team1 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team1 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team1 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team1 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team1 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team2 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team1 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team1 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team1 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team1 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 and c.venue=:venue GROUP BY c.team1 ORDER BY c.team1")
	public List<ITeamCount> countTotalMatchesByTeam1AndVenue(String team1,
			String venue) {
		return null;
	}

	// @Query("SELECT c.team2 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team2 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team2 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team2 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team2 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team2 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team1 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team2 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team2 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team2 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team2 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team2=:team2 and c.venue=:venue GROUP BY c.team2 ORDER BY c.team2")
	public List<ITeamCount> countTotalMatchesByTeam2AndVenue(String team2,
			String venue) {
		return null;
	}

	// @Query("SELECT c.team1 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team1 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team1 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team1 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team1 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team1 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team2 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team1 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team1 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team1 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team1 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 and c.team2=:team2 GROUP BY c.team1 ORDER BY c.team1")
	public List<ITeamCount> countTotalMatchesByTeam1AndTeam2(String team1,
			String team2) {
		return null;
	}

	// @Query("SELECT c.team2 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team2 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team2 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team2 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team2 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team2 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team1 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team2 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team2 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team2 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team2 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 and c.team2=:team2 GROUP BY c.team2 ORDER BY c.team2")
	public List<ITeamCount> countTotalMatchesByTeam2AndTeam1(String team1,
			String team2) {
		return null;
	}

	// @Query("SELECT c.team1 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team1 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team1 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team1 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team1 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team1 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team2 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team1 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team1 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team1 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team1 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 and c.team2=:team2 and c.venue=:venue GROUP BY c.team1
	// ORDER BY c.team1")
	public List<ITeamCount> countTotalMatchesByTeam1AndTeam2AndVenue(
			String team1, String team2, String venue) {
		return null;
	}

	// @Query("SELECT c.team2 as teamName, COUNT(c.id) as totalMatches, sum(case
	// when c.winner=c.team2 then 1 else 0 end) AS totalWins, sum(case when
	// c.result='tie' then 1 else 0 end) AS totalTies, sum(case when
	// c.result='NA' then 1 else 0 end) AS totalNoResult, sum(case when
	// c.tossWinner=c.team2 then 1 else 0 end) AS totalTossWins, sum(case when
	// c.tossWinner=c.team2 and c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossWinner=c.team2 and
	// c.tossDecision='field' then 1 else 0 end) AS totalTossWinFieldFirst,
	// sum(case when (c.tossWinner=c.team2 and c.tossDecision='bat') OR
	// (c.tossWinner=c.team1 and c.tossDecision='field') then 1 else 0 end) AS
	// totalBatFirst, sum(case when (c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field') then 1 else 0 end) AS totalFieldFirst, sum(case
	// when c.winner=c.team2 and ((c.tossWinner=c.team2 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team1 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsBatFirst,
	// sum(case when c.winner=c.team2 and ((c.tossWinner=c.team1 and
	// c.tossDecision='bat') OR (c.tossWinner=c.team2 and
	// c.tossDecision='field')) then 1 else 0 end) AS totalWinsFieldFirst,
	// sum(case when c.winner=c.team2 and c.result='runs' then 1 else 0 end) AS
	// totalWinsByRuns, sum(case when c.winner=c.team2 and c.result='wickets'
	// then 1 else 0 end) AS totalWinsByWikets FROM Match AS c where
	// c.team1=:team1 and c.team2=:team2 and c.venue=:venue GROUP BY c.team2
	// ORDER BY c.team2")
	public List<ITeamCount> countTotalMatchesByTeam2AndTeam1AndVenue(
			String team1, String team2, String venue) {
		return null;
	}

	// @Query("SELECT c.venue as venueName, c.city as city, COUNT(c.id) as
	// totalMatches, sum(case when c.result='runs' OR c.result='wickets' then 1
	// else 0 end) AS totalWins, sum(case when c.result='tie' then 1 else 0 end)
	// AS totalTies, sum(case when c.result='NA' then 1 else 0 end) AS
	// totalNoResult, sum(case when c.tossDecision='bat' then 1 else 0 end) AS
	// totalTossWinBatFirst, sum(case when c.tossDecision='field' then 1 else 0
	// end) AS totalTossWinFieldFirst, sum(case when c.winner=c.tossWinner and
	// c.tossDecision='bat' then 1 else 0 end) AS totalWinsBatFirst, sum(case
	// when c.winner=c.tossWinner and c.tossDecision='field' then 1 else 0 end)
	// AS totalWinsFieldFirst, sum(case when c.result='runs' then 1 else 0 end)
	// AS totalWinsByRuns, sum(case when c.result='wickets' then 1 else 0 end)
	// AS totalWinsByWikets FROM Match AS c GROUP BY c.venue,c.city ORDER BY
	// c.venue,c.city")
	public List<IVenueCount> countTotalMatchesByVenue() {
		return null;
	}

	// @Query("SELECT team1 as team1, team2 as team2 FROM Match where city !=
	// 'NA' and venue=:venue order by team1, team2")
	public List<ICity> getTeam1ByVenueOrderByTeam1(String venue) {
		return null;
	}

	public Page<Match> getByTeam1OrTeam2OrderByDateDesc(String team1,
			String team2, int cp, int pageSize) {
		return null;
	}

	public Page<Match> getByOrderByDateDesc(int i, int pAGE_SIZE) {
		int totalPages = getTotalMatchesPages(pAGE_SIZE);
		int offset = i * pAGE_SIZE;
		if (i > totalPages - 1) {
			offset = (totalPages - 1) * pAGE_SIZE;
		}
		List<Match> matches = dataService.getMatches().stream().skip(offset)
				.limit(pAGE_SIZE).collect(Collectors.toList());
		if (matches != null && !matches.isEmpty()) {
			int totalElements = dataService.getMatches().size();
			Page<Match> page = new PageBuilder<Match>().setContent(matches)
					.setNumber(offset / pAGE_SIZE)
					.setNumberOfElements(matches.size())
					.setTotalElements(getTotalMatches())
					.setTotalPages(totalPages).setTotalElements(totalElements)
					.build();
			return page;
		}
		return null;
	}

	public Page<Match> getByVenueOrderByDateDesc(String venue, int cp,
			int pAGE_SIZE) {
		return null;
	}

	public Page<Match> getByVenueAndTeam1OrVenueAndTeam2OrderByDateDesc(
			String venue, String team1, String venue2, String team2, int cp,
			int pageSize) {
		return null;
	}

	public Page<Match> getByTeam1AndTeam2OrTeam2AndTeam1OrderByDateDesc(
			String team1, String team2, String team3, String team4, int cp,
			int pageSize) {
		return null;
	}

	public Page<Match> getByVenueAndTeam1AndTeam2OrVenueAndTeam2AndTeam1OrderByDateDesc(
			String venue, String team1, String team2, String venue1,
			String team3, String team4, int cp, int pageSize) {
		return null;
	}

	// @Query("select DISTINCT(venue) as venues from Match where city != 'NA'
	// AND ((team1=:team1) OR (team2=:team2))")
	public List<String> findCity(String team1, String team2) {
		return null;
	}

	// @Query("select DISTINCT(venue) as venues from Match where city != 'NA'
	// AND ((team1=:team1 AND team2=:team2) OR (team1=:team3 AND
	// team2=:team4))")
	public List<String> findCity(String team1, String team2, String team3,
			String team4) {
		return null;
	}

	public MatchInputJson findById(Long key) {
		return dataService.getMatch(key);
	}

	public int getTotalMatches() {
		return dataService.getMatches().size();
	}

	public int getTotalMatchesPages(int pAGE_SIZE) {
		return (dataService.getMatches().size() / pAGE_SIZE) + 1;
	}
}
