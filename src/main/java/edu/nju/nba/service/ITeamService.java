package edu.nju.nba.service;

import java.util.List;

import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSeasonAverage;
import edu.nju.nba.bean.TeamSingleGame;

public interface ITeamService {

	// 添加球队
	//public boolean add(Team team);

	// 根据球队名称查找球队，返回球队基本信息
	public Team show(String teamName);

	// 查找所有球队基本信息
	public List<Team> list();
	
	//根据球队名称和赛季ID查询某个球队某个赛季的平均数据
	public TeamSeasonAverage getSeasonAverage(String teamName,String seasonID);
	
	//根据赛季ID得到该赛季所有球队
	public List<TeamSeasonAverage> getSeasonAverageList(String seasonID);
	
	//根据球队名称，赛季ID得到某个赛季，某个球队所有比赛场次
	public List<TeamSingleGame> getTeamSingleGames(String teamName,String seasonID);
	
	//根据球队名称，赛季ID,比赛日期得到某场比赛数据
	public TeamSingleGame getTeamSingleGame(String teamName,String seasonID,String gameDate);
}
