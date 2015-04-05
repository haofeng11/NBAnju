package edu.nju.nba.service;



import java.util.List;
import java.util.Map;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;



public interface IPlayerService {
	
	//添加某一名球员基本信息
	public boolean addPlayer(Player player);
	
	//添加某一名球员某个赛季的常规赛场均基本数据
	//添加某一名球员某个赛季的常规赛场均分析数据
	//添加某一名球员某个赛季的季后赛场均基本数据
	//添加某一名球员某个赛季的季后赛场均分析数据
	
	
	
	//根据球员ID查找球员，返回球员基本信息
	public Player show(Player player);
	
	//查找所有球员基本信息
	public List<Player> list();
	
	//得到某一名球员某个赛季的常规赛场均基本数据
	//得到某一名球员某个赛季的季后赛场均基本数据
	//tag用来标记是季后赛还是常规赛 tag=1表示常规赛；tag=2表示季后赛
	public PlayerDataStatistics getDataStatistics(String seasonID,Player player,String tag);
	//得到某一名球员某个赛季的常规赛场均分析数据
	//得到某一名球员某个赛季的季后赛场均分析数据
	// 进攻能力分析：真实命中率，投篮效率，进攻篮板率，使用率，进攻效率、失误率
	// 防守能力分析：防守篮板率、抢断率、盖帽率、防守效率
	// 策应能力分析：助攻率、助攻失误比
	// 综合能力分析：WS，PER，进攻能力、防守能力、策应能力
	//tag用来标记是季后赛还是常规赛 tag=1表示常规赛；tag=2表示季后赛
	public PlayerDataAnalysis getDataAnalysis(String seasonID,Player player,String tag);
	
	//计算某一名球员的生涯常规赛场均基本数据
	//计算某一名球员的生涯季后赛场均分析数据
	
	/*
	 * 球员对比
	 * 根据球员所在球队找出比赛场次
	 * 根据比赛场次计算交手数据
	 */
	

}
