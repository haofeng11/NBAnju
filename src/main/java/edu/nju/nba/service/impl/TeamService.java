package edu.nju.nba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.Team;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.ITeamService;


@Service
public class TeamService implements ITeamService{

	@Autowired
	private IGeneralDao generalDao;


	@Override
	@Transactional(readOnly = false)
	public boolean add(Team team) {
		generalDao.save(team);
		return true;
	}

	@Override
	public Team show(Team team) {
		return generalDao.findById(Team.class, team.getTeamID());
	}

	@Override
	public List<Team> list() {
		return generalDao.findAll(Team.class);
	}
	
}
