package edu.nju.nba.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.GameSchedule;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.TeamSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IGameService;

@Service
public class GameService implements IGameService {

	@Autowired
	private IGeneralDao generalDao;
	
	@Override
	public Game show(String seasonId, String gameDate, String homeTeam,
			String guestTeam) {

		return (Game)generalDao.find4("from edu.nju.nba.bean.Game g where g.seasonID=? and g.gameDate=? and g.homeTeam=? and g.guestTeam=?", seasonId,gameDate,homeTeam,guestTeam);

	}

	@Override
	public TeamSingleGame showTeamSingleGame(String seasonId, String gameDate,
			String team) {
		return (TeamSingleGame)generalDao.find3("From edu.nju.nba.bean.TeamSingleGame tg where tg.seasonID=? and tg.gameDate=? and tg.team=?", seasonId, gameDate, team);
	}

	@Override
	public PlayerSingleGame showPlayerSingleGame(String seasonId,
			String gameDate, String player) {
		return (PlayerSingleGame)generalDao.find3("From edu.nju.nba.bean.PlayerSingleGame pg where pg.seasonID=? and pg.gameDate=? and pg.player=?", seasonId, gameDate, player);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerSingleGame> showAllPlayerSingleGame(String seasonId,
			String gameDate, String team) {
		return (List<PlayerSingleGame>)generalDao.findList3("From edu.nju.nba.bean.PlayerSingleGame pg where pg.seasonID=? and pg.gameDate=? and pg.team=?", seasonId, gameDate, team);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamSingleGame> listSeasonTeamSingleGames(String seasonId,
			String team) {
		return (List<TeamSingleGame>)generalDao.findList2("From edu.nju.nba.bean.TeamSingleGame tsg where tsg.seasonID=? and gs.team=?", seasonId, team);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GameSchedule> listGameByDay(String seasonId, String gameDate) {
		return (List<GameSchedule>)generalDao.findList2("From edu.nju.nba.bean.GameSchedule gs where gs.seasonId=? and gs.gameDate=?", seasonId, gameDate);
	}

	@SuppressWarnings("unchecked")
	public List<Game> getGames(String homeTeam, String guestTeam) {
		return (List<Game>)generalDao.findList2("From edu.nju.nba.bean.Game g where g.homeTeam=? and gs.guestTeam=?", homeTeam, guestTeam);
	}

}
