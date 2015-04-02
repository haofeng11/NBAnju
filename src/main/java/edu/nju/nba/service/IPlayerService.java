package edu.nju.nba.service;



import java.util.List;
import java.util.Map;

import edu.nju.nba.bean.Player;



public interface IPlayerService {
	
	//添加一名球员
	public boolean add(Player player);
	
	//根据球员ID查找球员，返回球员基本信息
	public Player show(Player player);
	
	//查找所有球员基本信息
	public List<Player> list();
	

}
