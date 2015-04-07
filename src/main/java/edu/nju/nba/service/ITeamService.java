package edu.nju.nba.service;

import java.util.List;

import edu.nju.nba.bean.Team;

public interface ITeamService {

	// 添加球队
	public boolean add(Team team);

	// 根据球队ID查找球队，返回球队基本信息
	public Team show(Team team);

	// 查找所有球队基本信息
	public List<Team> list();
}