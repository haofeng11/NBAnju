package edu.nju.nba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSeasonAverage;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.ITeamService;


@Service
public class TeamService implements ITeamService{

	@Autowired
	private IGeneralDao generalDao;
	
	public Team show(String teamName) {
		return (Team)generalDao.find("from edu.nju.nba.bean.Team t where t.cName=?", teamName);
	}


	public List<Team> list() {
		return generalDao.findAll(Team.class);
	}


	
	public TeamSeasonAverage getSeasonAverage(String teamName, String seasonID,String tag) {
		return (TeamSeasonAverage)generalDao.find3("from edu.nju.nba.bean.TeamSeasonAverage t where t.team=? and t.seasonID=? and tag=?", teamName,seasonID,tag);
	}


	@SuppressWarnings("unchecked")
	public List<TeamSeasonAverage> getSeasonAverageList(String seasonID,String tag) {
		return (List<TeamSeasonAverage>)generalDao.findList2("from edu.nju.nba.bean.TeamSeasonAverage t where t.seasonID=? and tag=?", seasonID,tag);
	}


	@SuppressWarnings("unchecked")
	public List<TeamSingleGame> getTeamSingleGames(String teamName,
			String seasonID,String tag) {
		
		return (List<TeamSingleGame>)generalDao.findList3("from edu.nju.nba.bean.TeamSingleGame t where t.team=? and t.seasonID=? and tag=?", teamName, seasonID,tag);
	}


	public TeamSingleGame getTeamSingleGame(String teamName, String seasonID,
			String gameDate,String tag) {
		
		return (TeamSingleGame)generalDao.find4("from edu.nju.nba.bean.TeamSingleGame t where t.team=? and t.seasonID=? and t.gameDate=? and tag=?", teamName, seasonID, gameDate,tag);
	}
	
}
