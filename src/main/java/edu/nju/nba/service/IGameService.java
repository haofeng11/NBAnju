package edu.nju.nba.service;

import java.util.List;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.GameSchedule;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.TeamGameRecord;
import edu.nju.nba.bean.TeamSingleGame;

public interface IGameService {
	
	//根据GameID查询Game
	public Game getGameByID(String GameID);

	// 查询某场比赛基本信息（game类中字段）
	public Game show(String seasonId, String gameDate, String homeTeam,
			String guestTeam);
	
	//根据主队名和客队名找到两只球队的交手记录
	public List<Game> getGames(String homeTeam,String guestTeam);

	// //查询某场比赛球队数据
	public TeamSingleGame showTeamSingleGame(String seasonId, String gameDate,
			String team);

	// 查询某场比赛球员数据
	public PlayerSingleGame showPlayerSingleGame(String seasonId,
			String gameDate, String player);

	// 查询某场比赛所有球员数据怎么玩?（需要么）
	public List<PlayerSingleGame> showAllPlayerSingleGame(String seasonId,
			String gameDate, String team);

	// 查询某球队单赛季所有比赛数据
	public List<TeamSingleGame> listSeasonTeamSingleGames(String seasonId,
			String team);

	// 根据赛季、日期查询某一天的比赛列表
	public List<GameSchedule> listGameByDay(String seasonId, String gameDate);

	//查询某赛季联盟排名
	public List<TeamGameRecord> listFederalBoard(String seasonId);
	public List<TeamGameRecord> getRegularEastRank(String seasonId);
	public List<TeamGameRecord> getRegularWestRank(String seasonId);
	public List<TeamGameRecord> getPlayoffEastRank(String seasonId);
	public List<TeamGameRecord> getPlayoffWestRank(String seasonId);

	
	//查询某日比赛列表
	public List<Game> listGameSchedule(String seasonId,String gameDate);
}
