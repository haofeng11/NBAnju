package edu.nju.nba.dao;

import edu.nju.nba.bean.Team;

public interface ITeamDao {
	
	//根据球队名称查询球队
	public Team findByName(String queryString , Object value);

}
