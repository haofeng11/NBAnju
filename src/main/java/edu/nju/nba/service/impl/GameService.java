package edu.nju.nba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IGameService;

@Service
public class GameService implements IGameService{

	@Autowired
	private IGeneralDao generalDao;
	
	@Override
	public Game show(String SeasonID, String gameDate, String homeTeam,
			String guestTeam) {
		return (Game)generalDao.find4("from edu.nju.nba.bean.Game g where g.seasonId=? and g.gameDate=? and g.homeTeam=? and g.gueatTeam=?", SeasonID,gameDate,homeTeam,guestTeam);
	}

	@Override
	public TeamSingleGame showTeamSingleGame(String seasonId, String gameDate,
			String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerSingleGame showPlayerSingleGame(String seasonId,
			String gameDate, String player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerSingleGame> showAllPlayerSingleGame(String seasonId,
			String gameDate, String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> listSeasonGame(String seasonId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamSingleGame> listSeasonTeamSingleGames(String seasonId,
			String team) {
		// TODO Auto-generated method stub
		return null;
	}

}
