package edu.nju.nba.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.nba.bean.Player;
import edu.nju.nba.bean.PlayerDataAnalysis;
import edu.nju.nba.bean.PlayerDataStatistics;
import edu.nju.nba.bean.PlayerSingleGame;
import edu.nju.nba.dao.IGeneralDao;
import edu.nju.nba.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private IGeneralDao generalDao;


	// 根据球员姓名查找球员，返回球员信息
	public Player show(String playerName) {		
		return (Player)generalDao.find("from edu.nju.nba.bean.Player where p.cName=?", playerName);
	}

	// 查找所有球员基本信息
	public List<Player> list() {
		return generalDao.findAll(Player.class);
	}

	public PlayerSingleGame getPlayerSingleGame(String playerName,
			String seasonID, String gameDate) {
		
		return (PlayerSingleGame)generalDao.find3("from edu.nju.nba.bean.PlayerSingleGame p where p.player=? and p.seasonID=? and p.gameDate=?", playerName, seasonID, gameDate);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerSingleGame> getPlayerSingleGames(String teamName,
			String seasonID, String gameDate) {
		return (List<PlayerSingleGame>)generalDao.findList3("from edu.nju.nba.bean.PlayerSingleGame p where p.team=? and p.seasonID=? and p.gameDate=?", teamName, seasonID, gameDate);
	}

	public PlayerDataStatistics getDataStatistics(String seasonID,
			String playerName,String tag) {
		return (PlayerDataStatistics)generalDao.find3("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.player=? and p.tag=?", seasonID, playerName, tag);
	}

	public PlayerDataAnalysis getDataAnalysis(String seasonID, String playerName,String tag) {
		return (PlayerDataAnalysis)generalDao.find3("from edu.nju.nba.bean.getDataAnalysis p where p.seasonID=? and p.player=? and p.tag=?", seasonID, playerName, tag);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataStatistics> getAllDataStatistics(String seasonID,String tag) {
		return (List<PlayerDataStatistics>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataStatistics p where p.seasonID=? and p.tag=?", seasonID, tag);
	}

	@SuppressWarnings("unchecked")
	public List<PlayerDataAnalysis> getAllDataAnalysis(String seasonID,String tag) {
		return (List<PlayerDataAnalysis>)generalDao.findList2("from edu.nju.nba.bean.PlayerDataAnalysis p where p.seasonID=? and p.tag=?", seasonID, tag);
	}

}
