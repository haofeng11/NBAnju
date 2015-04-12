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
	



//	@Override
//	@Transactional(readOnly = false)
//	public boolean add(Team team) {
//		generalDao.save(team);
//		return true;
//	}

	
	
	public Team show(String teamName) {
		return (Team)generalDao.find("from edu.nju.nba.bean.Team t where t.cName=?", teamName);
	}


	public List<Team> list() {
		return generalDao.findAll(Team.class);
	}


	
	public TeamSeasonAverage getSeasonAverage(String teamName, String seasonID) {
		return (TeamSeasonAverage)generalDao.find2("from edu.nju.nba.bean.TeamSeasonAverage t where t.team=? and t.seasonID=?", teamName,seasonID);
	}


	@SuppressWarnings("unchecked")
	public List<TeamSeasonAverage> getSeasonAverageList(String seasonID) {
		return (List<TeamSeasonAverage>)generalDao.findList("from edu.nju.nba.bean.TeamSeasonAverage t where t.seasonID=?", seasonID);
	}


	public List<TeamSingleGame> getTeamSingleGames(String teamName,
			String seasonID) {
		
		return (List<TeamSingleGame>)generalDao.findList2("", teamName, seasonID);
	}
	
}
