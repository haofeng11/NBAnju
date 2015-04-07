package edu.nju.nba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.Team;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.dao.impl.TeamDao;
import edu.nju.nba.service.ITeamService;


@Service
public class TeamService implements ITeamService{

	@Autowired
	private IGeneralDao generalDao;
	
	@Autowired
	private TeamDao teamDao;


//	@Override
//	@Transactional(readOnly = false)
//	public boolean add(Team team) {
//		generalDao.save(team);
//		return true;
//	}

	
	public Team show(String teamName) {
		return teamDao.findByName("from edu.nju.nba.bean.Team t where t.eName=?", teamName);
	}

	@Override
	public List<Team> list() {
		return generalDao.findAll(Team.class);
	}
	
}
