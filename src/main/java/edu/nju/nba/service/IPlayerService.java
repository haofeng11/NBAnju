package edu.nju.nba.service;



import java.util.List;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.bean.PlayerSingleGame;



public interface IPlayerService {
	
	
	//根据球员姓名查找球员，返回球员基本信息
	public Player show(String playerName);
	
	//查找所有球员基本信息
	public List<Player> list();
	
	//得到某一名球员某个赛季的常规赛场均基本数据
	//得到某一名球员某个赛季的季后赛场均基本数据
	public PlayerDataStatistics getDataStatistics(String seasonID,String playerName);
	//得到某一名球员某个赛季的常规赛场均分析数据
	//得到某一名球员某个赛季的季后赛场均分析数据
	// 进攻能力分析：真实命中率，投篮效率，进攻篮板率，使用率，进攻效率、失误率
	// 防守能力分析：防守篮板率、抢断率、盖帽率、防守效率
	// 策应能力分析：助攻率、助攻失误比
	// 综合能力分析：WS，PER，进攻能力、防守能力、策应能力
	public PlayerDataAnalysis getDataAnalysis(String seasonID,String playerName);
	//得到某个赛季所有球员的场均基本数据
	public List<PlayerDataStatistics> getAllDataStatistics(String seasonID);
	//得到某个赛季所有球员的场均分析数据
	public List<PlayerDataAnalysis> getAllDataAnalysis(String seasonID);
	
	//根据赛季ID，比赛日期，球员名字得到球员某一场比赛的数据
    public PlayerSingleGame getPlayerSingleGame(String playerName,String seasonID,String gameDate);
    
    //根据赛季ID，比赛日期，所在球队得到某一场比赛该球队所有球员的数据
    public List<PlayerSingleGame> getPlayerSingleGames(String teamName,String seasonID,String gameDate);
	
	/*
	 * 球员对比
	 * 根据球员所在球队找出比赛场次
	 * 根据比赛场次计算交手数据
	 */
	

}
