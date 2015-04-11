package edu.nju.nba.service;

import java.util.List;

import edu.nju.nba.bean.Game;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.bean.TeamSingleGame;

public interface IGameService {

	//查询某场比赛基本信息（game类中字段）
	public Game show(String SeasonID,String gameDate,String homeTeam,String guestTeam);
	
	////查询某场比赛球队数据
	public TeamSingleGame showTeamSingleGame(String seasonId,String gameDate,String team);
	
	//查询某场比赛球员数据
	public PlayerSingleGame showPlayerSingleGame(String seasonId,String gameDate,String player);
	//查询某场比赛所有球员数据怎么玩?（需要么）
	public  List<PlayerSingleGame> showAllPlayerSingleGame(String seasonId,String gameDate,String team);
	
	//查询某赛季所有比赛基本信息
	public List<Game> listSeasonGame(String seasonId);
	//查询某球队单赛季所有比赛数据
	public List<TeamSingleGame> listSeasonTeamSingleGames(String seasonId,String team);
	
	
}
