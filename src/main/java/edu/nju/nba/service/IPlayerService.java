package edu.nju.nba.service;

import java.util.Map;

import edu.nju.nba.bean.Player;



public interface IPlayerService {
	
	//根据球员姓名查找球员，返回球员信息
	public Map<String,Player> show(String playername);

}
