package edu.nju.nba.service;

import java.util.List;

import edu.nju.nba.bean.Team;
import edu.nju.nba.bean.TeamSeasonAverage;

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
}
